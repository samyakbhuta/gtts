package project.ss.lang.gu.ipatrans;

/*
 *This is a static class to check the presence of consonant,vowel or Indpendent vowel.
 */

public class Check
{
	


	static String indeVowel[]={"\u0A85","\u0A86","\u0A87","\u0A88","\u0A89","\u0A8A","\u0A8D","\u0A8F","\u0A90","\u0A91","\u0A93","\u0A94"};
        static String depVowel[]={"\u0ABE","\u0ABF","\u0AC0","\u0AC1","\u0AC2","\u0AC3","\u0AC4","\u0AC5","\u0AC7","\u0AC8","\u0AC9","\u0ACB","\u0ACC"};
	static String consonants[]={"\u0A95",
				"\u0A96",
				"\u0A97",
				"\u0A98",
				"\u0A99",
				"\u0A9A",
				"\u0A9B",
				"\u0A9C",
				"\u0A9D",
				"\u0A9E",
				"\u0A9F",
				"\u0AA0",
				"\u0AA1",
				"\u0AA2",
				"\u0AA3",
				"\u0AA4",
				"\u0AA5",
				"\u0AA6",
				"\u0AA7",
				"\u0AA8",
				"\u0AA9",
				"\u0AAA",
				"\u0AAB",
				"\u0AAC",
				"\u0AAD",
				"\u0AAE",
				"\u0AAF",
				"\u0AB0",
				"\u0AB1",
				"\u0AB2",
				"\u0AB3",
				"\u0AB4",
				"\u0AB5",
				"\u0AB6",
				"\u0AB7",
				"\u0AB8",
				"\u0AB9"};
	
	/** This method is to check whether the unicode character is
	  * an independent vowel or not.
	  */  	  
	
	public static boolean isIndeVowel(String checkStr)
	{	boolean test=false;
		for(int i=0;i<indeVowel.length;i++)
		{
			if(checkStr.equals(indeVowel[i]))
			{
				test=true;
				
			}
		}
		//System.out.println((int)checkStr.charAt(0));
		return test;
	}
	
	/** This method is to check whether the unicode character is
	  * an independent consonant or not.
	  */  	  

	public static boolean isConsonant(String checkStr)
	{	
		boolean test=false;
		for(int i=0;i<consonants.length;i++)
		{
			if(checkStr.equals(consonants[i]))
			{
				test=true;
			}
		}
		//System.out.println((int)checkStr.charAt(0));
		return test;
		
	}

	/** This method is to check whether the unicode character is
	  * an dependent vowel or not.
	  */  	  
	
	public static boolean isDepVowel(String checkStr)
	{
		boolean test=false;
		for(int i=0;i<depVowel.length;i++)
		{
			if(checkStr.equals(depVowel[i]))
			{
				test=true;
			}
		}
	        //System.out.println((int)checkStr.charAt(0));	
		return test;
	}
	public static boolean isHalant(String checkStr) 
   	{
		boolean test=false;
       		char c = checkStr.charAt(0);
       		if    (   c == '\u0ACD'   )    
       		{
           		test=true;
       		}
       		return test;    
   	}
}