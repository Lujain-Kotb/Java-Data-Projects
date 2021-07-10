/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sparkinsights;

/**
 *
 * @author lujain
 */
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.apache.spark.api.java.JavaRDD;
public class DataSetInsights {
    
    private static final String COMMA_DELIMITER = ",";
    public static JavaRDD<String> videos;
    
    
    public static  void ExtractWordCount() {
        JavaRDD<String> titles = videos
                .map (DataSetInsights::extractTitle)
                .filter (StringUtils::isNotBlank);
       // JavaRDD<String>
        JavaRDD<String> words = titles.flatMap (title -> Arrays.asList (title
                .toLowerCase ()
                .trim ()
                .replaceAll ("\\p{Punct}", " ")
               .split (" ")).iterator ());
        // COUNTING
        Map<String, Long> wordCounts = words.countByValue ();
        List<Map.Entry> sorted = wordCounts.entrySet ().stream ()
                .sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList ());
        // DISPLAY
        for (Map.Entry<String, Long> entry : sorted) {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        }
    }
    
    public static void ExtractTagCount(){
        
        JavaRDD<String> tags = videos
                .map (DataSetInsights::extractTags)
                .filter (StringUtils::isNotBlank);
        
        JavaRDD<String> tag_words = tags.flatMap (tag -> Arrays.asList(tag
                .toLowerCase()
                .trim()
                .split("\\|")).iterator());
        
        
        Map<String, Long> tagCounts = tag_words.countByValue();
        
        List<Map.Entry> sorted = tagCounts.entrySet().stream()
                .sorted (Map.Entry.comparingByValue()).collect (Collectors.toList());
        
        for (Map.Entry<String, Long> entry : sorted) {
            System.out.println (entry.getKey() + " : " + entry.getValue());
        }
    }
    
    
     private static String extractTitle(String videoLine) {
        try {
            return videoLine.split (COMMA_DELIMITER)[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }   
    }
     
     private static String extractTags(String videoLine) {
        try {
            return videoLine.split (COMMA_DELIMITER)[6];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }   
    }
}
