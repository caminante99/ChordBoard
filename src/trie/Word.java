/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

/**
 *
 * @author Zohar Jackson
 */
public class Word {
    
   
    private String hardWord;
    private Likelihood likelihood;
    private String trieWord;   // the version of the word in the tree
    public boolean isFuzzy;
    
     public Word(String word){       
        likelihood = new Likelihood();
        this.hardWord = word;
        setTrieWord(word);
        isFuzzy=false;
    }
    
    
     
      
     public String getAlpabeticalWord(){return Alphabetical.makeAlphabetical(hardWord);}
     
     public String getWord(){return hardWord;}
     
     public String getTrieWord(){return trieWord;}
     
     public void setTrieWord(String newWord){
       
        trieWord = removeDoubles(newWord);
   
     }
     
     
     public void setTrieFuzzyWord(String newWord){
       
       
        // trieWord = Alphabetical.makeAlphabetical(newWord);
         trieWord = removeDoubles(newWord);
         isFuzzy= true;
     
     
     }
     
     
     
     public Likelihood getLikelihood(){return likelihood;}
     
     public void setLikelihood(Likelihood newLikelihood){likelihood= newLikelihood;}

    private String removeDoubles(String tempWord) {
        
        tempWord = Alphabetical.makeAlphabetical(tempWord);
        
        for(int i = 0; i<tempWord.length()-1; i++){
        
            if(tempWord.charAt(i) == tempWord.charAt(i+1)){
                tempWord = tempWord.replaceFirst(String.valueOf(tempWord.charAt(i+1)), "");
                i--;  // go back becuase we just removed a letter;
            }
        }
        
        
        // Remove Spaces
        tempWord = tempWord.replaceAll(" ", "");
        
        return tempWord;
    
    }

     
     
}
