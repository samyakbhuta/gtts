//Source file: C:\\project\\ss\\exception\\UnsupportedIPA.java

package project.ss.exception;


/**
 * This class extends the GSSException class and is thrown when an unrecognized 
 * char(s) is faced where only IPA Unicode char(s) is expected.
 */
public class UnsupportedIPA extends GSSException 
{
   
   /**
    * @param desc
    * @roseuid 3B06A66602F2
    */
   public UnsupportedIPA(String desc) 
   {
     super(desc);    
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3B06A6660305
    */
   public String toString() 
   {
     return "UnsupportedIPA : " + description;    
   }
}
