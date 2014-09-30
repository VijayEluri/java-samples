/*
 * 作成日: 2005/03/30
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
 * JFreeChartを使用した、グラフ画像作成のサンプル.
 */
public class JFreeChartTestMain {
    static final String BASE_DIR =
        "C:\\Documents and Settings\\funato\\デスクトップ\\";

    public static void main(String[] args) throws Exception {
        createAreaChart(getJPGOutputStream("areaChart")); // 面グラフ
        createPieChart(getJPGOutputStream("pieChart"));
        createBarChart(getJPGOutputStream("barChart"));

        //createBarChart3D();
        System.out.println("Create End");
    }

    /**
     * シンプルな面グラフを描くサンプル
     * @param os
     * @throws Exception
     */
    public static void createAreaChart(OutputStream os) throws Exception {
        JFreeChart chart =
            ChartFactory.createAreaChart("エリアチャート", null, null,
                                         getCategoryDataSet(),
                                         PlotOrientation.VERTICAL, true, false,
                                         false);
        chart.setBackgroundPaint(Color.BLUE); // 背景色を設定する

        Plot plot = chart.getPlot();

        File imageFile = new File("src\\java\\graph\\images\\image.gif");
        Image image = ImageIO.read(imageFile);
        plot.setBackgroundImage(image); // グラフ描画バックグラウンドにイメージを貼り付ける
        plot.setForegroundAlpha(0.5f); // グラフの透過度 1.0 - 0.0
        ChartUtilities.writeChartAsJPEG(os, chart, 600, 400);
    }

    /**
     * シンプルな棒グラフを描くサンプル
     * @param os
     * @throws Exception
     */
    public static void createBarChart(OutputStream os) throws Exception {
        JFreeChart chart =
            ChartFactory.createBarChart("バーチャート", null, null,
                                        getCategoryDataSet(),
                                        PlotOrientation.VERTICAL, true, true,
                                        false);
        ChartUtilities.writeChartAsJPEG(os, chart, 600, 400);
    }

    /**
     * 3Dな棒グラフを描くサンプル
     * @param os
     * @throws Exception
     */
    private static void createBarChart3D(OutputStream os) throws Exception {
        JFreeChart chart =
            ChartFactory.createBarChart3D("３Dバーチャート", null, null,
                                          getCategoryDataSet(),
                                          PlotOrientation.VERTICAL, true, true,
                                          false);
        ChartUtilities.writeChartAsJPEG(os, chart, 600, 400);
    }

    private static void createSignalChart(OutputStream os) throws Exception {}

    /**
     * シンプルなバブルチャートを描くサンプル
     * @param os
     */
    private static void createBubbleChart(OutputStream os) throws Exception {}

    /**
     * シンプルな円グラフを描くサンプル
     * @param os
     * @throws Exception
     */
    public static void createPieChart(OutputStream os) throws Exception {
        // 円グラフ用の元データ
        String[][] aryDat =
            {
                { "書籍紹介", "150000" },
                { "Q & A 掲示板", "55000" },
                { "関連サイト", "75000" },
                { "レンタルサーバ", "831000" },
                { "RSSフィード", "225000" }
            };

        // 円グラフの元になるデータセットを用意
        DefaultPieDataset objDpd = new DefaultPieDataset();

        // データセットに項目名と値を順にセット
        for (int i = 0; i < aryDat.length; i++) {
            objDpd.setValue(aryDat[i][0], Integer.parseInt(aryDat[i][1]));
        }

        // 円グラフを生成（第1引数からグラフタイトル、
        // データセット、判例を表示するか、ツールチップを
        // 表示するか、URLを動的に生成するかを指定）
        JFreeChart chart =
            ChartFactory.createPieChart("サイトアクセスログ", objDpd, true, true, false);

        // バイナリ出力ストリームにJPEG形式で画像を出力（600×400ピクセル）
        ChartUtilities.writeChartAsJPEG(os, chart, 600, 400);
    }

    /* Private Method */

    /**
     * カテゴリのデータセット
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
            DatasetUtilities.createCategoryDataset("データ名", "軸", data);

        return ds;
    }

    /**
     * JPGファイル用のOutputStreamを返す
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
