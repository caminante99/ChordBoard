/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trie.maintenance;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import trie.Alphabetical;
import trie.Trie;
import trie.Word;

/**
 *
 * @author Zohar Jackson
 */
public class Populate {
    
    private static FileInputStream fstream;

        
    public static void populate(String wordListLocation){

        
        try {
            // open word list
            fstream = new FileInputStream(wordListLocation);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null){
                
  
                
                String[] array = strLine.split(" ");
                String wordFromFile = array[0];
                double likelihoodFromFile = Double.valueOf(array[1]);
                 
                Word tempWord = new Word(wordFromFile);
                
                
                tempWord.getLikelihood().global_Likelihood = likelihoodFromFile;
                
               // System.out.println(tempWord.getWord() + "-" + tempWord.getTrieWord());
                Trie.insert(tempWord);  // Makes the word alphabetical then inserts it
            
            }
                 
            
        
        
        
        } catch (IOException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    
    public static void fuzzyPopulate(String wordListLocation){
        
       
        
         
        try {
            // open word list
            fstream = new FileInputStream(wordListLocation);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null){
                
  
                
                String[] array = strLine.split(" ");
                String wordFromFile = array[0];
                double likelihoodFromFile = Double.valueOf(array[1]);
                 
                
                String preparedWord = trie.Alphabetical.makeAlphabetical(wordFromFile);
                    
                    // Remove doubles  -- MUST BE AFTER MAKE ALPHABETICAL
                for(int r = 0; r<preparedWord.length()-1; r++){
        
                            if(preparedWord.charAt(r) == preparedWord.charAt(r+1)){
                                preparedWord = preparedWord.replaceFirst(String.valueOf(preparedWord.charAt(r+1)), "");
                                r--;  // go back becuase we just removed a letter;
                            }
                 }
                      
                      
                     
                for(int i =0; i<preparedWord.length(); i++){
                    
                    
                        String tempWord = preparedWord; 
                     
                       // removes a letter from the word
                       tempWord = wordFromFile.replaceAll(String.valueOf(tempWord.charAt(i)),"");
               
                      // System.out.println(wordFromFile + " - " + tempWord);
                       
                       Word word = new Word(array[0]);
                       word.setTrieFuzzyWord(tempWord);
                       
                     //  System.out.println(word.getWord() + " - " + word.getTrieWord());

                        word.getLikelihood().isFuzzy =true;
                        word.getLikelihood().global_Likelihood = likelihoodFromFile;


                        
                       Trie.insert(word);  // Makes the word alphabetical then inserts it
             }
                
                
            }
                 
        
        
        
        } catch (IOException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        // open word list
   
        
        /*
         *  There are two types of mistakes: 
         *          1. Missing chars
         *          2. Wrong chars
         */
        
        // loop through word list, make permutations and add items to tree
        
        
        
    }
    
    
    public static void global_Likelihood_Populate(String wordListLocation){
        
        
          try {
            // open word list
            fstream = new FileInputStream(wordListLocation);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null){
                
                // parse strLine
                String[] array = strLine.split(" ");
                String wordFromFile = array[0];
                double likelihoodFromFile = Double.valueOf(array[1]);
                 
                // Search for the word
                ArrayList<Word> wordArray = Trie.search(wordFromFile);
                
                for(int i=0; i<wordArray.size(); i++){
                    
                    if(wordArray.get(i).getWord().equals(wordFromFile))
                        wordArray.get(i).getLikelihood().global_Likelihood = likelihoodFromFile;
                    
                }
                
                
            }
                 
        
        
        
        } catch (IOException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
}
