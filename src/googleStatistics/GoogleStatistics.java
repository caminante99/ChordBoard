/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googleStatistics;

import com.google.gson.Gson;
import com.googleapis.ajax.common.PagedList;
import com.googleapis.ajax.schema.WebResult;
import com.googleapis.ajax.services.GoogleSearchQueryFactory;
import com.googleapis.ajax.services.WebSearchQuery;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import static us.monoid.web.Resty.*;
import us.monoid.web.Resty;
import java.net.URLEncoder;


/**
 *
 * @author Zohar Jackson
 */
public class GoogleStatistics {
    
    
    public static void main(String[] args) {
        
        getResults("dont comme");
    }
    
    
    
    public static Double getResults(String searchString){
       
          
                     Double resultsDouble = 1.0;
        try {
        
           
                 
                 
                     Reader reader = null;
                   
                  
                     String url = "http://api.bing.net/json.aspx?Appid=ADCD8403FA47B81D715D8EED631170FB57DB632B&query=%22" + searchString + "%22&sources=web";
                     url = url.replaceAll(" ","+");
                     System.out.println(url);
                     Resty r = new Resty();
                     String hello = r.text(url).toString();
                     String numResults  = (hello.substring(hello.indexOf("Total")+7, hello.indexOf(",", hello.indexOf("Total")+7)));
                    /*
                     
                     String url = "http://www.google.com/search?source=ig&hl=en&q=%22" + searchString + "%22&btnG=Google+Search";
                     url = url.replaceAll(" ","+");
                     System.out.println(url);
                     Resty r = new Resty();
                     String hello = r.text(url).toString();
                     System.out.println(hello);
                    
                     String numResults = hello.substring(hello.indexOf("About") + 6, hello.indexOf("results",hello.indexOf("About")));
                     numResults =numResults.replaceAll(",","");
                     System.out.println(numResults);
                     */
                      
                     
                     
                     resultsDouble = Double.valueOf(numResults);
                     System.out.println(resultsDouble);
                     
                     return resultsDouble;
        } catch (Exception ex) {
            Logger.getLogger(GoogleStatistics.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
           
             
      return resultsDouble;
      
    }
    
   

}
