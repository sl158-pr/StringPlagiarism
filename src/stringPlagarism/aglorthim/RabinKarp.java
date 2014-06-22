package stringPlagarism.aglorthim;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.io.*;

public class RabinKarp {
	public String pat; // the pattern
	public long patHash; // pattern hash value
	public int patlen; // pattern length
	public long ramdomprime; // a large prime, small enough to avoid long
	// overflow
	public int ibase;
	public long RM; 
	public int timeCount=0;


	// Compute hash for key[0..M-1] ie pattern.
	private long hash(String key, int M) {
		long h = 0;
		for (int j = 0; j < M; j++) {
			h = (ibase * h + key.charAt(j)) % ramdomprime;
			timeCount++;
		}
		return h;
	}

	// does pat[] match txt[i..i-M+1] ?
	private boolean check(String txt,String pattern, int i) {
		String p = pattern;
		for (int j = 0; j < patlen; j++)
			{ timeCount++;
			if (p.charAt(j) != txt.charAt(i + j))
				return false;
			}
		return true;
	}

	// check for exact match
	public int search(String pat,String txt) {
		
		String pattern = pat; // save pattern
		int numberOfMatches= 0;
		ibase = 256;
		patlen = pattern.length();
		ramdomprime = longRandomPrime();
		
		// precompute R^(M-1) % Q for use in removing leading digit
		RM = 1;
		for (int i = 1; i <= patlen - 1; i++)
		{
			RM = (ibase * RM) % ramdomprime;
			timeCount++;
		}
			
		patHash = hash(pattern, patlen);
		int N = txt.length();

		long txtHash = hash(txt, patlen);
		// check for match at offset 0
		if ((patHash == txtHash) && check(txt, pattern,0))
		{  numberOfMatches++;

		}

		// check for hash match; if hash match, check for exact match
		for (int i = patlen; i < N; i++) {
			 timeCount++;
			// Remove leading digit
			txtHash = (txtHash + ramdomprime - RM * txt.charAt(i - patlen) % ramdomprime) % ramdomprime;
			// add trailing digit
			txtHash = (txtHash * ibase + txt.charAt(i)) % ramdomprime;

			// check for match.
			int offset = i - patlen + 1;
			if ((patHash == txtHash) && check(txt, pattern,offset)) {
				numberOfMatches++;
			}
		}
		//System.out.println("numberOfMatches " +numberOfMatches);
		return numberOfMatches;
	}

	// a random 31-bit prime
	private long longRandomPrime() {
		BigInteger prime = BigInteger.probablePrime(31, new Random());
		return prime.longValue();
	}
	public int getTimeCount(){
        return timeCount;
}
	// test client
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String txt = "sachin sachin sachin vjvdjdcvjhcdjcvdhcbdchjbdcjhbsdcjbcjsdbcjhcbsdjcbjs";
		String pat = "zzzzzzzzzzz";
		RabinKarp r = new RabinKarp();
		r.search(pat,txt);

	}
}
