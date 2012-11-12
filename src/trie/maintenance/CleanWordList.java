/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trie.maintenance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zohar Jackson
 */
public class CleanWordList {
    private static FileInputStream fstream;
    
    public static void clean( String wordListLocation){
          

        
        try {
            // open word list
            fstream = new FileInputStream(wordListLocation);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
             
            BufferedWriter out = new BufferedWriter(new FileWriter("c:/newWordList.txt", true));        
          
            

            while ((strLine = br.readLine()) != null){
                
                String tempLine = strLine;
               
                if(strLine.indexOf("/")>-1){
                     tempLine =  strLine.substring(0, strLine.indexOf("/"));
                 }
                 
                  out.write(tempLine + "\n");
            }
        
            out.close();

        
        } catch (IOException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
        
        
        
    }
