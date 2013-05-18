//Source file: C:\\project\\ss\\lang\\gu\\ipatrans\\GujToIPATranslator.java

package project.ss.lang.gu.ipatrans;

/**
 * maps a gujararti text to english text or IPA text
 * so that pronounciation remains intact
 * we can utilize it in EngTTS
 */
import project.ss.lang.gu.*;

/**
 * The Phonetic translater which converts a Gujarati Text into IPA with
 * the help of GujToIPAMappper
 */
public class GujToIPATranslator
{

   /**
    * algorithm to produce IPA equvivalent of gujarati text
    *
    * @param gujText
    * @return java.lang.String
    * @roseuid 3B06A66502D2
    */
   public static String toIPA(String gujText)
   {
   // ur algo
   String joiner="\u0259";
   StringBuffer  ipaText  =  new StringBuffer();
   String ipaChar="";
   String gujChar="";
   boolean  shld_apply_joiner= false;    // since the first char need not assign 'reverse e'    we make it false




   for (int i=0;i<gujText.length();i++)
   {
        gujChar = gujText.substring(i,i+1) ;

        if ( GujCharSupport.isConsonant(gujChar))
        {
              if ( shld_apply_joiner )
              {
                  ipaText.append(joiner);
              }
              ipaChar = GujToIPAMapper.findIPAChar (gujChar);
              ipaText.append(ipaChar);
              shld_apply_joiner=true;
        }
        if ( GujCharSupport.isIndeVowel(gujChar))
        {
              if ( shld_apply_joiner )
              {
                  ipaText.append(joiner);
              }
              ipaChar = GujToIPAMapper.findIPAChar (gujChar);
              ipaText.append(ipaChar);
              shld_apply_joiner=false;
        }
        if ( GujCharSupport.isDepeVowel(gujChar))
        {

              ipaChar = GujToIPAMapper.findIPAChar (gujChar);
              ipaText.append(ipaChar);
              shld_apply_joiner=false;
        }
        if ( GujCharSupport.isHalant(gujChar))
        {
              shld_apply_joiner=false;
        }
        if ( GujCharSupport.isWhitespace(gujChar))
        {
              if ( shld_apply_joiner )  // this if vary according to context ( ask the lingu
              {
                 // ipaText.append(joiner);
              }
              ipaText.append(gujChar); // i.e. whitespace it self of whatever type
              shld_apply_joiner=false;
        }
   }
   // MAKE SURE THAT ATLEAST ONE VOWELSOUND APPEARS IN THE CONVERTED IPA STRING
   // OTHERWISE IT WILL NOT BE PRONOUNCED PROPERLY
   if ( gujText.length() == 1 )
        {
   		  ipaText.append(joiner);
	 }
   return  ipaText.toString();
   }
}
