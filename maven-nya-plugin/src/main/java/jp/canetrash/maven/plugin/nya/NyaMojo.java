package jp.canetrash.maven.plugin.nya;

import java.io.BufferedInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Maven Nya Plugin
 * 
 * @goal nya
 */
public class NyaMojo extends AbstractMojo {

	private static final String SOUND_FILE_NAME = "/nya.mp3";

	public void execute() throws MojoExecutionException, MojoFailureException {
		playNyaaaa();
	}

	public void playNyaaaa() {
		Player player = null;
		printNya();
		try {
			BufferedInputStream is = new BufferedInputStream(this.getClass()
					.getResourceAsStream(SOUND_FILE_NAME));
			player = new Player(is);
			player.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		} finally {
			if (player != null) {
				player.close();
			}
		}
	}

	private void printNya() {
		getLog().info("　　　　　　　　　　..｡＊+　*　　　　　　　　　　　　。*。 ");
		getLog().info("　　　　　　..ﾟ..*+。*★*　。＊　　　　　　　　。*★*｡+*＊∵ ");
		getLog().info("　　　　。.ﾟ+ﾟ☆ﾟ*　　∵☆*．＊　　　　．.*.☆∵　　..∵☆ﾟ+.ﾟ・ ");
		getLog().info("　　　。★。ﾟ　　　　 ,-､..。★.ﾟ　＊　　ﾟ.★.-､　　　．ﾟ..★＊ ");
		getLog().info("　　ﾟ*☆＊　　　　 ./::::＼∵☆*.. .∵*☆∵／::::ヽ　　　　*..ﾟ☆ﾟ ");
		getLog().info("　＋★。　　　　　/:::::::;ゝ--─ .､._/::::::::|　　　 ..。★＊ ");
		getLog().info("ﾟ*☆＊　　　　　 /,.-‐''`´ 　　　　　　 ＼::::::| 　　　　..☆ﾟ∵ ");
		getLog().info("。★*.ﾟ.ﾟ　　　／　 　　　　　　　　　　　　　ヽ､::|　　　 ....*★＊ ");
		getLog().info(". 。☆＊ 　　/　　　 　　　　　　　　　　　　　　　ヽ　　　。..ﾟ☆ﾟ* ");
		getLog().info("　。★。　　 l　　　　／　　　　　　 　 　 　 　　　l　　 ..。★＊ ");
		getLog().info("　ﾟ*ﾟ☆＊ . |　　　 ⌒　　　　　　　　　　　＼　　 |　　 ....☆ﾟ∵ ");
		getLog().info("　　　。★ 　l　　, , ,　　　　　　　　　　　⌒　　 l　　∵★＊ ");
		getLog().info("　　　ﾟ*..☆*` ､　　　　　　(_人__丿　　　　､､､  / 　　ﾟ☆ﾟ∵ ");
		getLog().info("　　　　。★。　`ｰ ､__　　　　　　　 　 　　　 ／ 。★＊ ");
		getLog().info("　　　　 ∵*ﾟ☆＊ 　 /`'''ｰ‐‐──‐‐‐┬'''''´..☆ﾟ∵ ");
		getLog().info("　　　　　　。★∵./　　　 　 ___l　。★＊。 ");
		getLog().info("　　　　　　　　ﾟ＊☆ ./　　／　 |.-､☆ﾟ∵ ");
		getLog().info("　　　　　　　　　　　ﾟ.*☆*☆∵ ");

	}
}
