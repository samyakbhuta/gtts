//Source file: C:\\project\\ss\\lang\\gu\\ipatrans\\GujToIPAMapper.java

package project.ss.lang.gu.ipatrans;


/**
 * maps a gujararti char to english text or IPA char
 */
public class GujToIPAMapper
{

   /**
    * Holds the Gujarati part of the mapping data
    */ static String gujs[] = {
   "\u0A80",
   "\u0A81",
   "\u0A82",
   "\u0A83",
   "\u0A84",
   "\u0A85",
   "\u0A86",
   "\u0A87",
   "\u0A88",
   "\u0A89",
   "\u0A8A",
   "\u0A8B",
   "\u0A8C",
   "\u0A8D",
   "\u0A8E",
   "\u0A8F",
   "\u0A90",
   "\u0A91",
   "\u0A92",
   "\u0A93",
   "\u0A94",
   "\u0A95",
   "\u0A96",
   "\u0A97",
   "\u0A98",
   "\u0A99",
   "\u0A9A",
   "\u0A9B",
   "\u0A9C",
   "\u0A9D",
   "\u0A9E",
   "\u0A9F",
   "\u0AA0",
   "\u0AA1",
   "\u0AA2",
   "\u0AA3",
   "\u0AA4",
   "\u0AA5",
   "\u0AA6",
   "\u0AA7",
   "\u0AA8",
   "\u0AA9",
   "\u0AAA",
   "\u0AAB",
   "\u0AAC",
   "\u0AAD",
   "\u0AAE",
   "\u0AAF",
   "\u0AB0",
   "\u0AB1",
   "\u0AB2",
   "\u0AB3",
   "\u0AB4",
   "\u0AB5",
   "\u0AB6",
   "\u0AB7",
   "\u0AB8",
   "\u0AB9",
   "\u0ABA",
   "\u0ABB",
   "\u0ABC",
   "\u0ABD",
   "\u0ABE",
   "\u0ABF",
   "\u0AC0",
   "\u0AC1",
   "\u0AC2",
   "\u0AC3",
   "\u0AC4",
   "\u0AC5",
   "\u0AC6",
   "\u0AC7",
   "\u0AC8",
   "\u0AC9",
   "\u0ACA",
   "\u0ACB",
   "\u0ACC"
   };

   /**
    * Holds the IPA part of the mapping data
    */
   static String ipas[] = {
   "",
   "",
   "",
   "",
   "",
   "\u0259",
   "a",
   "i",
   "i",
   "u",
   "u",
   "",
   "",
   "\u025B",
   "",
   "e",
   "\u0259i\u032F",
   "\u0254",
   "",
   "o",
   "\u0259u\u032F",
   "k",
   "k\u02B0",
   "g",
   "g\u02B0",
   "\u014B",
   "\u02A7",
   "\u02A7\u02B0",
   "\u02A4",
   "\u02A4\u02B0",
   "\u0272",
   "\u0288",
   "\u0288\u02B0",
   "\u0256",
   "\u0256\u02B0",
   "\u0273",
   "t",
   "t\u02B0",
   "d",
   "d\u02B0",
   "n",
   "",
   "p",
   "p\u02B0",
   "b",
   "b\u02B0",
   "m",
   "j",
   "\u027E",
   "",
   "l",
   "\u026D",
   "",
   "v",
   "\u0283",
   "\u0283",
   "s",
   "h",
   "",
   "",
   "",
   "",
   "a",
   "i",
   "i",
   "u",
   "u",
   "",
   "",
   "\u025B",
   "",
   "e",
   "\u0259i\u032F",
   "\u0254",
   "",
   "o",
   "\u0259u\u032F"
   };

   /**
    * Returns an equvivalent IPA fro the given Gujarati String(With single char)
    *
    * @param gujChar
    * @return java.lang.String
    * @roseuid 3B06A6650278
    */
   public static String findIPAChar(String gujChar)
   {
	//System.out.println(\u027E);
       for(int i=0 ; i < gujs.length;i++)
           { 
                if ( gujChar.equals(gujs[i]))
                {  
                    System.out.println(ipas[i]); 
			return ipas[i];
                }
            }
	return("?");
   }
}
