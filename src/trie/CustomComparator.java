/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import chordboardapp.ChordBoardAPPView;
import java.util.Comparator;

/**
 *
 * @author Zohar Jackson
 */
public class CustomComparator implements Comparator<Word> {
  
    public int compare(Word o1, Word o2) {
     
        
        if (o1.getLikelihood().getLikelihood()< o2.getLikelihood().getLikelihood())
            return 1;
        else 
            return -1;
   
   
    
    }
}