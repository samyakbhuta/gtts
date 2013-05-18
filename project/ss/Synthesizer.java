//Source file: C:\\project\\ss\\Synthesizer.java

package project.ss;

import project.ss.engine.*;
import project.ss.exception.*;
import java.io.*;
import javax.sound.sampled.*;

/**
 * This interface is at the heart of whole package project.ssThe interface 
 * provides abstraction for other applications to  speak out the given text.
 * The interface supports various overloaded version of speak()
 * method to do the job.
 * Either String or GSX Document as File object can be supplied
 * to the speak() method.The class also provides set of other
 *  methods to set configurions of the Synthesizer ,such as Voice 
 * files etc.
 * Developer would like to provide implemention of this class for
 * perticular language.For Gujarati SynthesizerImpl class has been
 * developed
 */

public interface Synthesizer 
{
   
   /**
    * Synthesize the content provided in GSX file
    * 
    * @param GSXFile
    * @throws project.ss.exception.UnsupportedIPA
    * @throws project.ss.exception.UnsupportedGU
    * @throws project.ss.exception.ImproperIPASequence
    * @throws project.ss.exception.ImproperDataFeed
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @roseuid 3AFF72100317
    */
   public void speak(File GSXFile) throws UnsupportedIPA, UnsupportedGU, ImproperIPASequence, ImproperDataFeed, ImproperGSXFile, IOException;
   
   /**
    * Starts playing back the  audio output
    * @roseuid 3AFF72100367
    */
   public void play();
   
   /**
    * Stop playing back the  audio output
    * @roseuid 3AFF7210037B
    */
   public void stop();
   
   /**
    * Set the voice files to be used.
    * 
    * @param voiceFile
    * @param voiceInfoFile
    * @throws javax.sound.sampled.UnsupportedAudioFileException
    * @throws java.io.IOException
    * @roseuid 3AFF72100385
    */
   public void setVoice(File voiceFile, File voiceInfoFile) throws UnsupportedAudioFileException, IOException;
   
   /**
    * Set the file which will be used to dump the audio data
    * 
    * @param dmpFile
    * @roseuid 3AFF721003A3
    */
   public void setDumpFile(File dmpFile);
   
   /**
    * Speak out the data provided in the specified GSX file,also provided 
    * is type of data to be spoken out
    * 
    * @param GSXFile
    * @param lang
    * @param type
    * @throws project.ss.exception.UnsupportedIPA
    * @throws project.ss.exception.UnsupportedGU
    * @throws project.ss.exception.ImproperIPASequence
    * @throws project.ss.exception.ImproperDataFeed
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @roseuid 3B06A6180173
    */
   public void speak(File GSXFile, String lang, String type) throws UnsupportedIPA, UnsupportedGU, ImproperIPASequence, ImproperDataFeed, ImproperGSXFile, IOException;
   
   /**
    * Speak out the specified data ,also provided is a type of data
    * 
    * @param data
    * @param lang
    * @param type
    * @throws project.ss.exception.UnsupportedIPA
    * @throws project.ss.exception.UnsupportedGU
    * @throws project.ss.exception.ImproperIPASequence
    * @throws project.ss.exception.ImproperDataFeed
    * @roseuid 3B06A618032B
    */
   public void speak(String data, String lang, String type) throws UnsupportedIPA, UnsupportedGU, ImproperIPASequence, ImproperDataFeed;
   
   /**
    * Returns the file used for dumping
    * 
    * @return java.io.File
    * @roseuid 3B06A61901B0
    */
   public File getDumpFile();
   public CoreEngine getCoreEngine();
}
