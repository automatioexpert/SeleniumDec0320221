package projectImDB;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Imdb {

  private  SeleniumCommandBase caller ; 
  private String INPUT_FILE_PATH = System.getProperty("user.dir") + "/inputfolder/movies.txt";
  private String OUTPUT_FILE_PATH = System.getProperty("user.dir") + "/outputfolder/moviedata.txt";
  
  ArrayList<String> MovieData = new ArrayList<String>();
  
  @BeforeSuite
  public void setUp(){
    caller = new SeleniumCommandBase("Chrome");
  } 
  
  @Test(priority=1)
  public void  extractTextData(){
	  MovieData =  caller.readTextData(INPUT_FILE_PATH);
  }
  
  
  @Test(priority = 2)
  public void extractData() throws InterruptedException, IOException{
	  FileWriter writer = new FileWriter(OUTPUT_FILE_PATH); ;
      caller.openWebPage("http://www.imdb.com/");  
	  if(MovieData.size()>0){
		   for(int movie = 0; movie<MovieData.size();movie++){
			   caller.click(SeleniumPages.searchField);
				caller.sendKeys(MovieData.get(movie), SeleniumPages.searchField);
				caller.click(SeleniumPages.searchBtn);
				int count = caller.getCount(SeleniumPages.searchResult);
				for (int i =1 ; i <=count ; i++){
					caller.iteratorClick(i, SeleniumPages.iterator1);	
					String title = caller.retrieveText("text", SeleniumPages.title);
					System.out.println(title);
					writer.write(title+"==");
    	            String time = caller.retrieveText("text", SeleniumPages.time);
					System.out.println(time);
					writer.write(time+"==");
                    int getGenreCount = caller.getCount(SeleniumPages.genre);
					for(int j = 1; j<=getGenreCount; j++){
					String genre  = caller.iterativeXpathtoStringGenerator(j, SeleniumPages.iterator2);
					System.out.println(genre + j);
					writer.write(genre+",");
    	            }
					String releaseDate = caller.retrieveText("text", SeleniumPages.releaseDate);
					System.out.println(releaseDate);
					writer.write(releaseDate+"==");
    	            writer.flush();
					caller.navigateBack();
					caller.clearTextField(SeleniumPages.searchField);
			}
			writer.write("\r\n");
	      }
		  writer.close();
	   }
    }
  
  
  
  @AfterSuite
  public void tearDown(){
   caller.quitDriver();
  }
	
}
