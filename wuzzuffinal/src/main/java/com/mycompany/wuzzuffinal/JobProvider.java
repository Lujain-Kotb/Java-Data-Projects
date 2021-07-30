package com.mycompany.wuzzuffinal;

import org.apache.commons.csv.CSVFormat;
import smile.data.DataFrame;
import smile.data.Tuple;
import smile.io.Read;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import tech.tablesaw.api.Table;


public class JobProvider {
    private static DataFrame jobDataFrame = null;
    private static void openCSV() throws Exception{
        String path="./src/main/resources/Wuzzuf_Jobs.csv";
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ();
        DataFrame dataFrame = null;
        dataFrame= Read.csv(path,format);
        dataFrame=dataFrame.select("title","company","location","type","level","yearsExp","country","skills");
        JobProvider.jobDataFrame=dataFrame;
    }

    public static List<Job> getCleaneddf(){

        try {
            String path = "./src/main/resources/Wuzzuf_Jobs.csv";

            Table WuzzufJobs;
            WuzzufJobs = Table.read().csv(path);

            Table myTable_withoutDuplicates = WuzzufJobs.dropDuplicateRows();

            // Convert data set to dataframe
            DataFrame dataFrame = myTable_withoutDuplicates.smile().toDataFrame();
            JobProvider.jobDataFrame = dataFrame;

            return JobProvider.getJobList();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static DataFrame getJobDataFrame() {
        try {
            JobProvider.openCSV();
            return JobProvider.jobDataFrame;

        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static List<Job> getJobList() {
//        assert jobDataFrame != null;
try {
        if (JobProvider.jobDataFrame == null){
            JobProvider.openCSV();

        }
        List<Job> Jobs = new ArrayList<>();
        ListIterator<Tuple> iterator = JobProvider.jobDataFrame.stream ().collect (Collectors.toList ()).listIterator ();
        while (iterator.hasNext ()) {
            Tuple t = iterator.next ();
            Job p = new Job ();
            p.setTitle ((String) t.get ("title"));
            p.setCompany ((String) t.get ("company"));
            p.setLocation ((String) t.get ("location"));
            p.setType ((String) t.get ("type"));
            p.setLevel ((String) t.get ("level"));
            p.setYearsExp ((String) t.get ("yearsExp"));
            p.setCountry ((String) t.get ("country"));
            p.setSkills ((String) t.get ("skills"));
            Jobs.add (p);
        }
        return Jobs;
    } catch(Exception e){
        e.printStackTrace();
        return null;
    }
    }
}
