//Source file: C:\\project\\ss\\lang\\gu\\ipatrans\\ToIPATranscriptor.java

package project.ss.lang.gu.ipatrans;

/**
 * note its a  Transcriptor and not a translator
 */
import project.ss.exception.*;
import java.io.*;

/**
 * This interface describes the operation which converts a text sequence (in the 
 * language for which implementation is provided) into equivalent IPA text. The 
 * implementation is free to provide IPA transcription in as much detail as 
 * possible including prosody. This output is used by CoreEngine interface which 
 * is responsible for speaking out the IPA sequence. So the implementation should 
 * not provide output which contains unrecognized IPA
 * for the next phase of processing.
 */
public interface ToIPATranscriptor 
{
   
   /**
    * Provides the equivalent IPA transcription of Specified String
    * 
    * @param proGujString
    * @return java.lang.String
    * @throws project.ss.exception.UnsupportedGU
    * @roseuid 3B06A665032C
    */
   public String transcriptToIPA(String proGujString) throws UnsupportedGU;
   
   /**
    * Provides equivalent IPA transcription of the text provided in GSX file.
    * 
    * @param GSXFile
    * @return java.lang.String
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @throws project.ss.exception.UnsupportedGU
    * @roseuid 3B06A6650390
    */
   public String transcriptToIPA(File GSXFile) throws ImproperGSXFile, IOException, UnsupportedGU;
   /**
    *  processed  text
    */
}
