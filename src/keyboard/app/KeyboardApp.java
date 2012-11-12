/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.app;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import trie.Alphabetical;
import trie.maintenance.Populate;
import trie.Trie;
import trie.Word;
import trie.maintenance.CleanWordList;

/**
 *
 * @author Zohar Jackson
 */
public class KeyboardApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            String searchString = "reng";         
       
            
            Trie trie = new Trie();
            
            // Create the tree structure
            Populate.populate("C://UltraBoard/freqList.txt");
            //Populate.global_Likelihood_Populate("C://UltraBoard/freqList.txt");
    
            
            //Populate likelihoods
           // Populate.global_Likelihood_Populate("C://file.txt");
            
            System.out.println("Trie Population Complete!");
            
         
            ArrayList<Word> searchResults = Trie.search(searchString);
            
            
            for(int i =0; i<searchResults.size(); i++){
                
                if(i==0)
                    System.out.println("Most Likeily Matches");
                
                System.out.println(searchResults.get(i).getWord() + " - " + searchResults.get(i).getLikelihood().global_Likelihood );
                
            }
      
       
                        
        
        
    }





}

