/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.titanic;

/**
 *
 * @author lujain
 */
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;
import org.apache.commons.lang3.tuple.Pair;
public class DataSetOperations {
    
    private List<TitanicPassenger> passengerList;
    
    public DataSetOperations(){
        this.passengerList = new ArrayList<>();
        parseJSONTitanic();
    }
    
    private void parseJSONTitanic(){
        ObjectMapper objectMapper= new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try{
        InputStream input = new FileInputStream ("C:\\Users\\lujai\\Documents\\NetBeansProjects\\titanic\\src\\main\\resources\\Data_to_use\\titanic_csv.json");
        this.passengerList= objectMapper.readValue(input, new TypeReference<List<TitanicPassenger>> () { });
        } catch(Exception ex) {
            ex.printStackTrace();
        }    
    }
    
    public void graphPassengerClass() {
        
        Map<String, Long> result = this.passengerList.stream()
                .collect(Collectors.groupingBy(TitanicPassenger::getPclass, Collectors.counting()));
        // Create Chart
        PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
        // Customize Chart
        Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler().setSeriesColors(sliceColors);
        // Series
        chart.addSeries("First Class", result.get("1"));
        chart.addSeries("Second Class", result.get("2"));
        chart.addSeries("Third Class", result.get("3"));
        // Show it
        new SwingWrapper(chart).displayChart();
    }
    
    public void graphPassengerAges() {
        List<Float> pAges= this.passengerList.stream().map (TitanicPassenger::getAge).limit (8).collect (Collectors.toList());
        List<String> pNames= this.passengerList.stream().map (TitanicPassenger::getName).limit (8).collect (Collectors.toList());
        //Using XCartto graph the Ages 1.Create Chart
        CategoryChart chart = new CategoryChartBuilder().width (1024).height (768).title ("Age Histogram").xAxisTitle("Names").yAxisTitle("Age").build ();
        // 2.Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        // 3.Series
        chart.addSeries("Passenger's Ages", pNames, pAges);
        // 4.Show it
        new SwingWrapper(chart).displayChart();
    }
    
    public void graphPassengerSurvived(){
        Map<String, Long> result = this.passengerList.stream()
                .collect(Collectors.groupingBy(TitanicPassenger::getSurvived, Collectors.counting()));
        // Create Chart
        PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
        // Customize Chart
        Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler().setSeriesColors(sliceColors);
        // Series
        chart.addSeries("Survived", result.get("1"));
        chart.addSeries("Not Survived", result.get("0"));
        // Show it
        new SwingWrapper(chart).displayChart();
    }
    
    public void graphPassengerSurvivedGender(){
        Map<Pair<String,String>, Long> result = this.passengerList.stream()
                .collect(Collectors.groupingBy(p -> Pair.of(p.getSurvived(), p.getSex()),Collectors.counting()));
        // Create Chart
        PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
        // Customize Chart
        Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler().setSeriesColors(sliceColors);
        // Series
        chart.addSeries("Female Survived ", result.get(Pair.of("1","female")));
        chart.addSeries("Male Survived", result.get(Pair.of("1","male")));
        // Show it
        new SwingWrapper(chart).displayChart();
    }
}
