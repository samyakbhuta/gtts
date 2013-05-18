package project.ss;
import java.io.*;
import java.util.*;

/**
 * This class gives the information of appropriate sound files when required.
 * This class has one static method getInfo(String IPAString).
 * This static class returns the Two-dimentional integer array which contains the information about the sound files.
 */

public class GetInfo
{ 
        int j=0;

        /**
	 * This is the constructer of GetInfo class.
	 */

        public GetInfo()throws Throwable
        {
        }

	/**
	 *  This is the static method of this class which returns a Two Dimentional integer array that is the file size and no
	 * of frames.It has one parameter which is the IPAString.
	 */

	public static int[][] getInfo(String chkstr)throws Throwable
	{
                int aa[]=new int[100];
                int bb[]=new int[100];
                int arr[][]=new int[10][10];
                int count=0;
                int strLen=chkstr.length();
                
                System.out.println("--------------------------------"+chkstr);
                int i=0;
                String str,indstr;
                BufferedReader br;
		br=new BufferedReader(new InputStreamReader(new FileInputStream("./project/ss/AllFilesInfo.txt"))); 
                boolean bool=false;int sp=0,totLen=0;
                GetInfo gi=new GetInfo();
               
                while(((str=br.readLine())!= null) )
                {    
                    StringTokenizer st=new StringTokenizer(str,";");
                    String tokStr="";
                    
                    while(st.hasMoreTokens())
                    {  
                            tokStr=(String)st.nextElement();
                            if(chkstr.equals(tokStr))
                            {
                                System.out.println("String matched.");
                                arr[0][0]=Integer.parseInt((String)st.nextElement());
                                arr[0][1]=Integer.parseInt((String)st.nextElement());  
                            }
                            
                    }  // inner while
                }   //outer while.
               
                
                return arr;
	} 
}