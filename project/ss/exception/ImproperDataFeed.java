//Source file: C:\\project\\ss\\exception\\ImproperDataFeed.java

package project.ss.exception;


/**
 * This action is thrown by Concatenaters concatenateAndFeed( )method when the 
 * method find that it  was not able to feed all the data
 * for the corresponding partneme string supplied.
 * The reason for improper data  feed can be any 
 * resource constraints or simply Voice Info File
 * doesnt contained the support for the perticular partneme
 */
public class ImproperDataFeed extends GSSException 
{
   
   /**
    * @param desc
    * @roseuid 3B06A666036A
    */
   public ImproperDataFeed(String desc) 
   {
    super(desc);    
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3B06A6660375
    */
   public String toString() 
   {
    return "ImproperDataFeed : " + description;    
   }
}
