package stringPlagarism.aglorthim;

import java.util.Arrays;
import java.util.Scanner;

public class LCSS {
	private String strOne;
	private String strTwo;
	private int len1;
	private int len2;
	private int lcssLen;
	private int[][] lcsTable; // the LCSS table to be populated while comparing strings using dynamic programming
	private char[] comStr; // the variable to store the longest common subsequence between strOne and strTwo
	public int timeCount=0;
	/**
     * Constructor for the LCSS initialized two strings and the lcsTable
     *
     * @param st1
     *            the first string
     * @param st2
     *            the second string
     * 
     */
	public LCSS(String st1, String st2){
		strOne = st1;
		strTwo = st2;
		len1 = strOne.length();
		len2 = strTwo.length();
		lcsTable = new int[len1 + 1][len2 + 1];
		
		for(int i = 0; i < len1; i++)  // lcsTable gets initialized to 0 for all entries
			for(int j = 0; j < len2; j++){
				lcsTable[i][j] = 0;
			}
	}
	/**
     * computes the LCSS for the strings strOne and strTwo
     * @return the length of the longest common subsequence between strOne and strTwo
     */
	public int computeLCSS(){
		lcssLen = 0;
		for(int i = 1; i < len1 + 1; i++) // populates the lcsTable using dynamic programming technique
			for(int j = 1; j < len2 + 1; j++){
				if(strOne.charAt(i - 1) == strTwo.charAt(j - 1)){
					lcsTable[i][j] = lcsTable[i -1 ][j - 1] + 1;
					
				}
				else
					lcsTable[i][j] = (lcsTable[i][j - 1] >lcsTable[i - 1][j]) ?lcsTable[i][j - 1]:lcsTable[i - 1][j];
					
				timeCount++;
			}
		lcssLen = lcsTable[len1][len2]; // returns the length of the longest common subsequence
		comStr = new char[lcssLen + 1];
		comStr[lcssLen] = '\0'; // variable to store the common subsequence between the two strings strOne and strTwo
		int k = 1;
		for(int i = len1 ; i > 0 && (k <= lcssLen); ){
			for(int j = len2 ; j > 0 && (k <= lcssLen);){
				if(lcsTable[i][j] != 0){
				if(lcsTable[i][j] == lcsTable[i][j - 1]){
						j--;
				}
				else
				{
						if(lcsTable[i ][j ] == lcsTable[i - 1][j ]){
						i--;
					}
					else {
							comStr[lcssLen - k] = strOne.charAt(i-1);
							k++;
							i--;
							j--;
					 	}
				}
			}
			else
				break;
			}
		}
		return lcssLen;
	}
	
	public void printStrings(){
//		System.out.println(strOne + "  has length:-->" + len1);
//		System.out.println(strTwo + "  has length:-->" + len2);
//		System.out.println("The common string length is:--->" + lcssLen + " and the common string is :-->" + Arrays.toString(comStr));
	System.out.println(Arrays.toString(comStr));
	}
	/**
     * @return the length of the longest common subsequence between strOne and strTwo
     */
	public int getLcssLen(){
		return lcssLen;
	}
	
	public int getTimeCount(){
        return timeCount;
}

public static void main(String[] args) {
		
		String str1, str2;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the first String:--->");
		str1 = input.nextLine();
		
		System.out.println("Enter the second String:--->");
		str2 = input.nextLine();
		
		LCSS lcf = new LCSS(str1,str2);
	    lcf.computeLCSS();
		lcf.printStrings();
		System.out.println(lcf.getLcssLen());
	}	

}
