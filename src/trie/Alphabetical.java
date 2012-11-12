/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import java.util.Arrays;

/**
 *
 * @author Zohar Jackson
 */
public class Alphabetical {
    
    
    /**
 * this take any string, makes it alphabetical and thne gives it back to you
 */
public static String makeAlphabetical(String myInput){
    
    
        // make myInput alpha
        char[] myArray = new char[myInput.length()];
        
        // puts stringToDecode into myArray
        for(int i = 0; i<myInput.length(); i++)
        {   
            myArray[i] = myInput.charAt(i);
        }
        
        // sort the array
        Arrays.sort(myArray);
        
        // make a blank new string 
        String alphaString = "";
        
        
        // puts myInput into myArray
        for(int i = 0; i<myArray.length; i++)
        {   
           alphaString = alphaString +myArray[i]; 
        }
        
        
        
        
        
    
    
 return alphaString;   
}


}
