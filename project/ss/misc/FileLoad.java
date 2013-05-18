        //Source file: C:\\project\\ss\\misc\\FileLoad.java

package project.ss.misc;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

/**
 * Utility class that has methods for file related operations
 */
public class FileLoad 
{
   
   /**
    * The method returns  CharBuffer ( from Java 1.4 ) which can fetch the 
    * data from the file specified with given encoding.The buffers state remains
    * read only so no  file damage can take place
    * 
    * @param file
    * @param encoding
    * @return java.nio.CharBuffer
    * @roseuid 3B06A66700FE
    */
   public static CharBuffer getCharBufferRO(File file, String encoding) 
   {
    CharBuffer charBuffer=null;
  try
   {
     FileInputStream fis = new FileInputStream (file);
     FileChannel channel = fis.getChannel();
     int filelength = (int)channel.size();
     MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY,0,filelength);
     Charset charset =  Charset.forName(encoding);
     CharsetDecoder decoder = charset.newDecoder();
     charBuffer = decoder.decode(buffer);
	 System.out.println("in file load class"); 
   }
   catch ( FileNotFoundException e )
   {
    e.printStackTrace();
   }
   catch ( IOException e )
   {
    e.printStackTrace();
   }
    return charBuffer;    
   }
   
   /**
    * Write the text file with  given content and  encoding 
    * 
    * @param file
    * @param content
    * @param encoding
    * @roseuid 3B06A667011D
    */
   public static void writeFile(File file, String content, String encoding) 
   {
    try
    {
     OutputStreamWriter osw = new OutputStreamWriter ( new FileOutputStream(file),encoding );
    // content="sdgasggdfh";
     osw.write(content,0,content.length());
     //osw.write( 67);
     osw.close();
    }
     catch(FileNotFoundException e)
    {
      e.printStackTrace();
    }
     catch(UnsupportedEncodingException e)
    {
      e.printStackTrace();
    }
     catch(IOException e)
    {
      e.printStackTrace();
    }    
   }
   /**
    *  public static void main (String args [])
    *   {
    *     File dir = new File ("C:/project/voice/parts");
    *     File outputVoiceFile = new File ( dir ,  "partVoice.vf" );
    *     writeFile( outputVoiceFile , "aaaaaaaaaaaaaa" ,"UTF-16BE");
    *   }
    */
}
