/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;



/**
 *
 * @author Zohar Jackson
 */
public class Trie{
 private static Node root;

 
    /*
  *  This function sorts the array list by a combination of global, local, and user liklihood
  
    private static ArrayList<Word> Sort(ArrayList<Word> possibleWords) {
        
        ArrayList<Word> tempList = new ArrayList<Word>();
        
        if(!possibleWords.isEmpty())
             tempList.add(possibleWords.get(0));
        else
             return tempList;
        
        
        for(int i = 1; i < possibleWords.size(); i++){ // start i at 1 so we dont double add possibile words 0 to tempList
        
            Double tempLikeHood = possibleWords.get(i).getLikelihood().global_Likelihood;
            
            for(int k = 0; k < tempList.size(); k++){
                if (tempLikeHood < tempList.get(k).getLikelihood().global_Likelihood)
                    tempList.add(k,  possibleWords.get(i)); // add to middle or begining
                else
                    tempList.add(possibleWords.get(i)); // add to the end of list
                        
            }
                
        
        }
        
        return tempList;
        
    }
  * 
  */
 
 public Trie(){
  root = new Node(' '); 
 }
 
 public static void insert(Word word){
  Node current = root; 
  
 
  String s = word.getTrieWord();
  
  
  if(s.length()==0) //For an empty character
   current.marker=true;
  
  for(int i=0;i<s.length();i++){
       Node child = current.subNode(s.charAt(i));
     
       if(child!=null)
       { 
         current = child;
       }
       else
       {
        current.child.add(new Node(s.charAt(i)));
        current = current.subNode(s.charAt(i));
       }
       
       
       // Set marker to indicate end of the word
       if(i==s.length()-1){
        current.marker = true;
        current.addWord(word);
       }
       
      /*
        * 
        * note to self. I was adding the word along every route. I did not have the curly brackets around the above if
        */
  } 
 }
 
 
 
 
 
 /* Takes an alphabetical or non-alphabetical string
  * returns the results of a non-fuzz search
  */
 public static ArrayList<Word> search(String inputString){
  Node current = root;
  
  // remove doubles and make aphameticals
  Word tempWord = new Word(inputString);
  
  String s = tempWord.getTrieWord();
  
  ArrayList<Word> results = new ArrayList<Word>();
  ArrayList<Word> fuzzyResults = new ArrayList<Word>();

  while(current != null){
       
      for(int i=0;i<s.length();i++){    
            if(current.subNode(s.charAt(i)) == null){
                System.out.println("WE Have an extra letter ------ !!!!");
                 Collections.sort(results, new CustomComparator());       
                return results;
            }
            else
             current = current.subNode(s.charAt(i));
 
            if(i==inputString.length()-2){
                fuzzyResults.addAll(current.possibleWords);
            }
            
      }
  
          if (current.marker == true)
            results.addAll(current.possibleWords);
           
          // return results;  // place here for no problems
           
  }
         
         
         
        //remove fuzzyResults from normal results
         for(int r=0; r<results.size(); r++){
           
           if(results.get(r).isFuzzy){
                results.remove(r);
                r--;
           }
         }
      
      
      // Go through fuzzy results and only accept ones that are less than 1 char of search string
       for(int r=0; r<fuzzyResults.size(); r++){
           
           if(((fuzzyResults.get(r).getWord().length()-1)==inputString.length()) && fuzzyResults.get(r).isFuzzy ){
              results.add(fuzzyResults.get(r));  
           }
       }
       
        Collections.sort(results, new CustomComparator());       

        return results;
        
  }
    
 
 
 
 
 
 public static boolean oldSearch(String s){
  Node current = root;
  while(current != null){
   for(int i=0;i<s.length();i++){    
    if(current.subNode(s.charAt(i)) == null)
     return false;
    else
     current = current.subNode(s.charAt(i));
   }
   /* 
    * This means that a string exists, but make sure its
    * a word by checking its 'marker' flag
    */
   if (current.marker == true)
    return true;
   else
    return false;
  }
  return false; 
 }
}
