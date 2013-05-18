//Source file: C:\\project\\ss\\xml\\GSXHandler.java

package project.ss.xml;

import project.ss.exception.*;
import java.io.*;

/**
 * This interface provides abstraction for the data extracting and validation
 * out of the GSX files.
 */
public interface GSXHandler 
{
   
   /**
    * The method tells weather the given GSX file is a valid one
    * otherwise throws an ImproperGSXFile exception
    * 
    * @param GSXFile
    * @return boolean
    * @throws project.ss.exception.ImproperGSXFile
    * @roseuid 3AFF748E02F7
    */
   public boolean isValid(File GSXFile) throws ImproperGSXFile;
   
   /**
    * Returns the whole set of string conatined in the da elemnts of GSX
    * file with LANG attribute with value "IPA"
    * 
    * @param GSXFile
    * @return java.lang.String
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @roseuid 3B06A646024B
    */
   public String getIPAString(File GSXFile) throws ImproperGSXFile, IOException;
   
   /**
    * Returns the whole set of string conatined in the da elemnts of GSX
    * file with LANG attribute with value "GU" and TYPE  attribute with value "RAW"
    * 
    * @param GSXFile
    * @return java.lang.String
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @roseuid 3B06A646031D
    */
   public String getGURawString(File GSXFile) throws ImproperGSXFile, IOException;
   
   /**
    * Returns the whole set of string conatined in the da elemnts of GSX
    * file with LANG attribute with value "GU" and TYPE  attribute with value 
    * "PROCESSED"
    * 
    * @param GSXFile
    * @return java.lang.String
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @roseuid 3B06A6470012
    */
   public String getGUProString(File GSXFile) throws ImproperGSXFile, IOException;
}
