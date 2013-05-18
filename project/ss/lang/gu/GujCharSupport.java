//Source file: C:\\project\\ss\\lang\\gu\\GujCharSupport.java

package project.ss.lang.gu;

import java.util.regex.*;
import project.ss.exception.*;

/**
 * This utility class provides support for Gujarati UUnicode block
 */
public class GujCharSupport 
{
   static String indeVowels = "\u0A85\u0A86\u0A87\u0A88\u0A89" + "\u0A8A\u0A8B\u0A8C\u0A8D" + "\u0A8F\u0A90\u0A91" + "\u0A93\u0A94";
   static String depeVowels = "\u0ABE\u0ABF\u0AC0\u0AC1\u0AC2" + "\u0AC3\u0AC4\u0AC5" + "\u0AC7\u0AC8\u0AC9" + "\u0ACB\u0ACC";
   static String consonants = "\u0A95\u0A96\u0A97\u0A98\u0A99" + "\u0A9A\u0A9B\u0A9C\u0A9D\u0A9E" + "\u0A9F\u0AA0\u0AA1\u0AA2\u0AA3" + "\u0AA4\u0AA5\u0AA6\u0AA7\u0AA8" + "\u0AAA\u0AAB\u0AAC\u0AAD\u0AAE" + "\u0AAF\u0AB0" + "\u0AB2\u0AB3" + "\u0AB5\u0AB6\u0AB7\u0AB8\u0AB9";
   static String digits = "\u0ae6\u0ae7\u0ae8\u0ae9\u0aea\u0aeb\u0aec\u0aed\u0aee\u0aef";
   
   /**
    * @param ch
    * @return boolean
    * @throws project.ss.exception.UnsupportedGU
    * @roseuid 3AFF748102EF
    */
   public static boolean isValidGujChar(char ch) throws UnsupportedGU 
   {
    if (false)//Pattern.matches("[\u0A80-\u0AFF]",new Character(ch).toString()))
     {
       System.out.println("NOT Valid GU : " + ch );
       throw new UnsupportedGU("Char "+ ch + " is not supported");
     }
    System.out.println("Valid GU : " + ch );
    return true ;    
   }
   
   /**
    * @param s
    * @return boolean
    * @roseuid 3B06A66300F8
    */
   public static boolean isConsonant(String s) 
   {
       char c = s.charAt(0);
       return    (   consonants.indexOf(c)   >= 0  )   ;    
   }
   
   /**
    * @param s
    * @return boolean
    * @roseuid 3B06A6630116
    */
   public static boolean isIndeVowel(String s) 
   {
       char c = s.charAt(0);
       return    (    indeVowels.indexOf(c)   >= 0  )   ;    
   }
   
   /**
    * @param s
    * @return boolean
    * @roseuid 3B06A6630134
    */
   public static boolean isDepeVowel(String s) 
   {
      char c = s.charAt(0);
      return    (    depeVowels.indexOf(c)   >= 0  )   ;    
   }
   
   /**
    * @param s
    * @return boolean
    * @roseuid 3B06A663015D
    */
   public static boolean isDigit(String s) 
   {
       char c = s.charAt(0);
       return    (    digits.indexOf(c)   >= 0  )   ;    
   }
   
   /**
    * static boolean  isSpaceChar(String s)
    * {
    * }
    * 
    * @param s
    * @return boolean
    * @roseuid 3B06A663017B
    */
   public static boolean isModifier(String s) 
   {
      return false;    
   }
   
   /**
    * @param s
    * @return boolean
    * @roseuid 3B06A66301A3
    */
   public static boolean isCurrency(String s) 
   {
      return false;    
   }
   
   /**
    * @param s
    * @return boolean
    * @roseuid 3B06A66301C1
    */
   public static boolean isHalant(String s) 
   {
       char c = s.charAt(0);
       if    (   c == '\u0ACD'   )    
       {
           return true;
       }
       return false;    
   }
   
   /**
    * @param s
    * @return boolean
    * @roseuid 3B06A66301E9
    */
   public static boolean isAnusvara(String s) 
   {
      char c = s.charAt(0);
       if    (   c == '\u0A82'   )    
       {
           return true;
       }
       return false;    
   }
   
   /**
    * @param s
    * @return boolean
    * @roseuid 3B06A6630211
    */
   public static boolean isVisarga(String s) 
   {
      char c = s.charAt(0);
       if    (   c == '\u0A83'   )    
       {
           return true;
       }
       return false;    
   }
   
   /**
    * @param s
    * @return boolean
    * @roseuid 3B06A6630239
    */
   public static boolean isWhitespace(String s) 
   {
      char c = s.charAt(0);
      return    (  Character.isWhitespace(c) )    ;    
   }
   
   /**
    * @param s
    * @return boolean
    * @throws project.ss.exception.UnsupportedGU
    * @roseuid 3B06A66302BB
    */
   public static boolean isValidGujString(String s) throws UnsupportedGU 
   {
    boolean ret=true;
    for (int i=0;i<s.length();i++)
      {
       try
        {
          isValidGujChar( s.charAt(i) );
        }
       catch (UnsupportedGU e)
        {
          ret=false;
          continue;
        }
      }
    if (ret == false)
     {
       throw new UnsupportedGU("String "+ s + " is not valid");
     }
   return ret;    
   }
}
