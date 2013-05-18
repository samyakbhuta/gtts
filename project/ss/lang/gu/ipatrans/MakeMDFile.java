import java.util.*;
import java.io.*;
import javax.sound.sampled.*;
import java.util.regex.*;

/**
* This class is used to create a file which stores the Information
* of all the sound files present in the DataBase. 
* The file created contains FileName,its starting position and its Frame-Length.
* It has one constructor which has one parameter as Type File.
*/

public class MakeMDFile
{    

   	/** This constructor has one parameter as type File which is the name
	 * of the directory where all sound files are stored.
         * This constructor will fetch sound files from this directory and
	 * stores the respective information in the specified Txt file mentioned
	 * in this constructor.
	 */

	public MakeMDFile(File directory)throws IOException
	{
		AudioInputStream ais=null;
		File dir=directory;
		File  files [] = dir.listFiles();
		long prev=0;
		Vector vector = new Vector( files.length);
		long size=0,last=0;
		String label[]=null;
		Pattern p = Pattern.compile("\\.");
		PrintWriter pw=new PrintWriter(new FileOutputStream("AllFilesInfo.txt"),true);
                long temp=0;
                int totSampleLength=0;
		for ( int i=0;i<files.length;i++)
     		{
			
			label= p.split( files[i].getName());
			System.out.println(i+label[0]);
			try
			{
			 ais =  AudioSystem.getAudioInputStream(files[i]);
			}
			catch(Throwable t){System.out.println(t);}
			//size+=ais.available();
                       // temp=size-last;
			pw.println(label[0]+";"+totSampleLength+";"+ais.getFrameLength());
			System.out.println("frame:"+ais.getFrameLength()+"avail:"+ais.available());
                        totSampleLength+=ais.getFrameLength();
			//prev=temp;
                       // last=size;
		}
	}
	public static void main(String args[])throws IOException
	{
		new MakeMDFile(new File("C/tts/Diphones/All_Diphones"));
	}
}