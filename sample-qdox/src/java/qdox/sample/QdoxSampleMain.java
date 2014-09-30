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
        System.out.println("�p�b�P�[�W���F" + src.getPackage());

        for (int i = 0; i < src.getImports().length; i++) {
            System.out.println("�C���|�[�g:" + src.getImports()[i]);
        }
    }

    public static void getClassInfo() throws Exception {
        JavaDocBuilder builder = new JavaDocBuilder();
        builder.addSource(new FileReader("src/java/qdox/sample/SampleBean.java"));

        JavaClass cls = builder.getClassByName("qdox.sample.SampleBean");

        // ��{���
        System.out.println("�p�b�P�[�W:" + cls.getPackage());
        System.out.println("�N���X��:" + cls.getName());
        System.out.println("�t���l�[���F" + cls.getFullyQualifiedName());
        System.out.println("�C���^�[�t�F�[�X���H�F" + cls.isInterface());
        System.out.println("�p�u���b�N�N���X���H�F" + cls.isPublic());
        System.out.println("�p�u���b�N�N���X���H�F" + cls.isAbstract());
        System.out.println("�t�@�C�i���N���X���H" + cls.isFinal());

        // Doclet
        // �N���X
        DocletTag[] tags = cls.getTags();
        for(int i=0;i<tags.length;i++){
            System.out.println("�^�O���F" + tags[i].getName());
            String[] params = tags[i].getParameters();
            for(int j=0;j<params.length;j++){
                System.out.println("�p�����[�^�F" + params[j]);
            }
        }
        // ���\�b�h
        JavaMethod[] methods = cls.getMethods();
        for(int i=0;i<methods.length;i++){
            System.out.println("���\�b�h���F" + methods[i].getName());
            System.out.println("  �R�����g�F" + methods[i].getComment());
            DocletTag[] methTags = methods[i].getTags();
            for(int j=0;j<methTags.length;j++){
                System.out.println("  �^�O���F" + methTags[j].getName());
                String[] params = methTags[j].getParameters();
                for(int k=0;k<params.length;k++){
                    System.out.println("    �p�����[�^�F" + params[k]);
                }
            }
        }
        
    }
}
