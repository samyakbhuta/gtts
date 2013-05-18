//Source file: C:\\project\\ss\\engine\\IPAToPartnemeTranslator.java

package project.ss.engine;

import project.ss.exception.*;
import java.util.*;

/**
 * This interface provides the translation of the IPA string into the
 * partnemes.It hsa only one method to implement getPartneme()
 */
interface IPAToPartnemeTranslator 
{
   
   /**
    * Provides a equivalent partneme sequnece  fro specified IPA String.
    * Since this partneme string will be used by concatenater it should 
    * not outout the partneme sequence which is not stored in Voice Info File
    * used by Concatenater.
    * see Voice Info File 
    * 
    * @param ipaString
    * @return java.lang.String
    * @throws project.ss.exception.ImproperIPASequence
    * @roseuid 3B06A64D02EB
    */
   public String getPartnemeString(String ipaString) throws ImproperIPASequence;
}
