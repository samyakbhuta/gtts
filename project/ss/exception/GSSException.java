//Source file: C:\\project\\ss\\exception\\GSSException.java

package project.ss.exception;


/**
 * This class extends the general Exception class. This class is a super class of 
 * all the exceptions thrown in SS package. It provides a description as string 
 * which tells more about the nature of the exception.
 */
public class GSSException extends Exception 
{
   
   /**
    * Holds the description about the nature of exception
    */
   String description = "";
   
   /**
    * Constructor with description
    * 
    * @param desc
    * @roseuid 3B06A6660283
    */
   public GSSException(String desc) 
   {
    description = desc;    
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3B06A666028E
    */
   public String toString() 
   {
    return "GSSException : " + description;    
   }
}
