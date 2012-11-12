/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

/**
 *
 * @author Zohar Jackson
 */
public class Likelihood {
 
        public boolean isFuzzy;  // if we arrived at this word through fuzzy logic, IE miss-spellings
        public double global_Likelihood;   // The words likelihood in the english language
        public double local_likelihood;   // The words likelihood for this user (how often this user uses the word)
        private double fuzzyLikelihood;
    /*
     *  The likelihood of this word at this point in the trie 
     *  How do we determine this? Based on common misspelling list
     * 
     */
    public double local_trie_likelihood; 
    
    
    public double getLikelihood(){
        if(isFuzzy)
            return global_Likelihood * .02;
        else
            return global_Likelihood;
    
    }
}
