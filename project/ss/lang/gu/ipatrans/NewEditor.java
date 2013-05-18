			package project.ss.lang.gu.ipatrans;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.util.regex.*;

/**
 * This class takes input as sequence of unicode characters and converts it to IPA.
 * This input is tokenized from paragraph level to word level string which is sent to another
 * class FileName which returns a string for further process.
 */

public class NewEditor 
{
      
       static char retchar;
       static boolean indVowelBool,depVowelBool;
       String str,s="",fileNameString="",prev="",ipaStr="",modiString="",sws=":",stBreak="",strs="";//string with space.;
       String stJStr="",sTosp,nam="";   
       static String indeVowel[]={"\u0A85","\u0A86","\u0A87","\u0A88","\u0A89","\u0A8A","\u0A8D","\u0A8F","\u0A90","\u0A91","\u0A93","\u0A94"};
       static String depVowel[]={"\u0ABE","\u0ABF","\u0AC0","\u0AC1","\u0AC2","\u0AC3","\u0AC4","\u0AC5","\u0AC7","\u0AC8","\u0AC9","\u0ACB","\u0ACC"};
      

       NewEditor()
       {
             
       }

       /**
	* This method has one parameter as a IPA String.
	* This string is tokenized to the lower level and sent to FileName class 
	* to get Diphone string required for further process.
	*/

	public  String getFinalString(String str)
        {
           for(int j=0;j<str.length();j++) 
           {
               s+=str.charAt(j);
               ipaStr+=GujToIPAMapper.findIPAChar(s);// this loop is converting the entered string to its resp. IPA. 
               s="";  
           }
           StringTokenizer stdot=new StringTokenizer(str,". ");
          
           while(stdot.hasMoreTokens())
           {
                sTosp=(String)stdot.nextElement();
                System.out.println("The Sentence with fullstop."+sTosp);
               /* for(int p=0;p<sTosp.length();p++)
                { 
                    boolean chkws;
                    char c = str.charAt(p);
                    chkws=Character.isSpaceChar(c);//checks the space
                    if(chkws==false)
                        sws+=sTosp.charAt(p);
                    else
                        sws+=":";
                }*/
                StringTokenizer st=new StringTokenizer(sTosp," ");
                int temp=0;
               
                System.out.println("In Words:"+st.countTokens());
                while(st.hasMoreTokens())
                {
                     
                    strs=(String)st.nextElement();
                    nam+=strs;
                    System.out.println("The Sentence with Space."+strs);
                    if(temp<st.countTokens())
                    {
                        modiString+=FileName.getString(strs)+"<>";//gives the required string
                    }
                    else
                        modiString+=FileName.getString(strs);//gives the required string
                }
                modiString+="&";
               sws="";
           } 
            
           System.out.println("Final String After Conversion:"+modiString);
          
	   System.out.println("MODIFIED STRING:"+modiString);
           Pattern p = Pattern.compile(" ");
           String abc[]=null;
           abc=p.split(modiString);
	   modiString="";
	   modiString=abc[0];
	   return modiString;    
       }
}
