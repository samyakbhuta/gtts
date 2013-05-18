//Source file: C:\\project\\ss\\engine\\Concatenater.java

package project.ss.engine;

import project.ss.exception.*;
import javax.sound.sampled.*;
import java.io.*;

/**
 * This interface provides an abstracion for concatenating audio
 * The concatenation information is specified as String in concatenateAndFeed()
 * method .This method then passes the data to the Player specified earlier by
 * prepareSourceDataLine() for playback of the audio.
 */
interface Concatenater 
{
   
   /**
    *  This method sets the voice files to be used to concatnete the audio
    * 
    * @param voiceFile
    * @param voiceInfoFile
    * @throws javax.sound.sampled.UnsupportedAudioFileException
    * @throws java.io.IOException
    * @roseuid 3AFF70CD031E
    */
   public void setVoice(File voiceFile, File voiceInfoFile) throws UnsupportedAudioFileException, IOException;
   
   /**
    * The concatenater sets the SourceDataLine to be used with the Player
    * 
    * @param player
    * @throws javax.sound.sampled.LineUnavailableException
    * @roseuid 3B06A65F0143
    */
   public void prepareSourceDataLine(Player player) throws LineUnavailableException;
   
   /**
    * Concatenates the  audio dat from the partnemeString provided and feeds it to
    * the SourceDataLine in use.
    * 
    * @param partnemeString
    * @throws project.ss.exception.ImproperDataFeed
    * @roseuid 3B06A65F01ED
    */
   public void concatenateAndFeed(String partnemeString) throws ImproperDataFeed;
   /**
    *  U may want to extend File to build your new type VoiceFile and embedd
    *  both voiceFile and voiceInfoFile
    */
}
