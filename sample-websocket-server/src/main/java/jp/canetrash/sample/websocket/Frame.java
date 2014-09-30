package jp.canetrash.sample.websocket;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class Frame {
	// OP Codes
	public static final byte OPCODE_CONTINUATION = 0x00;
	public static final byte OPCODE_TEXT = 0x01;
	public static final byte OPCODE_BINARY = 0x02;
	public static final byte OPCODE_CLOSE = 0x08;
	public static final byte OPCODE_PING = 0x09;
	public static final byte OPCODE_PONG = 0x0A;

	private boolean fin;
	private int rsv;
	private byte opCode;
	private byte[] mask = new byte[4];
	private long payloadLength;
	private ByteBuffer payload;

	private Frame() {}

	public static Frame getReadFrame(ByteBuffer buffer) {
		Frame frame = new Frame();
		// positionを0にリセット
		buffer.rewind();
		byte first = buffer.get();
		int b = first & 0xFF;
		frame.fin = (b & 0x80) > 0;
		frame.rsv = (b & 0x70) >>> 4;
		frame.opCode = (byte) (b & 0x0F);

		b = buffer.get() & 0xFF;

		// マスクされているか？
		if ((b & 0x80) == 0) {
			throw new IllegalAccessError("Client data be masked.");
		}
		// ペイロード（送信データのサイズ）
		frame.payloadLength = b & 0x7F;
		if (frame.payloadLength == 126) {
			byte[] extended = new byte[2];
			buffer.get(extended);
			frame.payloadLength = frame.byteArrayToLong(extended);
		} else if (frame.payloadLength == 127) {
			byte[] extended = new byte[8];
			buffer.get(extended);
			frame.payloadLength = frame.byteArrayToLong(extended);
		}
		// mask
		buffer.get(frame.mask);
		
		frame.payload = buffer.slice().asReadOnlyBuffer();
		return frame;
	}
	
	public static ByteBuffer getWriteTextData(String text) {
		ByteBuffer writeData = ByteBuffer.allocateDirect(2097152); // 2M
		int first  = 0x81;
		writeData.put((byte)first);
		if (text.getBytes().length < 126) {
			writeData.put((byte)text.getBytes().length);
		} else {
			writeData.put((byte)126);
			writeData.put((byte)(text.getBytes().length >>> 8));
			writeData.put((byte)(text.getBytes().length & 0xFF));
		}
		writeData.put(text.getBytes());
		writeData.flip();
		return writeData;
	}

	public boolean getFin() {
		return fin;
	}

	public int getRsv() {
		return rsv;
	}

	public byte getOpCode() {
		return opCode;
	}

	public byte[] getMask() {
		return mask;
	}

	public long getPayloadLength() {
		return payloadLength;
	}

	public ByteBuffer getPayload() {
		return payload;
	}

	/**
	 * テキストデータとして返す
	 * 
	 * @return
	 */
	public String getTextData() {
		if (opCode != OPCODE_TEXT) {
			throw new IllegalAccessError("payload is binary data.");
		}
		byte[] bytes = new byte[payload.remaining()];
		while (payload.hasRemaining()) {
			int position = payload.position();
			bytes[position] = (byte) (payload.get() ^ mask[position % 4]);
		}
		try {
			// utf-8 fixed
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// un reached
			throw new RuntimeException();
		}
	}

	private long byteArrayToLong(byte[] input) {
		if (input.length > 8) {
			throw new IllegalArgumentException();
		}

		int shift = 0;
		long result = 0;
		for (int i = input.length - 1; i >= 0; i--) {
			result = result + ((input[i] & 0xFF) << shift);
			shift += 8;
		}

		return result;
	}
}
