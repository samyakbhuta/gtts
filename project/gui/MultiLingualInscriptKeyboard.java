//Source file: C:\\project\\gui\\MultiLingualInscriptKeyboard.java

package project.gui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class provides the functionality to input Gujarati Unicode text into text
 * components.
 * Courtesy : RCILTG
 */
public class MultiLingualInscriptKeyboard implements KeyListener
{
   public static int ENGLISH = 0;
   public static int HINDI = 1;
   public static int BENGALI = 2;
   public static int GURMUKHI = 3;
   public static int GUJARATI = 4;
   public static int ORIYA = 5;
   public static int TAMIL = 6;
   public static int TELUGU = 7;
   public static int KANNADA = 8;
   public static int MALAYALAM = 9;
   int currentLanguage;
   String keyMaps[] =
   	{"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()-=_+[];',./{}|:\"<>?\\",
	"\u0966\u0967\u0968\u0969\u096a\u096b\u096c\u096d\u096e\u096f\u0913\u0000\u0923\u0905\u0906\u0907\u0909\u092b\u0918\u0000\u0916\u0925\u0936\u0933\u0927\u091d\u0914\u0908\u090f\u0909\u0919\u0000\u0910\u0901\u092d\u0000\u094b\u0935\u092e\u094d\u093e\u093f\u0941\u0929\u0917\u0930\u0915\u0924\u0938\u0932\u0926\u091c\u094c\u0940\u0947\u0942\u0939\u0928\u0948\u0902\u092c\u0000\u090d\u0945#$%^&*()-\u0943\u0903\u0960\u0921]\u0919\u091f,.\u092f\u0922\u091e\u0911\u091b\u0920\u0937>?\u0949",
	"\u09e6\u09e7\u09e8\u09e9\u09ea\u09eb\u09ec\u09ed\u09ee\u09ef\u0993\u0000\u09a3\u0985\u0986\u0987\u0989\u09ab\u0998\u0000\u0996\u09a5\u09b6\u09b3\u09a7\u099d\u0994\u0988\u098f\u098a\u0999\u0000\u0990\u0981\u09ad\u0000\u09cb\u09b5\u09ae\u09cd\u09be\u09bf\u09c1\u09aa\u0997\u09b0\u0995\u09a4\u09b8\u09b2\u09a6\u099c\u09cc\u09c0\u09c7\u09c2\u09b9\u09a8\u09c8\u0982\u09ac\u0000\u098d\u09c5#$%^&*()-\u09c3\u0983\u09e0\u09a1]\u099a\u099f,.\u09af\u09a2\u099e|\u099b\u09a0\u09b7>?\\",
	"\u0a66\u0a67\u0a68\u0a69\u0a6a\u0a6b\u0a6c\u0a6d\u0a6e\u0a6f\u0a13\u0000\u0a23\u0a05\u0a06\u0a07\u0a09\u0a2b\u0a18\u0000\u0a16\u0a25\u0a36\u0a33\u0a27\u0a1d\u0a14\u0a08\u0a0f\u0a09\u0a19\u0000\u0a10\u0a01\u0a2d\u0000\u0a4b\u0a35\u0a2e\u0a4d\u0a3e\u0a3f\u0a41\u0a29\u0a17\u0a30\u0a15\u0a24\u0a38\u0a32\u0a26\u0a1c\u0a4c\u0a40\u0a47\u0a42\u0a39\u0a28\u0a48\u0a02\u0a2c\u0000\u0a0d\u0a45\u0a4d$%^&*()-\u0a43\u0a03\u0a60\u0a21]\u0a19\u0a1f,.\u0a2f\u0a22\u0a1e\u0a11\u0a1b\u0a20\u0a37>?\u0a49",
	"\u0ae6\u0ae7\u0ae8\u0ae9\u0aea\u0aeb\u0aec\u0aed\u0aee\u0aef\u0a93\u0000\u0aa3\u0a85\u0a86\u0a87\u0a89\u0aab\u0a98\u0000\u0a96\u0aa5\u0ab6\u0ab3\u0aa7\u0a9d\u0a94\u0a88\u0a8f\u0a8a\u0a99\u0000\u0a90\u0a81\u0aad\u0000\u0acb\u0ab5\u0aae\u0acd\u0abe\u0abf\u0ac1\u0aaa\u0a97\u0ab0\u0a95\u0aa4\u0ab8\u0ab2\u0aa6\u0a9c\u0acc\u0ac0\u0ac7\u0ac2\u0ab9\u0aa8\u0ac8\u0a82\u0aac\u0000\u0a8d\u0ac5#$%^&*()-\u0ac3\u0a83\u0ae0\u0aa1]\u0a9a\u0a9f,.\u0aaf\u0aa2\u0a9e\u0a91\u0a9b\u0aa0\u0ab7>?\u0ac9",
	"\u0b66\u0b67\u0b68\u0b69\u0b6a\u0b6b\u0b6c\u0b6d\u0b6e\u0b6f\u0b13\u0000\u0b23\u0b05\u0b06\u0b07\u0b09\u0b2b\u0b18\u0000\u0b16\u0b25\u0b36\u0b33\u0b27\u0b1d\u0b14\u0b08\u0b0f\u0b09\u0b19\u0000\u0b10\u0b01\u0b2d\u0000\u0b4b\u0b35\u0b2e\u0b4d\u0b3e\u0b3f\u0b41\u0b29\u0b17\u0b30\u0b15\u0b24\u0b38\u0b32\u0b26\u0b1c\u0b4c\u0b40\u0b47\u0b42\u0b39\u0b28\u0b48\u0b02\u0b2c\u0000\u0b0d\u0b45\u0b4d$%^&*()-\u0b43\u0b03\u0b60\u0b21]\u0b19\u0b1f,.\u0b2f\u0b22\u0b1e\u0b11\u0b1b\u0b20\u0b37>?\u0b49",
	"\u0be6\u0be7\u0be8\u0be9\u0bea\u0beb\u0bec\u0bed\u0bee\u0bef\u0b93\u0000\u0ba3\u0b85\u0b86\u0b87\u0b89\u0bab\u0b98\u0000\u0b96\u0ba5\u0bb6\u0bb3\u0ba7\u0b9d\u0b94\u0b88\u0b8f\u0b8a\u0b99\u0000\u0b90\u0b81\u0bad\u0000\u0bcb\u0bb5\u0bae\u0bcd\u0bbe\u0bbf\u0bc1\u0baa\u0b97\u0bb0\u0b95\u0ba4\u0bb8\u0bb2\u0ba6\u0b9c\u0bcc\u0bc0\u0bc7\u0bc2\u0bb9\u0ba8\u0bc8\u0b82\u0bac\u0000\u0b8d\u0bc5\u0bcd$%^&*()-\u0bc3\u0b83\u0be0\u0ba1]\u0b9a\u0b9f,.\u0baf\u0ba2\u0b9e\u0b91\u0b9b\u0ba0\u0bb7>?\u0bc9",
	"\u0c66\u0c67\u0c68\u0c69\u0c6a\u0c6b\u0c6c\u0c6d\u0c6e\u0c6f\u0c13\u0000\u0c23\u0c05\u0c06\u0c07\u0c09\u0c2b\u0c18\u0000\u0c16\u0c25\u0c36\u0c33\u0c27\u0c1d\u0c14\u0c08\u0c0f\u0c09\u0c19\u0000\u0c10\u0c01\u0c2d\u0000\u0c4b\u0c35\u0c2e\u0c4d\u0c3e\u0c3f\u0c41\u0c29\u0c17\u0c30\u0c15\u0c24\u0c38\u0c32\u0c26\u0c1c\u0c4c\u0c40\u0c47\u0c42\u0c39\u0c28\u0c48\u0c02\u0c2c\u0000\u0c0d\u0c45\u0c4d$%^&*()-\u0c43\u0c03\u0c60\u0c21]\u0c19\u0c1f,.\u0c2f\u0c22\u0c1e\u0c11\u0c1b\u0c20\u0c37>?\u0c49",
	"\u0ce6\u0ce7\u0ce8\u0ce9\u0cea\u0ceb\u0cec\u0ced\u0cee\u0cef\u0c93\u0000\u0ca3\u0c85\u0c86\u0c87\u0c89\u0cab\u0c98\u0000\u0c96\u0ca5\u0cb6\u0cb3\u0ca7\u0c9d\u0c94\u0c88\u0c8f\u0c8a\u0c99\u0000\u0c90\u0c81\u0cad\u0000\u0ccb\u0cb5\u0cae\u0ccd\u0cbe\u0cbf\u0cc1\u0caa\u0c97\u0cb0\u0c95\u0ca4\u0cb8\u0cb2\u0ca6\u0c9c\u0ccc\u0cc0\u0cc7\u0cc2\u0cb9\u0ca8\u0cc8\u0c82\u0cac\u0000\u0c8d\u0cc5\u0ccd$%^&*()-\u0cc3\u0c83\u0ce0\u0ca1]\u0c9a\u0c9f,.\u0caf\u0ca2\u0c9e\u0c91\u0c9b\u0ca0\u0cb7>?\u0cc9",
	"\u0d66\u0d67\u0d68\u0d69\u0d6a\u0d6b\u0d6c\u0d6d\u0d6e\u0d6f\u0d13\u0000\u0d23\u0d05\u0d06\u0d07\u0d09\u0d2b\u0d18\u0000\u0d16\u0d25\u0d36\u0d33\u0d27\u0d1d\u0d14\u0d08\u0d0f\u0d09\u0d19\u0000\u0d10\u0d01\u0d2d\u0000\u0d4b\u0d35\u0d2e\u0d4d\u0d3e\u0d3f\u0d41\u0d29\u0d17\u0d30\u0d15\u0d24\u0d38\u0d32\u0d26\u0d1c\u0d4c\u0d40\u0d47\u0d42\u0d39\u0d28\u0d48\u0d02\u0d2c\u0000\u0d0d\u0d45\u0d4d$%^&*()-\u0d43\u0d03\u0d60\u0d21]\u0d19\u0d1f,.\u0d2f\u0d22\u0d1e\u0d11\u0d1b\u0d20\u0d37>?\u0d49",
	};

