//Source file: C:\\project\\ss\\exception\\UnsupportedGU.java

package project.ss.exception;


/**
 * This class extends the GSSException class and is thrown when an 
 * unrecognized character(s) is faced where only Gujarati Unicode character(s) is 
 * expected.
 */
public class UnsupportedGU extends GSSException 
{
   
   /**
    * @param desc
    * @roseuid 3B06A6660111
    */
   public UnsupportedGU(String desc) 
   {
    super(desc);    
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3B06A666011C
    */
   public String toString() 
   {
    return "UnsupportedGU : " + description;    
   }
}
