//Source file: C:\\project\\ss\\lang\\gu\\prepro\\PreProcessorImpl.java

package project.ss.lang.gu.prepro;

import project.ss.misc.*;
import project.ss.xml.*;
import project.ss.exception.*;

import project.ss.lang.gu.*;
import java.util.regex.*;
import java.io.*;
import java.nio.*;

/**
 * This class is designed to provide implementation of the PreProcessor class for 
 * Gujarati Unicode text. Currently the class uses a text file which stores 
 * various text sequence to be filtered out and corresponding replacement text. 
 * The GujLookUp.txt file is used currently. But future implementation may include 
 * much more sophisticated version of this class.
 * 
 * Note about GujLookUp.txt
 * 
 * 	GujLookUp.txt file contains pair of words delimited by "=" sign.
 * 	e.g., foo=foobar
 * 
 * PreProcessorImpl class will use such pair of text to preprocess the specified 
 * string. It will search for the entry of the first text sequence and will 
 * replace it with a corresponding text (word offer "=" sign)
 * 
 * Rules to add new entry into GujLookUp.Txt.
 * 
 * 1 Very First line should not be used.
 * 2 Each text pair must contain only one line.
 * 3 Each line should contain only one text pair.
 * 4 Do not use spaces around the texts as it will also be considered as a part of text
 * 5 Always put a back up
 */
public class PreProcessorImpl implements PreProcessor 
{
   
   /**
    * Used to store the content of look up file for efficient processing.
    */
   static String tokens[];
   
   /**
    * It is used to handle the GSX Files.
    */
   static GSXHandler gsxHandler = new GSXHandlerImpl ();
   
   /**
    * @param lookUpFile
    * @param encoding
    * @roseuid 3B06A664005A
    */
   public PreProcessorImpl(File lookUpFile, String encoding) 
   {
   CharBuffer charBuffer= FileLoad.getCharBufferRO(lookUpFile,encoding);
   //Pattern pp = Pattern.compile("\r\n");  // change \r\n to other for multi OS compatibility
   Pattern pp = Pattern.compile("[\r\n]+");  // change \r\n to other for multi OS compatibility
   tokens = pp.split(charBuffer.toString());    
   }
   
   static 
   {
/*
  File dir = new File("C:/project/ss/lang/gu/prepro");
  File file = new File (dir,"GujLookUp.txt");
  CharBuffer charBuffer= FileLoad.getCharBufferRO(file,"UTF-16BE");
  Pattern pp = Pattern.compile("\n");  // change /n to other for multi OS compatibility  
  tokens = pp.split(charBuffer.toString());
  */    
   }
   
   /**
    *  Provides the preprocessed output of the given Gujarati raw 
    * (unprocessed) string.
    * 
    * @param GSXFile
    * @return java.lang.String
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @throws project.ss.exception.UnsupportedGU
    * @roseuid 3B06A6640096
    */
   public String preProcess(File GSXFile) throws ImproperGSXFile, IOException, UnsupportedGU 
   {
   String rawGujString = gsxHandler.getGURawString( GSXFile );
   System.out.println("________RAW GUJ String ________ " + rawGujString);
   return preProcess ( rawGujString );    
   }
   
   /**
    * Provides the preprocessed output of the given gujarati raw (up processed) text 
    * provided in the GSX file. It only takes the specific text tagged as raw 
    * Gujarati text as input from the file. Rest is neglected.
    * 
    * @param rawGujString
    * @return java.lang.String
    * @throws project.ss.exception.UnsupportedGU
    * @roseuid 3B06A6640190
    */
   public String preProcess(String rawGujString) throws UnsupportedGU 
   {
     GujCharSupport.isValidGujString(rawGujString);
     String tobeMatched = rawGujString;
     String searchString=null;
     String replacingString=null;
     String wordPair[]=null;
     Pattern pp = Pattern.compile("=");
     for (int i=1;i<tokens.length;i++)
      {
        if ( tokens[i].indexOf("=") != -1)
         {
          wordPair = pp.split(tokens[i]);
          searchString= wordPair[0];
          replacingString= wordPair[1];
          System.out.println( searchString +" "+replacingString);
        //Pattern pattern = Pattern.compile("\\s"+searchString+"\\s");//unnecessary use of \\s here.
	  Pattern pattern = Pattern.compile(searchString);
          Matcher matcher = pattern.matcher(tobeMatched);
          tobeMatched = matcher.replaceAll(" "+replacingString+" ");
	  System.out.println("In prepro:"+tobeMatched);
         }
      }
     return   tobeMatched;    
   }
}
