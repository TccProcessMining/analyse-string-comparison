package Util;

import Model.Result;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

public class LineChartEx extends JFrame {

    private XYSeriesCollection data_set = new XYSeriesCollection();

    public LineChartEx() {
        initUI();
    }

    public void addSerie(String name,List<Result> results){
        var series = new XYSeries(name);
        for(Result i : results){
            series.add((double) i.getId(), (double) i.getValue());
        }

        data_set.addSeries(series);
    }

    private void initUI() {

        JFreeChart chart = createChart(data_set);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Comparação");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Comparação de Metodos",
                "ID",
                "VALOR",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.GRAY);



        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Comparação de Metodos",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );
        return chart;
    }
}