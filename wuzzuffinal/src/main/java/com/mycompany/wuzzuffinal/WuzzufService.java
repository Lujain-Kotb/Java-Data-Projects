/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wuzzuffinal;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import smile.data.DataFrame;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 *
 * @author lujain
 */
@RestController
public class WuzzufService {


   WuzzufDao wzfDao = new WuzzufDao();
   DataFrame df = JobProvider.getJobDataFrame();
   @RequestMapping(value = "/showall", produces = MediaType.APPLICATION_JSON_VALUE)
   public List<Job> getJobs(){
      return JobProvider.getJobList();
   }

   @RequestMapping(value = "/structure", produces = MediaType.TEXT_PLAIN_VALUE)
   public String getdataframeStructure() {
      return df.structure().toString(df.nrows());
   }


   @RequestMapping(value = "/removenulls", produces = MediaType.APPLICATION_JSON_VALUE)
   public List<Job> removenulls() {
      List<Job> cleaned = JobProvider.getCleaneddf();
      df=JobProvider.getJobDataFrame();
      return cleaned;
   }

   @RequestMapping(value = "/mostdemandingcompanies", produces = MediaType.APPLICATION_JSON_VALUE)
   public Map<String,Long> getmostdemandingcompanies() {
      return wzfDao.companies(df);
   }

   @RequestMapping(value = "/mostpopularjobs", produces = MediaType.APPLICATION_JSON_VALUE)
   public Map<String,Long> getmostpopularjobs() {
      return wzfDao.jobs(df);
   }

   @RequestMapping(value = "/mostpopularareas", produces = MediaType.APPLICATION_JSON_VALUE)
   public Map<String,Long> getmostpopularareas() {
      return wzfDao.areas(df);
   }

   @RequestMapping(value = "/mostimportantskills", produces = MediaType.TEXT_PLAIN_VALUE)
   public String getmostimportantskills() {
      return wzfDao.mostImpSkills(df);
   }

   @RequestMapping(value = "/yearsExp", produces = MediaType.TEXT_PLAIN_VALUE)
   public String getyearsExp() throws Exception {
      return wzfDao.yearsOfExperience(df);
   }


   @RequestMapping(value = "/mostdemandingcompaniespie",method = RequestMethod.GET,
           produces = MediaType.IMAGE_JPEG_VALUE)
   public @ResponseBody byte[] getCompaniesPie() throws IOException {

      Path path  = Paths.get("./src/main/resources/most_demanding_companies_pie.jpeg");
      if (Files.exists(path) && !Files.isDirectory(path)) {
         InputStream in = Files.newInputStream(path, StandardOpenOption.READ);
         return IOUtils.toByteArray(in);
      }
      InputStream in = Files.newInputStream(path, StandardOpenOption.READ);
      return IOUtils.toByteArray(in);
   }

   @RequestMapping(value = "/jobshist",method = RequestMethod.GET,
           produces = MediaType.IMAGE_JPEG_VALUE)
   public @ResponseBody byte[] getJobsHist() throws IOException {

      Path path  = Paths.get("./src/main/resources/jobs_hist.jpeg");
      if (Files.exists(path) && !Files.isDirectory(path)) {
         InputStream in = Files.newInputStream(path, StandardOpenOption.READ);
         return IOUtils.toByteArray(in);
      }
      InputStream in = Files.newInputStream(path, StandardOpenOption.READ);
      return IOUtils.toByteArray(in);
   }

   @RequestMapping(value = "/locationshist",method = RequestMethod.GET,
           produces = MediaType.IMAGE_JPEG_VALUE)
   public @ResponseBody byte[] getLocationsHist() throws IOException {

      Path path  = Paths.get("./src/main/resources/locations_hist.jpeg");
      if (Files.exists(path) && !Files.isDirectory(path)) {
         InputStream in = Files.newInputStream(path, StandardOpenOption.READ);
         return IOUtils.toByteArray(in);
      }
      InputStream in = Files.newInputStream(path, StandardOpenOption.READ);
      return IOUtils.toByteArray(in);
   }

   @RequestMapping(value = "/kmeans",method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
      public @ResponseBody byte[] getkmeans() throws Exception {

         Path path  = Paths.get("./src/main/resources/kmeans.jpeg");
         if (Files.exists(path) && !Files.isDirectory(path)) {
            InputStream in = Files.newInputStream(path, StandardOpenOption.READ);
            return IOUtils.toByteArray(in);
         }
         InputStream in = Files.newInputStream(path, StandardOpenOption.READ);
         return IOUtils.toByteArray(in);
      }

}
