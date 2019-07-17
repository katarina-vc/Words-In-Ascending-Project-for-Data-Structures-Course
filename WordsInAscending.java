/*
 * Name: Katarina Capalbo
 * Date: 6/2/2019
 * Assignment:	Project 4 COP3530 Data Structures
 * 
 * Description: Rewrite CountOccurenceOfWords.java to display the words in ascending order of occurrence counts
 * 
*/


import java.util.*;


// start class WordsInAscending
public class WordsInAscending {
	
	// start main
	public static void main(String[] args) {    
		
		// Set text in a string  
		String text = "Good morning. Have a good class. " +      
				"Have a good visit. Have fun!"; 
		
		
        // Create a TreeMap to hold words as key and count as value 
	    Map<String, Integer> map = new TreeMap<>();
	    
	    // String array of words from text String
	    String[] words = text.split("[ \n\t\r.,;:!?(){}'\"]");
	    
	    for (int i = 0; i < words.length; i++) {     
	    	 String key = words[i].toLowerCase(); 
	    	 if (key.length() > 0) {      
	    		 if (!map.containsKey(key)) {       
	    			 map.put(key, 1);      
	    			 }      
	    		 else {       
	    			 int value = map.get(key);       
	    			 value++; 
	    			 
	    			 // replace old value with new incremented value
	    			 map.put(key, value);
	    		 }
	    	 }
	    }
	    
	    // Get all entries into a set  
	    Set<Map.Entry<String, Integer>> entrySet = map.entrySet(); 
	    
	    /* For each pair in the hash set, create an instance of WordOccurrence
	    and store it in an ArrayList */
	    ArrayList<WordOccurrence> wordList = new ArrayList<WordOccurrence>();
	    
	    for(Map.Entry<String, Integer> entry: entrySet)   
	    {
	    	wordList.add(new WordOccurrence(entry.getValue(), entry.getKey()));
	    }
	    
	    // Sort wordList
	    Collections.sort(wordList);
	    
	    // Print out word occurrences in ascending order
	    for(WordOccurrence word: wordList)
	    {
	    	System.out.printf("%s\t%d\n", word.word, word.count);
	    }
	    
	}// end main
}// end class WordsInAscending




/*
 *  Class WordOccurrence that implements the Comparable interface. 
 *  The class contains two fields, word and count. The compareTo method 
 *  compares the counts. For each pair in the hash set in CountOccurenceOfWords.java, 
 *  create an instance of WordOccurrence and store it in an array list. 
 *  Sort the array list using the Collections.sort method
 */

// start class WordOccurrence
class WordOccurrence implements Comparable<WordOccurrence>
{
	// Local Declarations
	int count = 0;
	String word = "";
	
	// Default Constructor
	public WordOccurrence(){
	}
	
	// Constructor: takes parameters count and word
	public WordOccurrence(int count, String word)
	{
		// Set count and word
		this.count = count;
		this.word = word;
	}
	

	// Implementation of inherited abstract method compareTo()
	public int compareTo(WordOccurrence obj)
	{
		// Compare the counts of each WordOccurrence object
		if(this.count > obj.count)
		{
			return 1;
		}
		else if(this.count < obj.count)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
}// end class WordOccurrence

