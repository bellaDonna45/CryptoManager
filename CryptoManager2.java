package cryptopackage;

public class CryptoManager2 {
	private static final char LOWER_RANGE = 'A';
	private static final char UPPER_RANGE = 'Z';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		
		boolean result = true;
		
		for (int i = 0; i < plainText.length(); i++) {
      
			char car = plainText.charAt(i);
            if (car < LOWER_RANGE || car > UPPER_RANGE) {
                result = false;
            }
        }
        return result;
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }

		String encrypt2 = "";

        
        for (int i = 0; i < plainText.length(); i++) {
            char cart = plainText.charAt(i);

            
            if (cart >= LOWER_RANGE && cart <= UPPER_RANGE) {
                
                cart = (char) ((cart - LOWER_RANGE + key) % 26 + LOWER_RANGE);
            }
            
            else if (cart >= 'a' && cart <= 'z') {
                cart = (char) ((cart - 'a' + key) % 26 + 'a');
            }
            encrypt2 += cart;
        }

        return encrypt2;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		String encrypt = "";
        int legth = bellasoStr.length();

        for (int i = 0; i < plainText.length(); i++) {
            char charp = plainText.charAt(i);
            char char2 = bellasoStr.charAt(i % legth);
            char char3 = (char) (charp + char2);

            if (char3 > UPPER_RANGE) {
                char3 = (char) (char3 - (UPPER_RANGE - LOWER_RANGE + 1));
            }
            encrypt += char3; 
        }
        return encrypt;
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		String decrypt = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            char cha = encryptedText.charAt(i);
            char chars = (char) (cha - key);
            if (chars < LOWER_RANGE) {
                chars = (char) (chars + (UPPER_RANGE - LOWER_RANGE + 1));
            }
            decrypt += chars;  
        }
        return decrypt;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String decrypt = "";
        int length = bellasoStr.length();

        for (int i = 0; i < encryptedText.length(); i++) {
            char chacha = encryptedText.charAt(i);
            char cha2 = bellasoStr.charAt(i % length);
            char chart = (char) (chacha - cha2);

            if (chart < LOWER_RANGE) {
                chart = (char) (chart + (UPPER_RANGE - LOWER_RANGE + 1));
            }
            decrypt += chart;  
        }
        return decrypt;
	}

}
