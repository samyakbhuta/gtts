//Source file: C:\\project\\ss\\engine\\ControledPlayerImpl.java

package project.ss.engine;

import javax.sound.sampled.*;
import java.io.*;

/**
 * This class provides the implementation of both the basic Player
 * interface and  more capable ControlledPlayer interface.
 */
public class ControledPlayerImpl implements ControledPlayer 
{
   
   /**
    * The Source Data Line which is responsible for playback
    */
   static SourceDataLine SDLine = null;
   
   /**
    * Audio Format of the audio data that is played 
    * by object ot this class
    */
   static AudioFormat audioFormat = null;
   
   /**
    * The File object representing the the dumpfile 
    * to be used to dump the audio
    */
   static File dumpFile = null;
   
   /**
    * Control which can provide pan level settings
    */
   static FloatControl panControl = null;
   
   /**
    * Control which can provide volume level settings
    */
   static FloatControl gainControl = null;

   /**
    * Control which can provide volume level settings
    */

   static BooleanControl muteControl = null;
   
   static 
   {
 try
  {
   audioFormat = new AudioFormat((float) 8000.0,(int) 16,(int)1, true, false);
   DataLine.Info  dlInfo = new DataLine.Info(SourceDataLine.class,audioFormat);
   SDLine = (SourceDataLine) AudioSystem.getLine(dlInfo);
   SDLine.open(audioFormat);
   gainControl = (FloatControl) SDLine.getControl(FloatControl.Type.MASTER_GAIN);
   System.out.println(" In ControledPlayerImpl");
   //panControl = (FloatControl) SDLine.getControl(FloatControl.Type.PAN);
   muteControl = (BooleanControl) SDLine.getControl(BooleanControl.Type.MUTE);
  }
  catch (LineUnavailableException e)
  {
   e.printStackTrace();
  }    
   }
   
   /**
    * Provides the implementation of the same method desribed in Player 
    * interface
    * @roseuid 3AFF70FC01B2
    */
   public void play() 
   {
   SDLine.start();
   System.out.println("playing .. ");    
   }
   
   /**
    * Provides the implementation of the same method desribed in Player 
    * interface
    * @roseuid 3AFF70FC01C6
    */
   public void stop() 
   {
   SDLine.stop();
   SDLine.flush();
   System.out.println("stopped and flushed ");    
   }
   
   /**
    * redundent method
    * @roseuid 3AFF70FC01D0
    */
   public void pause() 
   {
   SDLine.stop();    
   }
   
   /**
    * Provides the implementation of the same method described in ControledPlayer 
    * in ControlledPlayer interface
    * 
    * @param gainInDb
    * @roseuid 3AFF70FC01DA
    */
   public void setGain(float gainInDb) 
   {
  gainControl.setValue(gainInDb);    
   }
   
   /**
    * Provides the implementation of the same method described
    * in ControlledPlayer interface
    * 
    * @param pan
    * @roseuid 3AFF70FC01EE
    */
   public void setPan(float pan) 
   {
  //panControl.setValue(pan);    
   }
   
   /**
    * Provides the implementation of the same method described 
    * in ControlledPlayer interface
    * 
    * @return float
    * @roseuid 3AFF70FC0202
    */
   public float getGain() 
   {
   return  gainControl.getValue();    
   }
   
   /**
    * Provides the implementation of the same method described in ControledPlayer 
    * in ControlledPlayer interface
    * 
    * @return float
    * @roseuid 3AFF70FC020C
    */
   public float getPan() 
   {
   return  panControl.getValue();    
   }
   
   /**
    * Provides the implementation of the same method desribed in Player 
    * interface
    * 
    * @param srcDataLine
    * @roseuid 3AFF70FC0234
    */
   public void setSourceDataLine(SourceDataLine srcDataLine) 
   {
   SDLine = srcDataLine;
   gainControl = (FloatControl) SDLine.getControl(FloatControl.Type.MASTER_GAIN);
   //panControl = (FloatControl) SDLine.getControl(FloatControl.Type.PAN);
   muteControl = (BooleanControl) SDLine.getControl(BooleanControl.Type.MUTE);   
   }
   
   /**
    * Provides the implementation of the same method desribed in Player 
    * interface
    * 
    * @param dmpFile
    * @roseuid 3AFF70FC0248
    */
   public void setDumpFile(File dmpFile) 
   {
    dumpFile=dmpFile;    
   }
   
   /**
    * @roseuid 3AFF70FC0270
    */
   protected void finalized() 
   {
   SDLine.close();    
   }
   
   /**
    * Provides the implementation of the same method desribed in Player 
    * interface
    * 
    * @return javax.sound.sampled.SourceDataLine
    * @roseuid 3B06A64D0101
    */
   public SourceDataLine getSourceDataLine() 
   {
   return SDLine;    
   }
   
   /**
    * Provides the implementation of the same method desribed in Player 
    * interface
    * 
    * @return java.io.File
    * @roseuid 3B06A64D0183
    */
   public File getDumpFile() 
   {
   return dumpFile;    
   }
   
   /**
    * Provides the implementation of the same method described 
    * in ControlledPlayer interface
    * @lingu
    * @info
    * @roseuid 3B06B5D80094
    */
   public void muteOn() 
   {
     muteControl.setValue(true);
   }
   
   /**
    * Provides the implementation of the same method described 
    * in ControlledPlayer interface
    * @lingu
    * @info
    * @roseuid 3B06B5D800A8
    */
   public void muteOff() 
   {
     muteControl.setValue(false);    
   }
}
