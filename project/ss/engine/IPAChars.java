	//Source file: C:\\project\\ss\\engine\\IPAChars.java

package project.ss.engine;

/**
 * This class conatins all the IPA char and diacritics accepted by core engine
 * Some char e.g. '+' may not be in standard but has included
 * if u include here some other char make sure u include it in
 * return statement of getALLchar method.
 */
import project.ss.exception.*;

/**
 * A utility class used to store the recognized IPA for the core engine
 */
public class IPAChars
{

   /**
    * make it a regex way
    * three whitespaces are recognized they are \t,\n and " ";
    * Possible marks
    * intonation still to include
    * syllable break  still to include
    * Consonants in Gujarati
    */
   static final String K = "\u006B";
   static final String G = "\u0067";
   static final String N_K = "\u014B";
   static final String TS = "\u02A7";
   static final String DJ = "\u02A4";
   static final String N_TS = "\u0272";
   static final String TT = "\u0288";
   static final String DD = "\u0256";
   static final String N_TT = "\u0273";
   static final String T = "\u0074";
   static final String D = "\u0064";
   static final String N_T = "\u006E";
   static final String P = "\u0070";
   static final String B = "\u0062";
   static final String N_P = "\u006D";
   static final String S = "\u0073";
   static final String SH = "\u0283";
   static final String L = "\u006C";
   static final String LL = "\u026D";
   static final String R = "\u027E";
   static final String J = "\u006A";
   static final String V = "\u0076";
   static final String H = "\u0068";

   /**
    * vowels
    */
   static final String A = "\u0259";
   static final String AA = "\u0061";
   static final String I = "\u0069";
   static final String E = "\u0065";
   static final String EE = "\u025B";
   static final String U = "\u0075";
   static final String O = "\u006F";
   static final String OO = "\u0254";

   /**
    * diacritics and other
    */
   static final String DIA_ASPI = "\u02B0";
   static final String DIA_ALONG = "\u02D0";
   static final String DIA_UNSYL = "\u032F";
   static final String DIA_NASS = "\u0303";
   static final String DIA_JUNCTURE = "+";
   static final String DIA_UTT_OPEN = "[";

   /**
    * u may like to change it acco to standard
    */
   static final String DIA_UTT_CLOSE = "]";
   static final String DIA_SENT_OPEN = "{";
   static final String DIA_SENT_CLOSE = "}";

   /**
    * stress
    */
   static final String DIA_STRESS_PRIME = "\u02C8";
   static final String DIA_STRESS_SECOND = "\u02CC";

   /**
    * @param ch
    * @return boolean
    * @throws project.ss.exception.UnsupportedIPA
    * @roseuid 3AFF70FA028B
    */
   public static boolean isValidIPAChar(char ch) throws UnsupportedIPA
   {
    if (  IPAChars.getAllChars().indexOf(ch) == -1 )
    {
      System.out.println("NOT Valid IPA : " + ch );
      throw new UnsupportedIPA("Char "+ ch + " is not supported");
    }
    System.out.println("Valid IPA : " + ch );
    return true ;
   }

   /**
    * @return java.lang.String
    * @roseuid 3B06A6490001
    */
   public static String getAllChars()
   {
  return " \t\n"+K+G+N_K+TS+DJ+N_TS+TT+DD+N_TT+T+D+N_T+P+B+N_P+
           S+SH+L+LL+R+J+V+H+
           A+AA+I+E+EE+U+O+OO+
           DIA_ASPI+DIA_ALONG+DIA_UNSYL+DIA_NASS+DIA_JUNCTURE+
           DIA_UTT_OPEN+DIA_UTT_CLOSE+DIA_SENT_OPEN+DIA_SENT_CLOSE+
           DIA_STRESS_PRIME+DIA_STRESS_SECOND;
           // make changes here also
   }

