//Source file: C:\\project\\ss\\xml\\GSXUtility.java

package project.ss.xml;

import java.io.*;

public class GSXUtility 
{
   public static final String IPA = "IPA";
   public static final String GU = "GU";
   public static final String PROCESSED = "PROCESSED";
   public static final String RAW = "RAW";
   
   /**
    * @param filename
    * @param lang
    * @param type
    * @param dataChar
    * @return java.io.File
    * @roseuid 3B06A61B03E4
    */
   public static File createTempGSXFile(String filename, String lang, String type, String dataChar) 
   {

    String GSXElement = createGSXElement(createDataElement (lang,type,dataChar));
    String GSXDocumentString = createGSXDocument(GSXElement ,true);
    return createTempGSXFile (filename,GSXDocumentString);    
   }
   
   /**
    * @param filename
    * @param GSXDocumentString
    * @return java.io.File
    * @roseuid 3B06A61C001A
    */
   public static File createTempGSXFile(String filename, String GSXDocumentString) 
   {
    File temp=null;
    try
    {
     temp = File.createTempFile(filename,".tmpGSX"); // provide temp dir option
     temp.deleteOnExit();
     RandomAccessFile raFile = new  RandomAccessFile( temp ,"rw");
     raFile.writeChars(GSXDocumentString);
    }
    catch (FileNotFoundException e )
    {
     e.printStackTrace();
    }
    catch (IOException e )
    {
     e.printStackTrace();
    }
    return temp;    
   }
   
   /**
    * @param lang
    * @param type
    * @param dataChar
    * @return java.lang.String
    * @roseuid 3B06A61C002F
    */
   public static String createDataElement(String lang, String type, String dataChar) 
   {
   String ans = "<DATA LANG=\"" + lang + "\" TYPE=\""+type + "\" >\n"+dataChar+"\n</DATA>\n";
   return ans;    
   }
   
   /**
    * @param dataElements
    * @return java.lang.String
    * @roseuid 3B06A61C004C
    */
   public static String createGSXElement(String dataElements) 
   {
   String ans = "<GSX>\n"+ dataElements +"</GSX>";
   return ans;    
   }
   
   /**
    * @param GSXElement
    * @param withDTD
    * @return java.lang.String
    * @roseuid 3B06A61C0060
    */
   public static String createGSXDocument(String GSXElement, boolean withDTD) 
   {
   String ans= "<?xml version=\"1.0\"?>\n";
   if (withDTD)
    {
      ans+= createGSXDTD(true)+"\n";
    }
   ans+=GSXElement;
   return ans;    
   }
   
   /**
    * @param isInternal
    * @return java.lang.String
    * @roseuid 3B06A61C0074
    */
   public static String createGSXDTD(boolean isInternal) 
   {
   if (isInternal)
    {
     String ans="";

     return ans;
    }
   return "<!DOCTYPE GSX SYSTEM \"gsxDTD.dtd\">";    
   }
}
