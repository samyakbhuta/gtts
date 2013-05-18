//Source file: C:\\project\\ss\\lang\\gu\\prepro\\PreProcessor.java

package project.ss.lang.gu.prepro;

import java.io.*;
import project.ss.exception.*;

/**
 * This interface describes the functionality of Preprocessor. The Preprocessor is 
 * the one in TTS systems which resolves the ambiguity involved in input text 
 * string for the later stages of TTS system. The ambiguity in the text can be 
 * e.g., 123, Mr. etc.
 * Such text sequence in the input text doesn't maps to any single sound utterance 
 * and possesses the different sounds when read.
 * 
 * 	i.e.,	123		One hundred twenty three
 * 		Mr.		Mister.
 * 		etc.               etcetra 
 * 
 * Such whole set of ambiguity is resolved by Preprocessor.
 * This interface is language specific and should be developed for each language 
 * separately.
 * 
 * Single method PreProcess () with two overloaded versions is used to get the 
 * preprocessed strings.
 */						
public interface PreProcessor 
{
   
   /**
    * Preprocess the given String 
    * 
    * @param rawGujString
    * @return java.lang.String
    * @throws project.ss.exception.UnsupportedGU
    * @roseuid 3B06A664024E
    */
   public String preProcess(String rawGujString) throws UnsupportedGU;
   
   /**
    * Preprocess the content given in GSX file
    * 
    * @param GSXFile
    * @return java.lang.String
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @throws project.ss.exception.UnsupportedGU
    * @roseuid 3B06A66402BC
    */
   public String preProcess(File GSXFile) throws ImproperGSXFile, IOException, UnsupportedGU;
   /**
    *  unprocessed-raw text
    */
}
