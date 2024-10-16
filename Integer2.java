package cryptopackage;
import java.io.Serializable;


	

	

	public final class Integer2 extends Number implements Comparable<Integer2>, Serializable {
	    
	    private static final long serialVersionUID = 1L;
		// Constant for maximum and minimum values an int can hold
	    public static final int MIN_VALUE = 0x80000000;  // -2^31
	    public static final int MAX_VALUE = 0x7fffffff;  // 2^31 - 1
	    
	    // A cache for frequently used integers from -128 to 127
	    private static final Integer2[] cache = new Integer2[256];
	    
	    static {
	        for (int i = 0; i < cache.length; i++) {
	            cache[i] = new Integer2(i - 128);
	        }
	    }

	    // The value of the Integer
	    private final int value;

	    // Constructor that takes an int
	    public Integer2(int value) {
	        this.value = value;
	    }

	    // Constructor that parses a string to create an Integer
	    public Integer2(String s) throws NumberFormatException {
	        this.value = parseInt(s);
	    }

	    // Returns the int value of this Integer
	    public int intValue() {
	        return value;
	    }

	    // Static method to parse a string into an int
	    public static int parseInt(String s) throws NumberFormatException {
	        if (s == null) {
	            throw new NumberFormatException("Null string");
	        }
	        return parseInt(s, 10);
	    }

	    // Static method to parse a string into an int with a given radix
	    public static int parseInt(String s, int radix) throws NumberFormatException {
	        if (s == null) {
	            throw new NumberFormatException("Null string");
	        }
	        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
	            throw new NumberFormatException("Invalid radix: " + radix);
	        }

	        int result = 0;
	        boolean negative = false;
	        int i = 0, len = s.length();
	        int limit = -MAX_VALUE;

	        if (len > 0) {
	            char firstChar = s.charAt(0);
	            if (firstChar == '-') {
	                negative = true;
	                limit = MIN_VALUE;
	                i++;
	            } else if (firstChar == '+') {
	                i++;
	            }
	            if (i < len) {
	                for (; i < len; i++) {
	                    int digit = Character.digit(s.charAt(i), radix);
	                    if (digit < 0) {
	                        throw new NumberFormatException("Invalid digit at index " + i);
	                    }
	                    result = result * radix + digit;
	                }
	            }
	        } else {
	            throw new NumberFormatException("Empty string");
	        }

	        return negative ? -result : result;
	    }

	    // Returns the string representation of this Integer
	    @Override
	    public String toString() {
	        return String.valueOf(value);
	    }

	    // Static method to convert an int to a string
	    public static String toString(int i) {
	        return String.valueOf(i);
	    }

	    // Compares two Integer objects
	    @Override
	    public int compareTo(Integer2 anotherInteger) {
	        return Integer2.compare(this.value, anotherInteger.value);
	    }

	    // Static method to compare two int values
	    public static int compare(int x, int y) {
	        return (x < y) ? -1 : ((x == y) ? 0 : 1);
	    }

	    // Equals method to compare with another object
	    @Override
	    public boolean equals(Object obj) {
	        if (obj instanceof Integer2) {
	            return value == ((Integer2) obj).intValue();
	        }
	        return false;
	    }

	    // Hashcode for the Integer object
	    @Override
	    public int hashCode() {
	        return Integer2.hashCode(value);
	    }

	    // Returns the hash code for a primitive int
	    public static int hashCode(int value) {
	        return value;
	    }

	    // Convert Integer to a primitive long
	    @Override
	    public long longValue() {
	        return (long) value;
	    }

	    // Convert Integer to a primitive double
	    @Override
	    public double doubleValue() {
	        return (double) value;
	    }

	    // Convert Integer to a primitive float
	    @Override
	    public float floatValue() {
	        return (float) value;
	    }

	    // Returns a cached Integer instance for values between -128 and 127
	    public static Integer2 valueOf(int i) {
	        if (i >= -128 && i <= 127) {
	            return cache[i + 128];
	        }
	        return new Integer2(i);
	    }

	    // Parses the string argument as a signed decimal integer
	    public static Integer2 valueOf(String s) throws NumberFormatException {
	        return Integer2.valueOf(parseInt(s, 10));
	    }
	}


