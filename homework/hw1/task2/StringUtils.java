/**
 * @author Ali Darvish
 *
 */
public class StringUtils {

	/** This method compresses a string using the counts of repeated consecutive characters. For instance, 
	 * aabcccccaaa would be compressed as a2blc5a3. If the length of the compressed string is not less than the input
	 * string, the input string value would be returned with no compression. An example for the latter 
	 * case would be "ab" (i.e., compress("ab") returns "ab" not "a1b1").
	 *   
	 * @param str the input string to be compressed
	 * @return compressed string
	 * @throws NullPointerException if str is null
	 */
	public String compress(String str) {
		StringBuilder compressed= new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			/* If next character is different than current, append this char to result.*/
			if (i >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() <= str.length() ? compressed.toString() : str;
	}
	
	/** This method checks if two strings are permutations of each other or not. A permutation is a 
	 * rearrangement of characters. For instance, "cat" and "act" are permutations of each other while
	 * "abcdd" and "bddae" are not.
	 * 
	 * @param str1 the first input string
	 * @param str2 the second input string
	 * @return true if the two strings are permutations of each other, false otherwise
	 * @throws NullPointerException if str1 or str2 is null
	 */
	public boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int[] letters = new int[256]; 
		char[] s_array = str1.toCharArray();
		for (char c : s_array) { 
			letters[c]++;
		}
		for (int i = 0; i < str2.length(); i++) {
			int c = (int) str2.charAt(i);
			if (letters[c] < 0) {
				return false;
			}
			letters[c]--;
		}
		return true;
	}
	
	/** This method checks if a string is a permutation of a palindrome or not. A permutation is a 
	 * rearrangement of characters. A palindrome string is a string that reads the 
	 * same forward and backwards. For example, "F", "ABA", "abdgjgdba", "bahhab" are all palindormes.
	 * Thus, for instance, the method returns true for "BAA" since it is a permutation of 
	 * "ABA" which is a palindrome.
	 *    
	 * @param str the input string
	 * @return true if str is a permutation of a palindrome, false otherwise.
	 * @throws NullPointerException is str is null 
	 */
	public boolean isPermutationOfPalindrome(String str) {
		int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : str.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;
				if (table[x] % 2 == 1) {
					countOdd++;
				} else {
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	} 
	
	/** IGNORE THIS ONE: This method does not need to be tested. 
	 * Auxiliary method used by isPermutationOfPalindrome.
	 * @param c
	 * @return
	 */
	private int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val= Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	} 
	
	/** This method converts a string to an integer similar to what atoi 
	 * does in C or what Integer.parseInt() in Java does. If the string exceeds 
	 * Integer.MAX_VALUE, Integer.MAX_VALUE is returned. If the string falls below
	 * Integer.MIN_VALUE, Integer.MIN_VALUE is returned. If the string is empty, it 
	 * returns zero. 
	 * 
	 * @param str the input string
	 * @return the integer value represented by str
	 * @throws NullPointerException is str is null
	 * @throws NumberFormatException if str contains any non-digit characters 
	 */
	public int stringToInteger(String str) {
		int index = 0, sign = 1, total = 0, len = str.length();
		
		for (int i = 0; i < str.length(); i++) {
			
			if ((str.charAt(i) < '0' || str.charAt(i) > '9')) {
				if (i == 0 && (str.charAt(i) == '-' ||  str.charAt(i) == '+'))
					continue;
				throw new NumberFormatException();
			}
				
		}
		
	    while (index < len && str.charAt(index) == ' ') {
	        index++;
	    }
	    if (index > len) {
	        return 0;
	    }

	    if (str.charAt(index) == '+' || str.charAt(index) == '-') {
	        sign = str.charAt(index) == '+' ? 1 : -1;
	        index++;
	    }

	    while (index < len) {
	        int digit = str.charAt(index) - '0';
	        if (digit < 0 || digit > 9) 
	        	break;

	        if (total > (Integer.MAX_VALUE + digit) / 10 || total < (Integer.MIN_VALUE - digit) / 10) {
	            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	        }
	        total = 10 * total + sign * digit;
	        index++;
	    }
	    return total;
	}
}