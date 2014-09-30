package jp.canetrash.sample.websocket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author tfunato
 * 
 */
public class WebSocketServer {

	public WebSocketServer() {
		try {
			WS_ACCEPT = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11"
					.getBytes("ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	private Selector selector;

	private byte[] WS_ACCEPT;

	private final Queue<MessageDigest> sha1Helpers = new ConcurrentLinkedQueue<MessageDigest>();

	private List<SocketChannel> socketList = new ArrayList<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		WebSocketServer server = new WebSocketServer();
		server.service();
	}

	/**
	 * 
	 */
	public void service() {
		// サーバソケットの作成
		try {
			selector = Selector.open();

			ServerSocketChannel serverSocketChannel = SelectorProvider
					.provider().openServerSocketChannel();
			serverSocketChannel.configureBlocking(false);

			InetSocketAddress address = new InetSocketAddress(5000);
			serverSocketChannel.socket().bind(address);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

			System.out.println("Open Socket:5000");
			while (selector.select() > 0) {
				// セレクトされた SelectionKey オブジェクトをまとめて取得する
				Iterator<SelectionKey> keyIterator = selector.selectedKeys()
						.iterator();

				while (keyIterator.hasNext()) {
					// Iterator から要素を取り出し、取り出した要素は Iterator から削除する
					SelectionKey key = (SelectionKey) keyIterator.next();
					keyIterator.remove();

					// セレクトされた SelectionKey の状態に応じて処理を決める
					if (key.isAcceptable()) {
						// accept の場合の処理
						accept(key);
					} else {
						if (key.isReadable()) {
							read(key);
						}
						if (key.isWritable()) {
							write(key);
						}
					}
				}
			}
		} catch (ClosedChannelException ex) {
			System.out.println("SocketがCloseしています");
			throw new RuntimeException(ex);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				for (SelectionKey key : selector.keys()) {
					key.channel().close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void accept(SelectionKey key) throws IOException {
		ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();

		SocketChannel socketChannel = serverChannel.accept();

		// Non-Blocking モードに変更
		socketChannel.configureBlocking(false);

		// Selector への登録
		socketChannel.register(selector, SelectionKey.OP_READ);
		System.out.println(socketChannel.socket().getInetAddress()
				+ " connect.");
		socketList.add(socketChannel);
	}

	private void read(SelectionKey key) throws IOException {

		ByteBuffer readBuffer = ByteBuffer.allocateDirect(2097152); // 2M
		SocketChannel socketChannel = (SocketChannel) key.channel();

		readBuffer.clear();

		// データの読み込み
		if (socketChannel.read(readBuffer) < 0) {
			return;
		}

		readBuffer.flip();

		byte[] readed = new byte[readBuffer.limit()];
		readBuffer.get(readed);
		String req = new String(readed);

		Map<String, String> header = getHeader(req);
		// 最初のアップグレード
		if (req.contains("Sec-WebSocket-Key")) {
			System.out.println("[" + req + "]");
			StringBuilder sb = new StringBuilder();
			sb.append("HTTP/1.1 101 OK\r\n");
			sb.append("Upgrade:websocket\r\n");
			sb.append("Connection:upgrade\r\n");
			sb.append("Sec-WebSocket-Accept: "
					+ getWebSocketAccept(header.get("Sec-WebSocket-Key"))
					+ "\r\n");
			sb.append("Sec-WebSocket-Version: 13\r\n");
			sb.append("\r\n");
			socketChannel.write(ByteBuffer.wrap(sb.toString().getBytes()));
		} else {
			readBuffer.rewind();
			Frame frame = Frame.getReadFrame(readBuffer);
			System.out.println("fin:" + frame.getFin());
			System.out.println("rsv:" + frame.getRsv());
			System.out.println("opCode:" + frame.getOpCode());
			System.out.println("payloadLength:" + frame.getPayloadLength());
			String message = frame.getTextData();
			System.out.println(message);
			ByteBuffer writeData = Frame.getWriteTextData(socketChannel
					.getRemoteAddress().toString() + ":" + message);
			for (SocketChannel socket : socketList) {
				if (socket.isOpen()) {
					socket.write(writeData);
					writeData.rewind();
				} else {
					socket.finishConnect();
					socketList.remove(socket);
				}
			}
		}
	}

	private Map<String, String> getHeader(String req) {
		String[] headers = req.split("\r\n");
		Map<String, String> headerMap = new HashMap<>();
		for (String head : headers) {
			String[] str = head.split(":");
			if (str != null && str.length > 1) {
				headerMap.put(str[0], str[1].trim());
			}
		}
		return headerMap;
	}

	private void write(SelectionKey key) throws Exception {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		// // 書きこみを行う
		System.out.println("write !");

		socketChannel.register(selector, SelectionKey.OP_READ);
	}

	private String getWebSocketAccept(String key) {

		MessageDigest sha1Helper = sha1Helpers.poll();
		if (sha1Helper == null) {
			try {
				sha1Helper = MessageDigest.getInstance("SHA1");
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException();
			}
		}

		sha1Helper.reset();
		try {
			sha1Helper.update(key.getBytes("ISO_8859_1"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException();
		}
		String result = Base64.encode(sha1Helper.digest(WS_ACCEPT));
		sha1Helpers.add(sha1Helper);

		return result;
	}

}
