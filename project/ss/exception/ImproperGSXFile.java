//Source file: C:\\project\\ss\\exception\\ImproperGSXFile.java

package project.ss.exception;


/**
 * This exception is thrown when GSX file provided to the GSX handler class is 
 * either invalid or new well formed et al improper Data Feed.
 */
public class ImproperGSXFile extends GSSException 
{
   
   /**
    * @param desc
    * @roseuid 3B06A66603D8
    */
   public ImproperGSXFile(String desc) 
   {
    super(desc);    
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3B06A66603E2
    */
   public String toString() 
   {
    return "ImproperGSXFile : " + description;    
   }
}
