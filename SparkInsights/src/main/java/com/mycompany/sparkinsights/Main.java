package com.mycompany.sparkinsights;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger.getLogger ("org").setLevel (Level.ERROR);
        SparkConf conf = new SparkConf ().setAppName ("wordCounts").setMaster ("local[3]");
        JavaSparkContext sparkContext = new JavaSparkContext (conf);
        
        DataSetInsights.videos = sparkContext.textFile("src/main/resources/data/USvideos.csv");
        
        DataSetInsights.ExtractWordCount();
        DataSetInsights.ExtractTagCount();
        
    }
    
    
   
}
