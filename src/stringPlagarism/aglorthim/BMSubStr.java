package stringPlagarism.aglorthim;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BMSubStr {

	private int [] table = new int[256]; // the table for all the possible characters in the string storing shift values
	private String text;
	private String pattern;
	private ArrayList<Integer> loc = new ArrayList<Integer>(); // to store the locations where pattern was found in the text string
	public int searchTimeCount= 0;
	public int preprocessingTimeCount= 0, timeCount=0;
	/**
     * Constructor for the BMSubStr initialized two strings and the lcsTable
     *
     * @param pat
     *            for the pattern
     * @param txt
     *            for the text
     * initializes the table to the values of shifts that will be needed for all the characters in text, based on pattern
     */
	public BMSubStr(String pat, String txt){
		text = txt;
		pattern = pat;
		if(text.length()==pattern.length())
		{ text = text + " ";
		}
		Arrays.fill(table, -1); // initialization for the characters in the text that does not occur in the pattern
		for (int i = 0; i < pattern.length(); i++) {
			table[pattern.charAt(i)] = i; // the shift values for  the characters in the text that does not occur in the pattern
			preprocessingTimeCount++;
		   
		}

	}
	/**
     * returns the location in the text string where the pattern is located.
     */
	public int posPatt(){
		if(loc.isEmpty())
			return 0;
		else
			return pattern.length();
	}
	public static void main(String[] args) {
		
		String pattern, txt;
		int len1, len2;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the pattern String:--->");
		pattern = input.nextLine();
		len1 = pattern.length();
		System.out.println("Enter the txt String:--->");
		txt = input.nextLine();
		len2 = txt.length();
		BMSubStr bms = new BMSubStr(pattern, txt);
		System.out.println(bms.BMSimilarity());

	}
	
	/**
     * returns the extent of similarity of the pattern to the text string, this function is called in BMSimilarity() function.
     */
	 public int locateStr(){
		int shift, len1, len2;
		int maxSubstringLength=0;
		int matchcounter=0;
		len1 = pattern.length();
		len2 = text.length();
		for(int i = 0; i <= len2 - len1; i = i + shift){ // updates the pointer on the text string for the comparison with pattern
			shift = 0;
			for(int j = len1 - 1; j >= 0; j--){
				if(pattern.charAt(j) != text.charAt(i + j)){
					shift = Math.max(1, j - table[text.charAt(i + j)]);// shift in case of a mismatch of a character in pattern and text string 
					maxSubstringLength =  Math.max(maxSubstringLength, matchcounter); // extent of match
					matchcounter=0;
					break;
				}
				matchcounter++;
				searchTimeCount++;
			}
			if (shift == 0){
				shift++;
				loc.add(i);
			}
		}
		//System.out.println("maxSubstringLength = "+maxSubstringLength);
		return maxSubstringLength;
		
	}
	 
	 public int getTimeCount(){
	    	if(searchTimeCount>preprocessingTimeCount)
	    	{ timeCount = searchTimeCount;
	    	}
	    	else
	    	{
	    		timeCount = preprocessingTimeCount;
	    	}
	        return timeCount;
	}
	 /**
	     * returns the extent of similarity of the pattern to the text string
	     */
	 public int BMSimilarity(){
		 double sim = 0.00;
		 int len1, len2 ;
		 len1 = len2 = 0;
		 BMSubStr bms = new BMSubStr(pattern, text);
		 len2= bms.locateStr();
		 return len2;
	}
}

