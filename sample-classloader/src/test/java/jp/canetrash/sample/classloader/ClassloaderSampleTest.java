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
// assertThatに渡すメソッドのインポート
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

public class ClassloaderSampleTest {

    @Before
    public void before() {
        System.out.println("@Before:テストケースごとに最初に呼ばれるよ");
    }

    @After
    public void after() {
        System.out.println("@After:@Testごとに実行された後に呼ばれる。");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass:ここは各テストケースごとに共通のパラメータを使う場合なんかに使う");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass:このテストクラスのテストケースが全部終わってから最後に一回だけ呼ばれる");
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

    // テストで使用するパラメータ生成用のメソッドにつける
    // たぶんレポート用でテストの動作に影響はないと思われ
    @Parameters
    public void createParameter() {
        System.out.println("paramterを生成するメソッド");
    }
    
    // assertThatを使うと英語の文法のような感じでAssertionが書ける
    @Test
    public void testSimple4() {
        System.out.println("assertThatのテスト");
        assertThat(1+2, is(3));
        Object obj = new Object();
        assertThat(obj, is(obj));
    }
}
