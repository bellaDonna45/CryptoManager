package cryptopackage;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class CryptoManager2TestPublic {

	CryptoManager2 cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
		cryptoManager = new CryptoManager2();
	}

	@AfterEach
	public void tearDown() throws Exception {
		cryptoManager = null;
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager2.isStringInBounds("JAVA"));
		assertTrue(CryptoManager2.isStringInBounds("\"JAVA IS FUN\""));
		assertFalse(CryptoManager2.isStringInBounds("java"));
		assertFalse(CryptoManager2.isStringInBounds("{JAVA"));
		assertFalse(CryptoManager2.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager2.caesarEncryption("bye", 3));
		assertEquals("DEF", CryptoManager2.caesarEncryption("ABC", 3));
		assertEquals("!\"#", CryptoManager2.caesarEncryption("ABC", 96));
		assertEquals("1.558", CryptoManager2.caesarEncryption("HELLO", 105));
		assertEquals("UFTUJOH", CryptoManager2.caesarEncryption("TESTING", 1));
		assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager2.caesarEncryption("THIS IS ANOTHER TEST", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("TESTING", CryptoManager2.caesarDecryption("UFTUJOH", 1));
		assertEquals("TESTING ANOTHER STRING", CryptoManager2.caesarDecryption(";,:;05.G(56;/,9G:;905.", 999));
		assertEquals("HELLO WORLD", CryptoManager2.caesarDecryption("4188;LC;>80", 300));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager2.caesarDecryption("WKLV#LV#DQRWKHU#WHVW", 3));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("WN#\\N &", CryptoManager2.bellasoEncryption("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("UJ^^((HT^X[YYM\"", CryptoManager2.bellasoEncryption("MERRY CHRISTMAS", "HELLO"));
		assertEquals("WU\\VR9F#N!RF88U-'HED", CryptoManager2.bellasoEncryption("THIS IS ANOTHER TEST", "CMSC203"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTING", CryptoManager2.bellasoDecryption("WN#\\N &", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("MERRY CHRISTMAS", CryptoManager2.bellasoDecryption("UJ^^((HT^X[YYM\"", "HELLO"));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager2.bellasoDecryption("WU\\VR9F#N!RF88U-'HED", "CMSC203"));

	}

}
