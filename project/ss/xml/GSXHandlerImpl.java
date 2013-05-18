//Source file: C:\\project\\ss\\xml\\GSXHandlerImpl.java

package project.ss.xml;

import project.ss.exception.*;
import java.util.*;
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

/**
 * Implements the GSXHandler interface and provides 
 * various methods for validation and data extraction
 * desribed in the GSXHandler interface
 */
public class GSXHandlerImpl extends HandlerBase implements GSXHandler 
{
   String IPAAnswer = "";
   String GUProAnswer = "";
   String GURawAnswer = "";
   boolean inData = false;
   boolean isIPA = false;
   boolean isGU = false;
   boolean isRaw = false;
   boolean isProcessed = false;
   
   /**
    * Provides implementation of the method desribed in GSXHandler
    * 
    * @param GSXFile
    * @return boolean
    * @throws project.ss.exception.ImproperGSXFile
    * @roseuid 3AFF748D039F
    */
   public boolean isValid(File GSXFile) throws ImproperGSXFile 
   {
      if (false)
      {
        throw new ImproperGSXFile("Not a valid GSX file:Validation Error");
      }
      return true ;    
   }
   
   /**
    * @throws org.xml.sax.SAXException
    * @roseuid 3AFF748E0007
    */
   public void startDocument() throws SAXException 
   {
         System.out.println("PARSING begins...");    
   }
   
   /**
    * @throws org.xml.sax.SAXException
    * @roseuid 3AFF748E006C
    */
   public void endDocument() throws SAXException 
   {
         System.out.println("...PARSING ends");    
   }
   
   /**
    * @param buf[]
    * @param offset
    * @param len
    * @throws org.xml.sax.SAXException
    * @roseuid 3AFF748E01AC
    */
   public void characters(char buf[], int offset, int len) throws SAXException 
   {

        if (  inData && isIPA && isProcessed  )
          {
            IPAAnswer += new String(buf, offset, len);
           // System.out.println( "Hay ");
          }
        if (  inData && isGU && isProcessed   )
          {
            GUProAnswer += new String(buf, offset, len);
          }
        if (  inData && isGU && isRaw   )
          {
            GURawAnswer += new String(buf, offset, len);
          }

        System.out.println( new String(buf, offset, len));    
   }
   
   /**
    * Provides implementation of the method desribed in GSXHandler
    * 
    * @param GSXFile
    * @return java.lang.String
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @roseuid 3B06A64402DF
    */
   public String getIPAString(File GSXFile) throws ImproperGSXFile, IOException 
   {
        try
         {
            isValid(GSXFile);
            IPAAnswer="";
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(false); // true
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse( GSXFile , this );
         }
        catch (  ImproperGSXFile e)
            {
             throw e;
            }
        catch (ParserConfigurationException e)
            {
             throw new ImproperGSXFile("Not a valid GSX file : ParserConfiguration");
            }
        catch (SAXException e)
            {
             throw new ImproperGSXFile("Not a valid GSX file : SAXException");
            }
        catch (IOException e)
            {
             throw e;
            }
       return IPAAnswer;    
   }
   
   /**
    * Provides implementation of the method desribed in GSXHandler
    * 
    * @param GSXFile
    * @return java.lang.String
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @roseuid 3B06A64403BB
    */
   public String getGURawString(File GSXFile) throws ImproperGSXFile, IOException 
   {
        try
         {
            isValid(GSXFile);
            GURawAnswer="";
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(false); // true
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse( GSXFile , this );
         }
        catch ( ImproperGSXFile e)
            {
             throw e;
            }
        catch (ParserConfigurationException e)
            {
             throw new ImproperGSXFile("Not a valid GSX file : ParserConfiguration");
            }
        catch (SAXException e)
            {
             throw new ImproperGSXFile("Not a valid GSX file : SAXException");
            }
        catch (IOException e)
            {
             throw e;
            }
        return GURawAnswer;    
   }
   
   /**
    * Provides implementation of the method desribed in GSXHandler
    * 
    * @param GSXFile
    * @return java.lang.String
    * @throws project.ss.exception.ImproperGSXFile
    * @throws java.io.IOException
    * @roseuid 3B06A64500B9
    */
   public String getGUProString(File GSXFile) throws ImproperGSXFile, IOException 
   {
        try
         {
            isValid(GSXFile);
            GUProAnswer="";
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(false); // true
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse( GSXFile , this );
         }
        catch ( ImproperGSXFile e)
            {
             throw e;
            }
        catch (ParserConfigurationException e)
            {
             throw new ImproperGSXFile("Not a valid GSX file : ParserConfiguration");
            }
        catch (SAXException e)
            {
             throw new ImproperGSXFile("Not a valid GSX file : SAXException");
            }
        catch (IOException e)
            {
             throw e;
            }
            
        return GUProAnswer;    
   }
   
   /**
    * @param elementName
    * @param attrs
    * @throws org.xml.sax.SAXException
    * @roseuid 3B06A645025E
    */
   public void startElement(String elementName, AttributeList attrs) throws SAXException 
   {
        if ( elementName.equals("DATA"))
        {
          inData=true;
          if ( attrs.getValue("LANG").equals("IPA") )
          {
            isIPA=true;
            isGU=false;
          }
          if ( attrs.getValue("LANG").equals("GU") )
          {
            isIPA=false;
            isGU=true;
          }
          if ( attrs.getValue("TYPE").equals("RAW") )
          {
            isRaw=true;
            isProcessed=false;
          }
          if ( attrs.getValue("TYPE").equals("PROCESSED") )
          {
            isRaw=false;
            isProcessed=true;
          }
        }
        System.out.println ( "<" + elementName );
        System.out.println ( " LANG=" + attrs.getValue("LANG"));
        System.out.println ( " TYPE=" +attrs.getValue("TYPE"));
        System.out.println ( ">");    
   }
   
   /**
    * @param elementName
    * @throws org.xml.sax.SAXException
    * @roseuid 3B06A6450326
    */
   public void endElement(String elementName) throws SAXException 
   {
        if ( elementName.equals("DATA")  )
          {
           inData=false;
           isIPA=false;
           isGU=false;
           isRaw=false;
           isProcessed=false;
          }
        System.out.println ( "</" + elementName +">" );    
   }
   
   /**
    * @param target
    * @param data
    * @throws org.xml.sax.SAXException
    * @roseuid 3B06A64600D9
    */
   public void processingInstruction(String target, String data) throws SAXException 
   {
         System.out.println( "Processing instruction encountered.Doing Nothing ");    
   }
}
