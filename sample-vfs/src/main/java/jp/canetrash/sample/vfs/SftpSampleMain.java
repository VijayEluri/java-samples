package jp.canetrash.sample.vfs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.UserAuthenticator;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.auth.StaticUserAuthenticator;
import org.apache.commons.vfs2.impl.DefaultFileSystemConfigBuilder;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;
import org.codehaus.plexus.util.IOUtil;

/**
 * 
 * SFTPを利用したファイル取得のサンプル
 * 
 * SFTP<br/>
 * Provides access to the files on an SFTP server (that is, an SSH or SCP
 * server).<br/>
 * URI Format<br/>
 * sftp://[ username[: password]@] hostname[: port][ absolute-path]<br/>
 * Examples<br/>
 * sftp://myusername:mypassword@somehost/pub/downloads/somefile.tgz<br/>
 * 
 * @author tfunato
 * 
 */
public class SftpSampleMain {

	public static void main(String[] args) throws Exception {
		SftpSampleMain main = new SftpSampleMain();
		main.getFile();
	}

	public void getFile() throws Exception {

		FileSystemOptions opts = new FileSystemOptions();
		UserAuthenticator auth = new StaticUserAuthenticator(null, "p2net", "p2net");
		DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);
		
		SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, false);

		// ファイルの読み込み
		FileSystemManager fsManager = VFS.getManager();
		FileObject remoteFile = fsManager.resolveFile("sftp://192.168.0.81/usr/local/tomcat60_p2net/webapps/p2net/WEB-INF/classes/application.properties", opts);
		//FileObject remoteFile = fsManager.resolveFile("sftp://192.168.0.81/../../usr/local/tomcat60_p2net/webapps/p2net/WEB-INF/classes/application.properties", opts);
		System.out.println(remoteFile.exists());

		// ファイルの書き出し
		InputStream inputStream = remoteFile.getContent().getInputStream();
		IOUtil.copy(inputStream, new FileOutputStream(new File("application.properties")));
	}
}
