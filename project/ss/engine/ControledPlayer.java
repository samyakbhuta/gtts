//Source file: C:\\project\\ss\\engine\\ControledPlayer.java

package project.ss.engine;

import javax.sound.sampled.*;
import java.io.*;

/**
 * This interface adds output control to the basic interface Player.
 * It provided the gain (volume)  and pan (speaker balance) controlling.
 * It also provides the mute functionality
 * @author SamyakBhuta
 * @lingu
 * @info
 */
public interface ControledPlayer extends Player 
{
   
   /**
    * Sets the gain( volume ). 
    * One can increases or decreases the volume level 
    * through this method
    * @param gainInDb
    * @roseuid 3AFF70FA0303
    */
   public void setGain(float gainInDb);
   
   /**
    * Sets the pan( speaker balance ). 
    * One can increases or decreases the volume level 
    * through this method
    * @param pan
    * @roseuid 3AFF70FA030E
    */
   public void setPan(float pan);
   
   /**
    * Returns the current volume level
    * @return float
    * @roseuid 3AFF70FA0321
    */
   public float getGain();
   
   /**
    * Returns the current  pan value
    * @return float
    * @roseuid 3AFF70FA0335
    */
   public float getPan();
   
   /**
    * Mutes the playing audio
    * @roseuid 3B06B5C5026D
    */
   public void muteOn();
   
   /**
    * Revert thr muting ot the playing audio
    * @roseuid 3B06B5C5028C
    */
   public void muteOff();
}
