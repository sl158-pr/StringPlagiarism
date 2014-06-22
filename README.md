Operating System: 	Windows
Tool:        Eclipse
Language: 		Java


Aim of the Project:

This project was aimed at designing a system that will be able to detect the possible act of plaigiarism. Since the source file that needs to evaluated, and the pool of
documents containing files comprise of strings it is natural to use string comparison algorithms. We used five existing classical string comparison algorithms for the task,
these algorithms are LCSS, KMP, Rabin Karp, Boyer Moore and Naive string comparison algorithm.

Installation for Eclipse

1.	Create a JAVA project in eclipse
2.	Copy entire pool of documents in a folder named "DataSet_SourceFiles", and include the path of this directory in MClass.java
    on line no 34, example:---> final File folder = new File("C:\\Users\\prave_000\\Desktop\\DataSet_SourceFiles"); 
3.  Include the test file on the line no 59 of the MClass.java, example:---> File inputFile = new File( "input.txt"); 

Flow of the Project:
	
1. The source code has many java classes which are:--> MClass.java, KMP.java, LCSS.java, BMSubStr.java, RabinKarp.java and Naive.java:
   a) MClass.java : Main java file.
   b) KMP.java : Has the KMP algorithm implementation.
   c) LCSS.java : Has the LCSS algorithm implementation.
   d) BMSubStr.java : Has the Boyer Moore algorithm implementation.
   e) RabinKarp.java : Has the Rabin Karp algorithm implementation.
   f) Naive.java : Has Naive string comparison algorithm implementation.
   
2. Please run the MClass.java file, it will take the input file and test for plaigarism with respect to
   the files in the document pool.
3. The result of the plaigarism is shown on the console, at the same time the results are also written back
   on the result files:--> lcss.txt, kmp.txt, boyreMoore.txt, naive.txt and rk.txt corresponding to the respective
   algorithms being used for the comparison.
4. The results written on the files are dependent on the threshold that we choose for the similarity for plagiarism,
   we have used the similarity threshold to be 60.00 on line no  97 of the MClass.java, please change that
   according to your choice.
5. After running the MClass.java, please run stringPlagarismOutputUI.java in the user interface to select the respective 
   comparison results.