   /**
    * @param lang
    * @roseuid 3B068BFC02A8
    */
   public MultiLingualInscriptKeyboard(int lang)
   {
	setLanguage(lang);    
   }
   
   /**
    * @param lang
    * @roseuid 3B068BFC02BC
    */
   public void setLanguage(int lang) 
   {
		if (lang>=keyMaps.length) {
			throw new RuntimeException("Unsupported Language");
		}
		currentLanguage=lang;    
   }
   
   /**
    * @param ke
    * @roseuid 3B068BFC02E4
    */
   public void keyReleased(KeyEvent ke) 
   {
    
   }
   
   /**
    * @param ke
    * @roseuid 3B068BFC02F8
    */
   public void keyTyped(KeyEvent ke) 
   {
		char inpChar = ke.getKeyChar();
		int inpCharIndex = keyMaps[0].indexOf(inpChar);
		if (inpCharIndex==-1)
		{
			return;
		}
		if (inpCharIndex+1>keyMaps[currentLanguage].length())
		{
			return;
		}

		String conjunctValue = "";

		if (inpChar == '#')
		{
			if ( currentLanguage == GUJARATI )
				conjunctValue = "\u0acd\u0ab0";
			else if ( currentLanguage == HINDI )
				conjunctValue = "\u094d\u0930";
			else if ( currentLanguage == BENGALI )
				conjunctValue = "\u09cd\u09b0";
			else if ( currentLanguage == ENGLISH )
				return;
			ke.setKeyChar('\u0000');
			JTextField tempTextField;
			JTextPane tempTextPane;
			if ( ke.getSource() instanceof JTextField ) {
				tempTextField = (JTextField)ke.getSource();
				tempTextField.setText(tempTextField.getText()+conjunctValue);
			}
			else if ( ke.getSource() instanceof JTextPane ) {
				tempTextPane = (JTextPane)ke.getSource();
				tempTextPane.setText(tempTextPane.getText()+conjunctValue);
			}
		}
		else if (inpChar == '$')
		{
			if ( currentLanguage == GUJARATI )
				conjunctValue = "\u0ab0\u0acd";
			else if ( currentLanguage == HINDI )
				conjunctValue = "\u0930\u094d";
			else if ( currentLanguage == BENGALI )
				conjunctValue = "\u09b0\u09cd";
			else if ( currentLanguage == ENGLISH )
				return;
			ke.setKeyChar('\u0000');
			JTextField tempTextField;
			JTextPane tempTextPane;
			if ( ke.getSource() instanceof JTextField ) {
				tempTextField = (JTextField)ke.getSource();
				tempTextField.setText(tempTextField.getText()+conjunctValue);
			}
			else if ( ke.getSource() instanceof JTextPane ) {
				tempTextPane = (JTextPane)ke.getSource();
				tempTextPane.setText(tempTextPane.getText()+conjunctValue);
			}
		}
		else if (inpChar == '%')
		{

			if ( currentLanguage == GUJARATI )
				conjunctValue = "\u0a9c\u0acd\u0a9e";
			else if ( currentLanguage == HINDI )
				conjunctValue = "\u091c\u094d\u091e";
			else if ( currentLanguage == BENGALI )
				conjunctValue = "\u099c\u09cd\u099e";
			else if ( currentLanguage == ENGLISH )
				return;
			ke.setKeyChar('\u0000');
			JTextField tempTextField;
			JTextPane tempTextPane;
			if ( ke.getSource() instanceof JTextField ) {
				tempTextField = (JTextField)ke.getSource();
				tempTextField.setText(tempTextField.getText()+conjunctValue);
			}
			else if ( ke.getSource() instanceof JTextPane ) {
				tempTextPane = (JTextPane)ke.getSource();
				tempTextPane.setText(tempTextPane.getText()+conjunctValue);
			}
		}
		else if (inpChar == '^')
		{

			if ( currentLanguage == GUJARATI )
				conjunctValue = "\u0aa4\u0acd\u0ab0";
			else if ( currentLanguage == HINDI )
				conjunctValue = "\u0924\u094d\u0930";
			else if ( currentLanguage == BENGALI )
				conjunctValue = "\u09a4\u09cd\u09b0";
			else if ( currentLanguage == ENGLISH )
				return;
			ke.setKeyChar('\u0000');
			JTextField tempTextField;
			JTextPane tempTextPane;
			if ( ke.getSource() instanceof JTextField ) {
				tempTextField = (JTextField)ke.getSource();
				tempTextField.setText(tempTextField.getText()+conjunctValue);
			}
			else if ( ke.getSource() instanceof JTextPane ) {
				tempTextPane = (JTextPane)ke.getSource();
				tempTextPane.setText(tempTextPane.getText()+conjunctValue);
			}
		}
		else if (inpChar == '&')
		{

			if ( currentLanguage == GUJARATI )
				conjunctValue = "\u0a95\u0acd\u0ab7";
			else if ( currentLanguage == HINDI )
				conjunctValue = "\u0915\u094d\u0937";
			else if ( currentLanguage == BENGALI )
				conjunctValue = "\u0995\u09cd\u09b7";
			else if ( currentLanguage == ENGLISH )
				return;
			ke.setKeyChar('\u0000');
			JTextField tempTextField;
			JTextPane tempTextPane;
			if ( ke.getSource() instanceof JTextField ) {
				tempTextField = (JTextField)ke.getSource();
				tempTextField.setText(tempTextField.getText()+conjunctValue);
			}
			else if ( ke.getSource() instanceof JTextPane ) {
				tempTextPane = (JTextPane)ke.getSource();
				tempTextPane.setText(tempTextPane.getText()+conjunctValue);
			}
		}
		else if (inpChar == '*')
		{

			if ( currentLanguage == GUJARATI )
				conjunctValue = "\u0ab6\u0acd\u0ab0";
			else if ( currentLanguage == HINDI )
				conjunctValue = "\u0936\u094d\u0930";
			else if ( currentLanguage == BENGALI )
				conjunctValue = "\u09b6\u09cd\u09b0";
			else if ( currentLanguage == ENGLISH )
				return;
			ke.setKeyChar('\u0000');
			JTextField tempTextField;
			JTextPane tempTextPane;
			if ( ke.getSource() instanceof JTextField ) {
				tempTextField = (JTextField)ke.getSource();
				tempTextField.setText(tempTextField.getText()+conjunctValue);
			}
			else if ( ke.getSource() instanceof JTextPane ) {
				tempTextPane = (JTextPane)ke.getSource();
				tempTextPane.setText(tempTextPane.getText()+conjunctValue);
			}
		}
		else
			ke.setKeyChar(keyMaps[currentLanguage].charAt(inpCharIndex));    
   }
   
   /**
    * @param ke
    * @roseuid 3B06A6160210
    */
   public void keyPressed(KeyEvent ke) 
   {
    
   }
}
