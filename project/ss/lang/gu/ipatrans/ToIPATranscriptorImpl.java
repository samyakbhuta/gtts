//Source file: C:\\project\\ss\\lang\\gu\\ipatrans\\ToIPATranscriptorImpl.java

package project.ss.lang.gu.ipatrans;

/**
 * note its a  Transcriptor and not a translator
 */
import project.ss.lang.gu.*;
import project.ss.exception.*;
import project.ss.xml.*;
import java.io.*;
import java.util.regex.*;

/**
 * This class implements the functionality described in the ToIPATrans interface. 
 * The class is designed to provide IPA equivalent of the Gujarati Unicode text. 
 * Currently class only provides phonetic transcription. It uses different classes 
 * to do the job of transcription.
 */
public class ToIPATranscriptorImpl implements ToIPATranscriptor 
{
   NewEditor newe;
   /**
    * It is used to handle the GSX Files.
    */
   static GSXHandler gsxHandler = new GSXHandlerImpl ();
   
   /**
    * Provides the equivalent IPA transcription of specified Gujarati Unicode string.
    * 
    * @param processedGUString
    * @return java.lang.String
    * @throws project.ss.exception.UnsupportedGU
    * @roseuid 3B06A66500B5
    */
   public String transcriptToIPA(String processedGUString) throws UnsupportedGU 
   {
    //GujCharSupport.isValidGujString(processedGUString);
         newe=new NewEditor();
	
	String retString=newe.getFinalString(processedGUString);
       /* Pattern p = Pattern.compile(" ");
        String abc[]=null;
        abc=p.split(retString);
	System.out.println("^^^^^^^^^^^^^^^^^^^^"+abc[0]);
        String changedString=abc[0];
        System.out.println("^^^^^^^^^^^^^^^^^^^^"+changedString);
	return changedString;*/
	return retString;
   // return GujToIPATranslator.toIPA(processedGUString);    
   }
   
   /**
    * Provides the equivalent IPA transcription of the data extracted from the GSX 
    * file.
    * @param GSXFile
    * @return java.lang.String
    * @throws project.ss.exception.UnsupportedGU -  processed  text
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @roseuid 3B06A6650119
    */
   public String transcriptToIPA(File GSXFile) throws ImproperGSXFile, IOException, UnsupportedGU 
   {
   String proGujString =  gsxHandler.getGUProString( GSXFile );
   System.out.println("________Pro GUJ String ________ " + proGujString);
   return transcriptToIPA ( proGujString );    
   }
}
