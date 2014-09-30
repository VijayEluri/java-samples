// Copyright(c) 2006 ATL Systems, Incorporated.
//
//
package sample.woodstox;

import junit.framework.TestCase;

/**
 * StAX�̃T���v���̃e�X�g
 * @version $Revision$
 * @author $Author$
 */
public class ParseSampleTest extends TestCase {
	
	/**
	 * �T���v��
	 */
	private static ParseSample sample = new ParseSample();

	/**
	 * �J�[�\�����[�h
	 */
	public void testCursorRead() throws Exception {
		sample.cursorRead();
	}

	/**
	 * �C�x���g���[�h
	 */
	public void testEventRead() throws Exception {
		sample.eventRead();
	}

	/**
	 * �C�x���g�t�B���^�[���[�h
	 */
	public void testEventFilterRead() throws Exception {
		sample.eventFilterRead();
	}

	/**
	 * �J�[�\�����C�g
	 */
	public void testCursorWrite() throws Exception {
		sample.cursorWrite();
	}

	/**
	 * �C�x���g���C�g
	 */
	public void testEventWrite() throws Exception {
		sample.eventWrite();
	}

}
