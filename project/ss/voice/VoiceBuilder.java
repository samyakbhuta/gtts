//Source file: C:\\project\\ss\\voice\\VoiceBuilder.java

package project.ss.voice;

//import project.ss.engine.*;
import project.ss.misc.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import javax.sound.sampled.*;

/**
 * This class is a utility class. The class provides only one method which can 
 * build the Voice File and Voice Info file.
 */
public class VoiceBuilder 
{
   
   /**
    * This method concatenates the different audio file into a single file known as 
    * Voice File. It also provides the position of the audio and audio length into 
    * Voice Info File. The name of the Voice File and Voice Info File are given as 
    * second argument in method.
    * The first argument provides directory where all the sound files are
    * 
    * @param directory
    * @param filename
    * @roseuid 3B06A6670203
    */
   public static void buildVoice(File directory, String filename)    {
    try {
        String voiceInfo="";
        File dir = directory;
        File outputVoiceFile = new File ( dir , filename + ".wav" );
        File voiceInfoFile = new File ( dir , filename + ".vf" );
        Pattern p = Pattern.compile("\\."); //filename.ext seperator
        String label[]=null;
        AudioInputStream OutputAIStream=null;
        AudioInputStream audioInputStream=null;
        AudioFormat audioFormat = null;
        File  files [] = dir.listFiles();
        Vector vector = new Vector( files.length);
        int totalSampleLength=0;
        for ( int i=0;i<files.length;i++)
         {
            audioInputStream =  AudioSystem.getAudioInputStream(files[i]);
            vector.add(audioInputStream);
            label= p.split( files[i].getName());
            voiceInfo+="|"+label[0]+"|"+
                       ";"+totalSampleLength+";"+
                       audioInputStream.getFrameLength()+
                       ";\n";
            totalSampleLength+=audioInputStream.getFrameLength();
            System.out.println (files[i].getName());
            System.out.println ("File format " + audioInputStream.getFormat());
            System.out.println(" File length (frame) "+audioInputStream.getFrameLength());
            System.out.println(" Total length (frame) "+totalSampleLength);

         }
        SequenceInputStream sis = new  SequenceInputStream (vector.elements());
        audioFormat =  AudioSystem.getAudioInputStream(files[0]).getFormat();
        OutputAIStream = new AudioInputStream(sis, audioFormat,totalSampleLength);
        AudioSystem.write(OutputAIStream,AudioFileFormat.Type.WAVE,outputVoiceFile);
        System.out.println(voiceInfo);
        FileLoad.writeFile(voiceInfoFile ,voiceInfo,"UTF-16BE");
    
   }
   catch(UnsupportedAudioFileException e)
    {
      e.printStackTrace();
    }
   catch(IOException e)
    {
      e.printStackTrace();
    }    
   }
}
/**
  void VoiceBuilder.main(java.lang.String[]){
  buildVoice( new File ("C:/project/voice/parts"),"partVoice");
  }
  
 */
