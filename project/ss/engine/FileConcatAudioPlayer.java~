//Source file: C:\\project\\ss\\engine\\FileConcatAudioPlayer.java

package project.ss.engine;

import javax.sound.sampled.*;
import java.io.*;
import java.util.*;

public class FileConcatAudioPlayer 
{
   
     SourceDataLine  SDLine = null;
     TargetDataLine  TDLine = null;
     AudioInputStream currentAudio = null;
     AudioFileFormat fileFormat = null;
     String fileList = "";
     Mixer mixer = AudioSystem.getMixer( AudioSystem.getMixerInfo()[0]);
     File dir = new File ("/home/srm/folders/ias/TTS/project/voice1/diphones");
     public FileConcatAudioPlayer ( String dirName )
     {
       dir = new File (dirName);
     }
     

   
   /**
    * @roseuid 3AFF70CE02BA
    */
   protected void prepareSourceDatatLine() 
   {
     try
      {
        StringTokenizer st = new StringTokenizer (fileList,";");
        File file = new File ( dir, st.nextToken() + ".wav" );
        currentAudio =  AudioSystem.getAudioInputStream(file);
        fileFormat =  AudioSystem.getAudioFileFormat(file);
        AudioFormat audioFormat =  currentAudio.getFormat();
        DataLine.Info  dlInfo = new DataLine.Info(SourceDataLine.class,audioFormat,((int) currentAudio.getFrameLength() *  audioFormat.getFrameSize()) );
        if (!mixer.isLineSupported(dlInfo))
        {
          // Handle the error.
        }
//      SDLine = (SourceDataLine) mixer.getLine(dlInfo);
        SDLine = (SourceDataLine) AudioSystem.getLine(dlInfo);
        SDLine.open(audioFormat);
      }
      catch (LineUnavailableException e)
      {
        e.printStackTrace();
      }
      catch (UnsupportedAudioFileException e)
      {
         e.printStackTrace();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }    
   }
   
   /**
    * @roseuid 3AFF70CE02C4
    */
   public void startPlaying() 
   {
     prepareSourceDatatLine ();
     SDLine.start();
     boolean stopped = false; //put it somewhere else
     StringTokenizer st = new StringTokenizer (fileList,";") ;

     for( int i=0;  st.hasMoreTokens() && !stopped ; i++) // put yor condi
     {
       try
       {
        File file = new File ( dir , st.nextToken()+ ".wav" );
        System.out.println (file.getName());
        currentAudio =  AudioSystem.getAudioInputStream(file);
        System.out.println (currentAudio.getFormat());
        byte[] fileData = new byte [((int) currentAudio.getFrameLength() *  currentAudio.getFormat().getFrameSize())];
        System.out.println(fileData.length);
        int numBytesRead =  currentAudio.read(fileData,0,fileData.length);// dbtful
        System.out.println(numBytesRead);
        SDLine.write(fileData, 0, numBytesRead);
       }
       catch (UnsupportedAudioFileException e)
       {
         e.printStackTrace();
       }
       catch (IOException e)
       {
         e.printStackTrace();
       }

     }
     SDLine.drain();    
   }
   
   /**
    * @roseuid 3AFF70CE02D8
    */
   public void writeFile() 
   {
    // create concatenated file here
    try
      {
        AudioFormat audioFormat = currentAudio.getFormat();
//        AudioFormat outDataFormat = new AudioFormat((float) 8000.0,(int) 8,(int)2, false, false);

        DataLine.Info  dlInfo = new DataLine.Info(TargetDataLine.class,audioFormat);
        if (!mixer.isLineSupported(dlInfo))
        {
          System.out.println(" Line not supported ");
          Line.Info[] linfo =  mixer.getTargetLineInfo();
          for ( int j=0;j<linfo.length;j++)
            {
             System.out.println( j + "  " + linfo[j]);
            }
        }

        TDLine = (TargetDataLine) mixer.getLine(dlInfo);
        TDLine.open(audioFormat);
        AudioInputStream out = new  AudioInputStream (TDLine);

        AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;//fileFormat.getType();
        File fileOut = new File(dir,fileList+"SamTemp.wav");

        if (AudioSystem.isFileTypeSupported(fileType,out))
        {
          AudioSystem.write(out, fileType, fileOut);
        }
      }
      catch (LineUnavailableException e)
      {
        e.printStackTrace();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }    
   }
   
   /**
    * @roseuid 3AFF70CE02EC
    */
   public void stopedPlaying() 
   {
     SDLine.stop();
     SDLine.close();
     SDLine = null;    
   }
   
   /**
    * @param fl
    * @roseuid 3B06A64A0002
    */
   public void loadFileList(String fl) 
   {
      fileList = fl;    
   }
}
