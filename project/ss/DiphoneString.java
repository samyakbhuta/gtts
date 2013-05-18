package project.ss;
import project.ss.engine.*;
import java.io.*;
import java.util.*;

/**
 * This class gets input as String and tokenizes it  to number of diphones found in it.
 * It collects all information about the diphone files and sends sound files information to another class ConcatenaterImpl class
 * Which in turn uses that information to play the sound files.
 */

public class DiphoneString
{

        /**
	 * This method tokenizes paragraph to sentences,sentence to words and word to diphone units.
	 * It then sends the tokenized diphones to GetInfo class to get sound files information.
	 * This method passes Arrays to the ConcatenaterImpl class which plays all the sound files.
	 */

	public static void getDiphone(String str)throws Throwable
	{
                System.out.println("From NewEditor To diphoneString"+str);
                int tdarr[][]=new int[100][100];
                int strlen=str.length();
                int aa[]=new int[strlen];
                int bb[]=new int[strlen];
                
                int countArrLen=0;
		String s=str;
		String prBreak="";
		System.out.println("The String Is:"+s);
		StringTokenizer st=new StringTokenizer(s,"&");
                int count=0;
		while(st.hasMoreTokens())
		{
			String stBreak="";
			prBreak=(String)st.nextElement();
			StringTokenizer st1=new StringTokenizer(prBreak,"<>");
			while(st1.hasMoreTokens())
			{
				stBreak=(String)st1.nextElement();
				StringTokenizer st2=new StringTokenizer(stBreak,"=");
				String wBreak="";
				while(st2.hasMoreTokens())
				{
					wBreak=(String)st2.nextElement();
					System.out.println(wBreak);
                                        try
                                        {
                                            GetInfo gi=new GetInfo();
                                            tdarr=GetInfo.getInfo(wBreak);
                                            aa[count]=tdarr[0][0];
                                            bb[count]=tdarr[0][1];
                                            count++;
                                        }
                                        catch(Exception ie)
                                        {
                                            System.out.println(ie);
                                        }
				}
			}
		}
                for(int f=0;f<aa.length;f++)
                {
                    if(aa[f]!=0&&bb[f]!=0)
                        countArrLen++;
                    else
                        break;
                }
                int cpaa[]=new int[countArrLen];
                int cpbb[]=new int[countArrLen];
                for(int l=0;l<countArrLen;l++)//this is to be improved.
                {
                        cpaa[l]=aa[l];
                        cpbb[l]=bb[l];  
                        System.out.println("/////////////////"+cpaa[l]+"\\\\\\\\\\\\\\"+cpbb[l]);
                }
               // PlayVoice pv=new PlayVoice(cpaa,cpbb);
		ConcatenaterImpl ci=new ConcatenaterImpl(cpaa,cpbb);
                
        }
        
       
}