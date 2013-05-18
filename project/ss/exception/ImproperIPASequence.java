//Source file: C:\\project\\ss\\exception\\ImproperIPASequence.java

package project.ss.exception;


/**
 * The input to the core engine must follow certain rules.
 * It must provide sentence and utterance boundaries in logical sequence when this 
 * sequence is violated this exception is thrown.
 */
public class ImproperIPASequence extends GSSException 
{
   
   /**
    * @param desc
    * @roseuid 3B06A6660176
    */
   public ImproperIPASequence(String desc) 
   {
    super(desc);    
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3B06A6660189
    */
   public String toString() 
   {
    return "ImproperIPASequence : " + description;    
   }
}
