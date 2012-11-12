/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

/**
 *
 * @author Zohar Jackson
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
 
/**
 * @author Braga
 */
public class Node {
 
 char content;
 boolean marker; 
 Collection<Node> child;
  
 
 
 /* Words that come out of this letter combination, sorted by likelihood
  * 
  */
 ArrayList<Word> possibleWords;
 
 
 
 
 
 public Node(char c){
  child = new LinkedList<Node>();
  marker = false;
  content = c;
  possibleWords = new ArrayList<Word>();
 }
  
 public Node subNode(char c){
 if(child!=null){
   for(Node eachChild:child){
    if(eachChild.content == c){
     return eachChild;
    }
   }
  }
        

  return null;
 }

  public void addWord(Word word) {
       
      possibleWords.add(word);
      
    }
}
