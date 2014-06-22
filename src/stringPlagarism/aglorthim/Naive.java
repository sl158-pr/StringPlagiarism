package stringPlagarism.aglorthim;

public class Naive {
	
	public int timeCount=0;
	
	public int search(String pat, String txt) {
		int patternLen = pat.length();
		int txtLen = txt.length();
		int maxcount=0;
		
		for (int i = 0; i <= txtLen - patternLen; i++)
	    {
			int j;

			/* For current index i, check for pattern match */
			for (j = 0; j < patternLen; j++) {
				
				timeCount++;
				if (txt.charAt(i + j) != pat.charAt(j))
				{
					//System.out.println("J is"+ j);
					maxcount= Math.max(maxcount,j);
					break;
				}
				
			}
			if (j == patternLen) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
			{
				//System.out.println("Pattern found at index \n" + (i+1));
				i = i + patternLen;
				maxcount=patternLen;
			}
		}
		//System.out.println("The length of the maxmium substring is " +maxcount);
		return maxcount;
	}
	public int getTimeCount(){
        return timeCount;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "sachin";
		String pat = "sjkjdn";
		//System.out.println("The length of the maxmium substring is " +maxcount);
	}
}
