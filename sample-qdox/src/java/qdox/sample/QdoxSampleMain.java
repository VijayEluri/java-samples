package qdox.sample;

import java.io.FileReader;
import java.io.Reader;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.DocletTag;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaSource;

/**
 * @author
 */
public class QdoxSampleMain {
    public static Reader reader;


    public static void main(String[] args) throws Exception {
        getClassInfo();
    }

    public static void getSrcInfo() throws Exception {
        JavaDocBuilder builder = new JavaDocBuilder();
        builder.addSource(new FileReader("src/java/qdox/sample/SampleBean.java"));

        JavaSource src = builder.getSources()[0];
        System.out.println("パッケージ名：" + src.getPackage());

        for (int i = 0; i < src.getImports().length; i++) {
            System.out.println("インポート:" + src.getImports()[i]);
        }
    }

    public static void getClassInfo() throws Exception {
        JavaDocBuilder builder = new JavaDocBuilder();
        builder.addSource(new FileReader("src/java/qdox/sample/SampleBean.java"));

        JavaClass cls = builder.getClassByName("qdox.sample.SampleBean");

        // 基本情報
        System.out.println("パッケージ:" + cls.getPackage());
        System.out.println("クラス名:" + cls.getName());
        System.out.println("フルネーム：" + cls.getFullyQualifiedName());
        System.out.println("インターフェースか？：" + cls.isInterface());
        System.out.println("パブリッククラスか？：" + cls.isPublic());
        System.out.println("パブリッククラスか？：" + cls.isAbstract());
        System.out.println("ファイナルクラスか？" + cls.isFinal());

        // Doclet
        // クラス
        DocletTag[] tags = cls.getTags();
        for(int i=0;i<tags.length;i++){
            System.out.println("タグ名：" + tags[i].getName());
            String[] params = tags[i].getParameters();
            for(int j=0;j<params.length;j++){
                System.out.println("パラメータ：" + params[j]);
            }
        }
        // メソッド
        JavaMethod[] methods = cls.getMethods();
        for(int i=0;i<methods.length;i++){
            System.out.println("メソッド名：" + methods[i].getName());
            System.out.println("  コメント：" + methods[i].getComment());
            DocletTag[] methTags = methods[i].getTags();
            for(int j=0;j<methTags.length;j++){
                System.out.println("  タグ名：" + methTags[j].getName());
                String[] params = methTags[j].getParameters();
                for(int k=0;k<params.length;k++){
                    System.out.println("    パラメータ：" + params[k]);
                }
            }
        }
        
    }
}
