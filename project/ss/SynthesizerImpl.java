//Source file: C:\\project\\ss\\SynthesizerImpl.java

package project.ss;

import java.io.*;
import project.ss.engine.*;
import project.ss.exception.*;
import project.ss.xml.*;
import project.ss.lang.gu.ipatrans.*;
import project.ss.lang.gu.prepro.*;
import javax.sound.sampled.*;

/**
 * This class provides the implementation of the Synthesizer class for Gujarati 
 * Unicode text as input. It acts as an umbrella class which holds instances of 
 * Preprocessor, IPACoverter and CoreEngine and supplies the data from one to 
 * another in order to provide complete Text-to-Speech capability.
 * Developer is required to override or extend the implementation of this class in 
 * order to change the functionality of the Synthesizer class partially.
 */
public class SynthesizerImpl implements Synthesizer 
{
   static CoreEngine engine = null;
   static PreProcessor prepro = null;
   
   /**
    * It is used to handle the GSX Files.
    */
   static GSXHandler gsxHandler = null;
   static ToIPATranscriptor toIPATranscriptor = null;
   
   static 
   {
   engine  =  new CoreEngineImpl();
   File dir = new File("./project/ss/lang/gu/prepro");
   File file = new File (dir,"GujLookUp.txt");
   prepro = new PreProcessorImpl(file,"UTF-16BE");
   gsxHandler =  new GSXHandlerImpl();
   toIPATranscriptor = new ToIPATranscriptorImpl();    
   }
   
   /**
    * Provides the functionality described in Synthesizer interface for Gujarati
    * 
    * @param GSXFile
    * @throws project.ss.exception.UnsupportedIPA
    * @throws project.ss.exception.UnsupportedGU
    * @throws project.ss.exception.ImproperIPASequence
    * @throws project.ss.exception.ImproperDataFeed
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @roseuid 3AFF721001F5
    */
   public void speak(File GSXFile) throws UnsupportedIPA, UnsupportedGU, ImproperIPASequence, ImproperDataFeed, ImproperGSXFile, IOException 
   {
   // speaks all data elemnts but starting with
   // all RAW then all PRO then all IPA
     speak(GSXFile,GSXUtility.GU,GSXUtility.RAW);
     speak(GSXFile,GSXUtility.GU,GSXUtility.PROCESSED);
     speak(GSXFile,GSXUtility.IPA,"");    
   }
   
   /**
    * Provides the functionality described in Synthesizer interface
    * @roseuid 3AFF72100245
    */
   public void play() 
   {
   	engine.play();    
   }
   
   /**
    * Provides the functionality described in Synthesizer interface
    * @roseuid 3AFF7210024F
    */
   public void stop() 
   {
   	engine.stop();    
   }
   
   /**
    * Provides the implementation of the same method desribed in Synthesizer
    * 
    * @param dmpFile
    * @roseuid 3AFF7210028B
    */
   public void setDumpFile(File dmpFile) 
   {
   engine.setDumpFile(dmpFile);    
   }
   
   /**
    * Provides the functionality described in Synthesizer interface
    * 
    * @param voiceFile
    * @param voiceInfoFile
    * @throws javax.sound.sampled.UnsupportedAudioFileException
    * @throws java.io.IOException
    * @roseuid 3AFF721002B3
    */
   public void setVoice(File voiceFile, File voiceInfoFile) throws UnsupportedAudioFileException, IOException 
   {
   try
    {
     engine.setVoice(voiceFile,voiceInfoFile );
    }
    catch (UnsupportedAudioFileException e)
    {
     throw e;
    }
    catch ( IOException  e)
    {
     throw e;    
    }    
   }
   
   /**
    * Provides the functionality described in Synthesizer interface for Gujarati
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
    * @roseuid 3B06A61A0284
    */
   public void speak(File GSXFile, String lang, String type) throws UnsupportedIPA, UnsupportedGU, ImproperIPASequence, ImproperDataFeed, ImproperGSXFile, IOException 
   {
  
    if ( lang.equals(GSXUtility.GU) && type.equals(GSXUtility.RAW) )
     {
         String rawGUString = gsxHandler.getGURawString ( GSXFile );
         speak ( rawGUString,GSXUtility.GU,GSXUtility.RAW);
     }
    if ( lang.equals(GSXUtility.GU) && type.equals(GSXUtility.PROCESSED) )
     {
        String processedGUString = gsxHandler.getGUProString ( GSXFile );
        speak ( processedGUString,GSXUtility.GU,GSXUtility.PROCESSED);
     }
    if ( lang.equals(GSXUtility.IPA) )
     {
        engine.speak(GSXFile);
     }    
   }
   
   /**
    * Provides the functionality described in Synthesizer interface for Gujarati
    * 
    * @param data
    * @param lang
    * @param type
    * @throws project.ss.exception.UnsupportedIPA
    * @throws project.ss.exception.UnsupportedGU
    * @throws project.ss.exception.ImproperIPASequence
    * @throws project.ss.exception.ImproperDataFeed
    * @roseuid 3B06A61B004B
    */
   public void speak(String data, String lang, String type) throws UnsupportedIPA, UnsupportedGU, ImproperIPASequence, ImproperDataFeed 
   {
    if ( lang.equals(GSXUtility.GU) && type.equals(GSXUtility.RAW) )
     {
        String processedGUString  = prepro.preProcess(data);//string returned from PreImpl. if s.f occurs.
        speak(processedGUString ,GSXUtility.GU,GSXUtility.PROCESSED);
     }
    if ( lang.equals(GSXUtility.GU) && type.equals(GSXUtility.PROCESSED) )
     {
        String ipaString = toIPATranscriptor.transcriptToIPA(data);
	try{
        	DiphoneString.getDiphone(ipaString);
	}
	catch(Throwable e){}
	//we dont want to change to IPA. From here we will get our final string to play.
        speak(ipaString,GSXUtility.IPA,GSXUtility.PROCESSED);
     }
    if ( lang.equals(GSXUtility.IPA))
     {
         
	//System.exit(0);
        
        //engine.speak(data);
     }    
   }
   
   /**
    * Provides the implementation of the same method desribed in Synthesizer
    * 
    * @return java.io.File
    * @roseuid 3B06A61B0203
    */
   public File getDumpFile() 
   {
   return   engine.getDumpFile();    
   }
   /**
    *   public void concatenateAndFeed (String partnemeString)// included for testing
    *   {
    *     engine.concatenateAndFeed(partnemeString);
    *   }
    */


  public CoreEngine getCoreEngine()
  {
   return engine;
  }

  public void setCoreEngine(project.ss.engine.CoreEngine ce)
  {
    engine=ce;
  }

}
