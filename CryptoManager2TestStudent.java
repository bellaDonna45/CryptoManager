package cryptopackage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

public class CryptoManager2TestStudent {



	

	    // Test for isStringInBounds method
	    @Test
	    public void testIsStringInBounds() {
	        // Test with string within bounds
	        String testString1 = "PLAY";
	        assertTrue(CryptoManager2.isStringInBounds(testString1));

	        // Test with string outside of bounds
	        String testString2 = "PLAY{"; // '{' is outside the UPPER_RANGE
	        assertFalse(CryptoManager2.isStringInBounds(testString2));
	    }

	    // Test for caesarEncryption method
	    @Test
	    public void testCaesarEncryption() {
	        // Test with valid string and key
	        String plainText = "PLAY";
	        int key = 3;
	        String expectedEncryptedText = "SODB"; // Expected encrypted text with Caesar cipher and key 3
	        assertEquals(expectedEncryptedText, CryptoManager2.caesarEncryption(plainText, key));

	        // Test for string out of bounds
	        String plainTextOutOfBounds = "PLAY{"; // '{' is out of bounds
	        String expectedOutOfBoundsMessage = "The selected string is not in bounds, Try again.";
	        assertEquals(expectedOutOfBoundsMessage, CryptoManager2.caesarEncryption(plainTextOutOfBounds, key));
	    }

	    // Test for caesarDecryption method
	    @Test
	    public void testCaesarDecryption() {
	        // Test with valid string and key
	        String encryptedText = "SODB";
	        int key = 3;
	        String expectedDecryptedText = "PLAY"; // Expected original text with Caesar cipher and key 3
	        assertEquals(expectedDecryptedText, CryptoManager2.caesarDecryption(encryptedText, key));
	    }

	    // Test for bellasoEncryption method
	    @Test
	    public void testBellasoEncryption() {
	        // Test with valid string and bellasoStr
	        String plainText = "PLAY";
	        String bellasoStr = "KEY";
	        String expectedEncryptedText = "RCFC"; // Example encryption using Bellaso cipher
	        assertEquals(expectedEncryptedText, CryptoManager2.bellasoEncryption(plainText, bellasoStr));
	    }

	    // Test for bellasoDecryption method
	    @Test
	    public void testBellasoDecryption() {
	        // Test with valid string and bellasoStr
	        String encryptedText = "RCFC";
	        String bellasoStr = "KEY";
	        String expectedDecryptedText = "PLAY"; // Expected original text after decryption
	        assertEquals(expectedDecryptedText, CryptoManager2.bellasoDecryption(encryptedText, bellasoStr));
	    }
	
}


