package jp.canetrash.sample.classloader;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import static org.junit.Assume.*;
// assertThat�ɓn�����\�b�h�̃C���|�[�g
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

public class ClassloaderSampleTest {

    @Before
    public void before() {
        System.out.println("@Before:�e�X�g�P�[�X���Ƃɍŏ��ɌĂ΂���");
    }

    @After
    public void after() {
        System.out.println("@After:@Test���ƂɎ��s���ꂽ��ɌĂ΂��B");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass:�����͊e�e�X�g�P�[�X���Ƃɋ��ʂ̃p�����[�^���g���ꍇ�Ȃ񂩂Ɏg��");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass:���̃e�X�g�N���X�̃e�X�g�P�[�X���S���I����Ă���Ō�Ɉ�񂾂��Ă΂��");
    }

    @Test
    public void testSimple() {
        System.out.println("@Test:Hello JUNIT");
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            assumeNoException(e);
        }
        assertTrue("uhehe", false);
    }

    @Test
    @Ignore
    public void testSimple2() {
        System.out.println("@Test:Hello JUNIT2");
    }

    @Test(expected = IndexOutOfBoundsException.class, timeout = 1000)
    public void testSimple3() {
        new ArrayList<Object>().get(1);
        while (true)
            ;
    }

    // �e�X�g�Ŏg�p����p�����[�^�����p�̃��\�b�h�ɂ���
    // ���Ԃ񃌃|�[�g�p�Ńe�X�g�̓���ɉe���͂Ȃ��Ǝv���
    @Parameters
    public void createParameter() {
        System.out.println("paramter�𐶐����郁�\�b�h");
    }
    
    // assertThat���g���Ɖp��̕��@�̂悤�Ȋ�����Assertion��������
    @Test
    public void testSimple4() {
        System.out.println("assertThat�̃e�X�g");
        assertThat(1+2, is(3));
        Object obj = new Object();
        assertThat(obj, is(obj));
    }
}
