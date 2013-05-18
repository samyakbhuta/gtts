//Source file: C:\\project\\ss\\engine\\CoreEngine.java

package project.ss.engine;

import project.ss.exception.*;
import java.io.*;
import javax.sound.sampled.*;

/**
 * This interface provides abstraction for production of synthesized speech for 
 * given IPA sequence.
 * It provide two versions of speak ( ) method to do the task.
 * Besides it various method we provide which configures the behavior of 
 * CoreEngine.
 */
public interface CoreEngine 
{
   
   /**
    * Speaks out the IPA Sequence provided in GSX file.
    * 
    * @param GSXFile
    * @throws project.ss.exception.UnsupportedIPA
    * @throws project.ss.exception.ImproperIPASequence
    * @throws project.ss.exception.ImproperDataFeed
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @roseuid 3AFF70CE033C
    */
   public void speak(File GSXFile) throws UnsupportedIPA, ImproperIPASequence, ImproperDataFeed, ImproperGSXFile, IOException;
   
   /**
    * Set the voice files to be used.
    * 
    * @param voiceFile
    * @param voiceInfoFile
    * @throws javax.sound.sampled.UnsupportedAudioFileException
    * @throws java.io.IOException
    * @roseuid 3AFF70CE0364
    */
   public void setVoice(File voiceFile, File voiceInfoFile) throws UnsupportedAudioFileException, IOException;
   
   /**
    * Starts playing
    * @roseuid 3AFF70CE0378
    */
   public void play();
   
   /**
    * Stops playing audio
    * @roseuid 3AFF70CE038C
    */
   public void stop();
   
   /**
    * Sets the dump file 
    * @param dmpFile
    * @roseuid 3AFF70CE0396
    */
   public void setDumpFile(File dmpFile);
   
   /**
    * Speaks out the specified IPA sequence as String
    * 
    * @param IPAString
    * @throws project.ss.exception.UnsupportedIPA
    * @throws project.ss.exception.ImproperIPASequence
    * @throws project.ss.exception.ImproperDataFeed
    * @roseuid 3B06A6600144
    */
   public void speak(String IPAString) throws UnsupportedIPA, ImproperIPASequence, ImproperDataFeed;
   
   /**
    * Provides the implementation of the same method desribed in Player 
    * @return java.io.File
    * @roseuid 3B06A6600389
    */
   public File getDumpFile();
   
   /**
    * Sets the Player to be used
    * 
    * @param p
    * @roseuid 3B06A66003BB
    */
   public void setPlayer(Player p);
   
   /**
    * Returns  the  Player in uses
    * 
    * @return project.ss.engine.Player
    * @roseuid 3B06A6610019
    */
   public Player getPlayer();
   
   /**
    * Sets the new Concatenater to be used
    * 
    * @param con
    * @roseuid 3B06A6610041
    */
   public void setConcatenater(Concatenater con);
   
   /**
    * Returns  the  Concatenater  in uses
    * @return project.ss.engine.Concatenater
    * @roseuid 3B06A66100A5
    */
   public Concatenater getConcatenater();
}