   /**
    * @param ipaPhoneme
    * @return boolean
    * @roseuid 3B06A6490033
    */
   public static boolean isVowel(String ipaPhoneme)
   {
   if (
        ipaPhoneme.equals(A) || ipaPhoneme.equals(AA) || ipaPhoneme.equals(I) ||
        ipaPhoneme.equals(E) || ipaPhoneme.equals(EE) || ipaPhoneme.equals(U) ||
        ipaPhoneme.equals(O) || ipaPhoneme.equals(OO) ||
        ipaPhoneme.equals(A+DIA_ALONG) || ipaPhoneme.equals(AA+DIA_ALONG) || ipaPhoneme.equals(I+DIA_ALONG) ||
        ipaPhoneme.equals(E+DIA_ALONG) || ipaPhoneme.equals(EE+DIA_ALONG) || ipaPhoneme.equals(U+DIA_ALONG) ||
        ipaPhoneme.equals(O+DIA_ALONG) || ipaPhoneme.equals(OO+DIA_ALONG) ||
        ipaPhoneme.equals(A+DIA_NASS) || ipaPhoneme.equals(AA+DIA_NASS) || ipaPhoneme.equals(I+DIA_NASS) ||
        ipaPhoneme.equals(E+DIA_NASS) || ipaPhoneme.equals(EE+DIA_NASS) || ipaPhoneme.equals(U+DIA_NASS) ||
        ipaPhoneme.equals(O+DIA_NASS) || ipaPhoneme.equals(OO+DIA_NASS)
      )
   {
      return true ;
   }

   return false;
   }

   /**
    * @param ipaPhoneme
    * @return boolean
    * @roseuid 3B06A6490051
    */
   public static boolean isConso(String ipaPhoneme)
   {
   if (
        ipaPhoneme.equals(K) || ipaPhoneme.equals(K+DIA_ASPI) ||
        ipaPhoneme.equals(G) || ipaPhoneme.equals(G+DIA_ASPI) ||
        ipaPhoneme.equals(N_K) ||
        ipaPhoneme.equals(TS) || ipaPhoneme.equals(TS+DIA_ASPI)||
        ipaPhoneme.equals(DJ) || ipaPhoneme.equals(DJ+DIA_ASPI)||
        ipaPhoneme.equals(N_TS) ||
        ipaPhoneme.equals(TT) || ipaPhoneme.equals(TT+DIA_ASPI)||
        ipaPhoneme.equals(DD) || ipaPhoneme.equals(DD+DIA_ASPI)||
        ipaPhoneme.equals(N_TT) ||
        ipaPhoneme.equals(T) || ipaPhoneme.equals(T+DIA_ASPI)||
        ipaPhoneme.equals(D) || ipaPhoneme.equals(D+DIA_ASPI)||
        ipaPhoneme.equals(N_T) ||
        ipaPhoneme.equals(P) || ipaPhoneme.equals(P+DIA_ASPI)||
        ipaPhoneme.equals(B) || ipaPhoneme.equals(B+DIA_ASPI)||
        ipaPhoneme.equals(N_P) ||
        ipaPhoneme.equals(S) || ipaPhoneme.equals(SH)||
        ipaPhoneme.equals(L) || ipaPhoneme.equals(LL)||
        ipaPhoneme.equals(R) || ipaPhoneme.equals(J)||
        ipaPhoneme.equals(V) || ipaPhoneme.equals(H)
       )
     {
       return true;
     }
   return false;
   }

   /**
    * @param ipaPhoneme
    * @return boolean
    * @roseuid 3B06A649006F
    */
   public static boolean isUnSyllVowel(String ipaPhoneme)
   {
   if (
        ipaPhoneme.equals(A+DIA_UNSYL) || ipaPhoneme.equals(AA+DIA_UNSYL) || ipaPhoneme.equals(I+DIA_UNSYL) ||
        ipaPhoneme.equals(E+DIA_UNSYL) || ipaPhoneme.equals(EE+DIA_UNSYL) || ipaPhoneme.equals(U+DIA_UNSYL) ||
        ipaPhoneme.equals(O+DIA_UNSYL) || ipaPhoneme.equals(OO+DIA_UNSYL)
       )
   {
     return true;
   }
   return false;
   }

   /**
    * @param s
    * @return boolean
    * @throws project.ss.exception.UnsupportedIPA
    * @roseuid 3B06A649008D
    */
   public static boolean isValidIPAString(String s) throws UnsupportedIPA
   {
   boolean ret=true;
   for (int i=0;i<s.length();i++)
     {
      try
       {
         isValidIPAChar( s.charAt(i) );
       }
       catch (UnsupportedIPA e)
       {
         ret=false;
         continue;
       }
     }
     if (ret == false)
     {
       throw new UnsupportedIPA("String "+ s + " is not valid");
     }
   return ret;
   }
}
/*
void IPAChars.main(java.lang.String[]){ // method just to test
  System.out.println( getAllChars());
  String sb ="abjspevh";
  for (int i=sb.length();i>0;i--)
        {
          System.out.println(i);
          String ipaChar = sb.substring(i-1,i);
          System.out.println(ipaChar);
        }
   }
 */
