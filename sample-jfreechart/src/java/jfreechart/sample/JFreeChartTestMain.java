/*
 * �쐬��: 2005/03/30
 */
package jfreechart.sample;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;


/**
 * @author
 * JFreeChart���g�p�����A�O���t�摜�쐬�̃T���v��.
 */
public class JFreeChartTestMain {
    static final String BASE_DIR =
        "C:\\Documents and Settings\\funato\\�f�X�N�g�b�v\\";

    public static void main(String[] args) throws Exception {
        createAreaChart(getJPGOutputStream("areaChart")); // �ʃO���t
        createPieChart(getJPGOutputStream("pieChart"));
        createBarChart(getJPGOutputStream("barChart"));

        //createBarChart3D();
        System.out.println("Create End");
    }

    /**
     * �V���v���ȖʃO���t��`���T���v��
     * @param os
     * @throws Exception
     */
    public static void createAreaChart(OutputStream os) throws Exception {
        JFreeChart chart =
            ChartFactory.createAreaChart("�G���A�`���[�g", null, null,
                                         getCategoryDataSet(),
                                         PlotOrientation.VERTICAL, true, false,
                                         false);
        chart.setBackgroundPaint(Color.BLUE); // �w�i�F��ݒ肷��

        Plot plot = chart.getPlot();

        File imageFile = new File("src\\java\\graph\\images\\image.gif");
        Image image = ImageIO.read(imageFile);
        plot.setBackgroundImage(image); // �O���t�`��o�b�N�O���E���h�ɃC���[�W��\��t����
        plot.setForegroundAlpha(0.5f); // �O���t�̓��ߓx 1.0 - 0.0
        ChartUtilities.writeChartAsJPEG(os, chart, 600, 400);
    }

    /**
     * �V���v���Ȗ_�O���t��`���T���v��
     * @param os
     * @throws Exception
     */
    public static void createBarChart(OutputStream os) throws Exception {
        JFreeChart chart =
            ChartFactory.createBarChart("�o�[�`���[�g", null, null,
                                        getCategoryDataSet(),
                                        PlotOrientation.VERTICAL, true, true,
                                        false);
        ChartUtilities.writeChartAsJPEG(os, chart, 600, 400);
    }

    /**
     * 3D�Ȗ_�O���t��`���T���v��
     * @param os
     * @throws Exception
     */
    private static void createBarChart3D(OutputStream os) throws Exception {
        JFreeChart chart =
            ChartFactory.createBarChart3D("�RD�o�[�`���[�g", null, null,
                                          getCategoryDataSet(),
                                          PlotOrientation.VERTICAL, true, true,
                                          false);
        ChartUtilities.writeChartAsJPEG(os, chart, 600, 400);
    }

    private static void createSignalChart(OutputStream os) throws Exception {}

    /**
     * �V���v���ȃo�u���`���[�g��`���T���v��
     * @param os
     */
    private static void createBubbleChart(OutputStream os) throws Exception {}

    /**
     * �V���v���ȉ~�O���t��`���T���v��
     * @param os
     * @throws Exception
     */
    public static void createPieChart(OutputStream os) throws Exception {
        // �~�O���t�p�̌��f�[�^
        String[][] aryDat =
            {
                { "���ЏЉ�", "150000" },
                { "Q & A �f����", "55000" },
                { "�֘A�T�C�g", "75000" },
                { "�����^���T�[�o", "831000" },
                { "RSS�t�B�[�h", "225000" }
            };

        // �~�O���t�̌��ɂȂ�f�[�^�Z�b�g��p��
        DefaultPieDataset objDpd = new DefaultPieDataset();

        // �f�[�^�Z�b�g�ɍ��ږ��ƒl�����ɃZ�b�g
        for (int i = 0; i < aryDat.length; i++) {
            objDpd.setValue(aryDat[i][0], Integer.parseInt(aryDat[i][1]));
        }

        // �~�O���t�𐶐��i��1��������O���t�^�C�g���A
        // �f�[�^�Z�b�g�A�����\�����邩�A�c�[���`�b�v��
        // �\�����邩�AURL�𓮓I�ɐ������邩���w��j
        JFreeChart chart =
            ChartFactory.createPieChart("�T�C�g�A�N�Z�X���O", objDpd, true, true, false);

        // �o�C�i���o�̓X�g���[����JPEG�`���ŉ摜���o�́i600�~400�s�N�Z���j
        ChartUtilities.writeChartAsJPEG(os, chart, 600, 400);
    }

    /* Private Method */

    /**
     * �J�e�S���̃f�[�^�Z�b�g
     * @return
     */
    private static CategoryDataset getCategoryDataSet() {
        double[][] data =
            new double[][]{
                              { 0.1, 2.0, 3.5, 1.3, 1.9 },
                              { 1.5, 6.8, 2.4, 0.9, 2.3 },
                              { 1.9, 0.8, 2.6, 7.6, 4.3 }
            };
        CategoryDataset ds =
            DatasetUtilities.createCategoryDataset("�f�[�^��", "��", data);

        return ds;
    }

    /**
     * JPG�t�@�C���p��OutputStream��Ԃ�
     * @param fileName
     * @return
     * @throws Exception
     */
    private static OutputStream getJPGOutputStream(String fileName)
                                            throws Exception {
        OutputStream os =
            new FileOutputStream(new File(BASE_DIR + fileName + ".jpg"));

        return os;
    }
}
