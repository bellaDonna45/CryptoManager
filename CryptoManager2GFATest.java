package cryptopackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class CryptoManager2GFATest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager2.isStringInBounds("THIS TEST SHOULD SUCCEED"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("IFMMP!XPSME", CryptoManager2.caesarEncryption("HELLO WORLD", 1));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("HELLO WORLD", CryptoManager2.caesarDecryption("IFMMP!XPSME", 1));
	}

}
