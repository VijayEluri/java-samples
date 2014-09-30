// Copyright(c) 2006 ATL Systems, Incorporated.
//
//
package sample.woodstox;

import junit.framework.TestCase;

/**
 * StAXのサンプルのテスト
 * @version $Revision$
 * @author $Author$
 */
public class ParseSampleTest extends TestCase {
	
	/**
	 * サンプル
	 */
	private static ParseSample sample = new ParseSample();

	/**
	 * カーソルリード
	 */
	public void testCursorRead() throws Exception {
		sample.cursorRead();
	}

	/**
	 * イベントリード
	 */
	public void testEventRead() throws Exception {
		sample.eventRead();
	}

	/**
	 * イベントフィルターリード
	 */
	public void testEventFilterRead() throws Exception {
		sample.eventFilterRead();
	}

	/**
	 * カーソルライト
	 */
	public void testCursorWrite() throws Exception {
		sample.cursorWrite();
	}

	/**
	 * イベントライト
	 */
	public void testEventWrite() throws Exception {
		sample.eventWrite();
	}

}
