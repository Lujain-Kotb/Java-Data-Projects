package com.mycompany.wuzzuffinal;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import smile.clustering.KMeans;
import smile.clustering.PartitionClustering;
import smile.data.DataFrame;
import smile.data.measure.NominalScale;
import smile.data.vector.IntVector;
import smile.plot.swing.Canvas;
import smile.plot.swing.ScatterPlot;

import javax.swing.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WuzzufDao {
    public Map<String,Long> companies(DataFrame dataFrame){
        List<String> allSkills=new ArrayList<>();
        String[] skill = dataFrame.stringVector("company").toArray();
        for (String r : skill){
            allSkills.add(r);
        }
        Map<String, Long> counted = allSkills.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> result = counted.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }
    public Map<String,Long> jobs(DataFrame dataFrame) {
        List<String> allSkills = new ArrayList<>();
        String[] skill = dataFrame.stringVector("title").toArray();
        for (String r : skill) {
            allSkills.add(r);
        }
        Map<String, Long> counted = allSkills.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> result = counted.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }
    public Map<String,Long> areas(DataFrame dataFrame) {
        List<String> allSkills = new ArrayList<>();
        String[] skill = dataFrame.stringVector("location").toArray();
        for (String r : skill) {
            allSkills.add(r);
        }
        Map<String, Long> counted = new HashMap<>();
                counted=allSkills.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> result = new HashMap<>();
        result=counted.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }
    public JFrame pieChart(Map<String,Long> companies) {
        List<String> keys=new LinkedList<>();
        List<Long> values=new LinkedList<>();
        int i=1;
        for (Map.Entry<String, Long> pair : companies.entrySet()) {
//            System.out.println(pair.getKey());
            keys.add(pair.getKey());
            values.add(pair.getValue());
            i++;
            if (i>10)
                break;
//            List<Long> values= pair.getValue();
        }
        PieChart chart =
                new PieChartBuilder().width(800).height(600).title("Pie Chart with 10 Slices").build();

        // Customize Chart
        chart.getStyler().setCircular(false);

        // Series
        chart.addSeries(keys.get(0), values.get(0));
        chart.addSeries(keys.get(1), values.get(1));
        chart.addSeries(keys.get(2), values.get(2));
        chart.addSeries(keys.get(3), values.get(3));
        chart.addSeries(keys.get(4), values.get(4));
        chart.addSeries(keys.get(5), values.get(5));
        chart.addSeries(keys.get(6), values.get(6));
        chart.addSeries(keys.get(7), values.get(7));
        chart.addSeries(keys.get(8), values.get(8));
        chart.addSeries(keys.get(9), values.get(9));

//        chart.addSeries("Others", 1533-(590+39+35+34+25));

        return new SwingWrapper(chart).displayChart();
    }
    public JFrame barChart_Jobs(Map<String,Long> job){
        List<String> keys=new LinkedList<>();
        List<Long> values=new LinkedList<>();
        int i=1;
        for (Map.Entry<String, Long> pair : job.entrySet()) {
//            System.out.println(pair.getKey());
            keys.add(pair.getKey());
            values.add(pair.getValue());
            i++;
            if (i>10)
                break;
//            List<Long> values= pair.getValue();
        }
        //Using XCartto graph the Ages 1.Create Chart
        CategoryChart chart = new CategoryChartBuilder().width (1024).height (768).title ("Jobs Histogram").xAxisTitle("Jobs").yAxisTitle("no of jobs offered").build ();
        // 2.Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        // 3.Series
        chart.addSeries("JOBS", keys, values);
        // 4.Show it
        return new SwingWrapper(chart).displayChart();
    }
    public JFrame barChart_areas(Map<String,Long> area){
        List<String> keys=new LinkedList<>();
        List<Long> values=new LinkedList<>();
        int i=1;
        for (Map.Entry<String, Long> pair : area.entrySet()) {
//            System.out.println(pair.getKey());
            keys.add(pair.getKey());
            values.add(pair.getValue());
            i++;
            if (i>10)
                break;
//            List<Long> values= pair.getValue();
        }
        //Using XCartto graph the Ages 1.Create Chart
        CategoryChart chart = new CategoryChartBuilder().width (1024).height (768).title ("Locations Histogram").xAxisTitle("Location").yAxisTitle("no of jobs offered").build ();
        // 2.Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        // 3.Series
        chart.addSeries("Location", keys, values);
        // 4.Show it
        return new SwingWrapper(chart).displayChart();
    }
    public String yearsOfExperience(DataFrame df) throws Exception {

        String[] years = df.stringVector("yearsExp").distinct().toArray(new String[]{});
        int[] pclassYear = df.stringVector("yearsExp").factorize(new NominalScale(years)).toIntArray();
        df = df.merge(IntVector.of("yearsExpNew", pclassYear));
        return df.toString(df.nrows());
    }
    public String mostImpSkills(DataFrame df) {
        List <String>allSkills=new ArrayList<>();
        String[] skill = df.stringVector("skills").distinct().toArray(new String[]{});
        for (String r : skill)
            for (String d : r.split(",")) {
                d = d.trim();
                allSkills.add(d);
            }
        Map<String, Long> counted = allSkills.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> result = counted.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        List<String> s=new LinkedList<>();
        for (Map.Entry<String, Long> pair : result.entrySet()) {
            s.add(String.format("Skill is: %s, Value is : %s", pair.getKey(), pair.getValue()));
        }
//        System.out.println(s.get(0));

        return s.get(0)+"\n"+s.get(1)+"\n"+s.get(2)+"\n"+s.get(3)+"\n"+s.get(4)+"\n"+s.get(5)+"\n"+s.get(6)+"\n"+s.get(7)+"\n"+s.get(8)+"\n"+s.get(9);
    }

    private int[] Encoder(DataFrame df, String columnName){
        String[] values = df.stringVector(columnName).distinct().toArray(new String[]{});
        int[] transformedValues = df.stringVector(columnName).factorize(new NominalScale(values)).toIntArray();
        return transformedValues;
    }

    public void runKmeans(int nclusters) throws Exception{
        DataFrame data = JobProvider.getJobDataFrame();
        DataFrame df = data.select("company","title");
        DataFrame train_df = DataFrame.of(IntVector.of("company",Encoder(df,"company")));
        train_df= train_df.merge(IntVector.of("title",Encoder(df,"title")));
        final DataFrame df_f = train_df ;
        KMeans clusters = PartitionClustering.run(20, () -> KMeans.fit(df_f.toArray(), nclusters));
        Canvas canvas = ScatterPlot.of(train_df.toArray(),clusters.y, '.').canvas();
        canvas.setAxisLabels("company", "title");
        canvas.window();
    }
}
