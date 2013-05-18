package project.ss.lang.gu.ipatrans;
import java.io.*;
import java.util.*;

/**
 *This class takes input as IPA String and returns the diphone string.
 *It has one mathod named getString(String IPAString) which returns the diphone string.
 *This class uses two static classes Check and IPAToSring.
 */

public  class FileName
{
	//String str;

        /*It has one mathod named getString(String IPAString) which returns the diphone string.
	 *Check class is used to check the occurence of Vowels,consonants or Independent vowels.
	 */
         
	public static String getString(String str)
	{
               
                int strLength=str.length();
                String strStr="",sec="",last="";
		boolean depVow,indeVow,cons,prev,next,halant;
		String modiString="",defJoiner="a",sentance="",partnemeString="";
                StringBuffer sb=new StringBuffer();
                 
                int indOfUs;
		
                int j=0;
                System.out.println("Length:"+strLength); 
                if(strLength==1)
                {
                   cons=Check.isConsonant(String.valueOf(str.charAt(0)));
                   halant=Check.isHalant(String.valueOf(str.charAt(0)));
                   if(halant==true)System.exit(0);
                    if(strLength==1)
                    { 
                        if(cons==true)
                        {
                            strStr=IPAToString.giveString(String.valueOf(str.charAt(0)));
                            sb.append(strStr+"_a");
                        }
                        //return(sb.toString());
                    }
                   /*if(strLength==2)
                    {    
                        if(cons==true)
                        {
                            strStr=IPAToString.giveString(String.valueOf(str.charAt(0)));
                            sb.append(strStr+"_");
                            next=Check.isConsonant(String.valueOf(str.charAt(1)));
                            if(next==false)
                            {
                                 strStr=IPAToString.giveString(String.valueOf(str.charAt(1)));
                                 sb.append(strStr+"<>");
                            }
                        }
                        // return sb.toString();
                    }   */
                    return sb.toString();
                }
                else
                {
		for(int i=0;i<str.length();i++)
		{
                        
			depVow=indeVow=cons=false;
			cons=Check.isConsonant(String.valueOf(str.charAt(i)));
			depVow=Check.isDepVowel(String.valueOf(str.charAt(i)));
			indeVow=Check.isIndeVowel(String.valueOf(str.charAt(i)));
                        strStr=IPAToString.giveString(String.valueOf(str.charAt(i)));
                        // sec=IPAToString.giveString(String.valueOf(str.charAt(i+1)));
			if(cons==true&&i==0)
			{
				next=Check.isConsonant(String.valueOf(str.charAt(i+1)));
				//sb.append(GujToIPA.toIPA(String.valueOf(str.charAt(i)))+"_");
                                halant=Check.isHalant(String.valueOf(str.charAt(i+1)));
                              //  if(halant==true) System.exit(0);
                                
				if(next==true)
				{sb.append(strStr+"_");
					sb.append(defJoiner);
                                        sb.append("=");
                                       
				}
				if(next==false&&halant==false){
                                    sb.append(strStr+"_");
					//sb.append(GujToIPA.toIPA(String.valueOf(str.charAt(i+1))));
                                        sec=IPAToString.giveString(String.valueOf(str.charAt(i+1)));
                                        sb.append(sec+"=");
                                }
                               if(next==false&&halant==true)sb.append(strStr+"_");
			}
			if(cons==true&& (i>0&&i<strLength-1) )
			{
				prev=Check.isConsonant(String.valueOf(str.charAt(i-1)));
                               halant=Check.isHalant(String.valueOf(str.charAt(i-1)));
				if(prev==true)
				{
					//sb.append(defJoiner+"_"+GujToIPA.toIPA(String.valueOf(str.charAt(i)))+"_");
                                        sb.append(defJoiner+"_"+strStr+"_");
                                       
				}
				if(prev==false&&halant==false)
				{
                                        last=IPAToString.giveString(String.valueOf(str.charAt(i-1)));
					//sb.append(last+"_"+GujToIPA.toIPA(String.valueOf(str.charAt(i)))+"_");
                                        sb.append(last+"_"+strStr+"_");
				}
                                if(prev==false&&halant==true)
                                {
                                    sb.append(strStr+"_");
                                }
                                j=i+1;
				next=Check.isConsonant(String.valueOf(str.charAt(j)));
                                halant=Check.isHalant(String.valueOf(str.charAt(j)));
				if(next==true)
				{
					sb.append(defJoiner);
                                        sb.append("=");
				}
				if(next==false&&halant==false)
				{
                                        sec=IPAToString.giveString(String.valueOf(str.charAt(i+1)));
					//sb.append(GujToIPA.toIPA(String.valueOf(str.charAt(i+1))));
                                        sb.append(sec+"=");
				}
                               
			}
                        if(cons==true&&i==strLength-1&&i>0)
                        {
                           
				prev=Check.isConsonant(String.valueOf(str.charAt(i-1)));
                                halant=Check.isHalant(String.valueOf(str.charAt(i-1)));
				if(prev==true&&halant==false)
				{
					sb.append(defJoiner+"_");
				}
				if(prev==false&&halant==false)
				{
					//sb.append(GujToIPA.toIPA(String.valueOf(str.charAt(i-1)))+"_");
                                        last=IPAToString.giveString(String.valueOf(str.charAt(i-1)));
                                        sb.append(last+"_");
				}   
                                //sb.append(GujToIPA.toIPA(String.valueOf(str.charAt(i))));       
                                sb.append(strStr);       
                        }
                       if(cons==false && i==strLength-1&&i>0)
                        {
                            System.out.println(sb.lastIndexOf("_"));
                            indOfUs=sb.lastIndexOf("_");
                            //sb.replace(indOfUs,sb.length(),GujToIPA.toIPA(String.valueOf(str.charAt(i))));
                            sb.replace(indOfUs,sb.length(),strStr);
                        }
                         strStr="";sec="";last="";
		}
                
		return(sb.toString());
                }
	
	}
} 