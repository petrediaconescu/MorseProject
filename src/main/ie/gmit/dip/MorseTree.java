package ie.gmit.dip;

import ie.gmit.dip.node.NodeType;

import java.util.List;

/**
 * @author .--. . - .-. .
 * <pre></pre>
 *         -.. .. .- -.-. --- -. . ... -.-. ..-
 * @version 1.0
 */
public class MorseTree {

	private BSTMorse<String, Character> bstMorse = new BSTMorse<String, Character>();

	/**
	 * Constructs the Morse Tree, adding the alphabet-symbols according with
	 * wikipedia.org
	 * <pre></pre>
	 * Time complexity: O(log (N) - In this case 70 times * (log N), but we
	 * ignore the first operand as it is indirectly proportional with the size
	 * of the Tree and it will became irrelevant once the Tree is growing
	 */
	public MorseTree() {

		// Letters and Numbers according with wikipedia.org
		bstMorse.put("1", '#'); // starting Node
		bstMorse.put("11", 'E');
		bstMorse.put("111", 'I');
		bstMorse.put("110", 'A');
		bstMorse.put("1111", 'S');
		bstMorse.put("1110", 'U');
		bstMorse.put("1101", 'R');
		bstMorse.put("1100", 'W');
		bstMorse.put("11111", 'H');
		bstMorse.put("11110", 'V');
		bstMorse.put("11101", 'F');
		bstMorse.put("11011", 'L');
		bstMorse.put("11001", 'P');
		bstMorse.put("11000", 'J');
		bstMorse.put("11100", 'Ü');
		bstMorse.put("11010", 'Ä');
		bstMorse.put("110011", 'Þ');
		bstMorse.put("111111", '5');
		bstMorse.put("111110", '4');
		bstMorse.put("111100", '3');
		bstMorse.put("111000", '2');
		bstMorse.put("110000", '1');
		bstMorse.put("10", 'T');
		bstMorse.put("101", 'N');
		bstMorse.put("100", 'M');
		bstMorse.put("1011", 'D');
		bstMorse.put("1010", 'K');
		bstMorse.put("1001", 'G');
		bstMorse.put("1000", 'O');
		bstMorse.put("10111", 'B');
		bstMorse.put("10110", 'X');
		bstMorse.put("10101", 'C');
		bstMorse.put("10100", 'Y');
		bstMorse.put("10011", 'Z');
		bstMorse.put("10010", 'Q');
		bstMorse.put("10000", 'Ș');
		bstMorse.put("10001", 'Ö');
		bstMorse.put("101111", '6');
		bstMorse.put("100111", '7');
		bstMorse.put("100011", '8');
		bstMorse.put("100001", '9');
		bstMorse.put("100000", '0');
		bstMorse.put("100110", 'Ț');
		bstMorse.put("110010", 'À');
		bstMorse.put("101011", 'Ć');
		bstMorse.put("111011", 'É');
		bstMorse.put("111001", 'Ð');
		bstMorse.put("110110", 'È');
		bstMorse.put("100101", 'Ĝ');
		bstMorse.put("110001", 'Î');
		bstMorse.put("100100", 'Ñ');

		// Punctuation marks
		bstMorse.put("101010", ' ');
		bstMorse.put("110101", '+');
		bstMorse.put("1101010", '.');
		bstMorse.put("1001100", ',');
		bstMorse.put("1110011", '?');
		bstMorse.put("1100001", '\'');
		bstMorse.put("1010100", '!');
		bstMorse.put("101101", '/');
		bstMorse.put("101001", '(');
		bstMorse.put("1010010", ')');
		bstMorse.put("1000111", ':');
		bstMorse.put("101110", '=');
		bstMorse.put("1011110", '-');
		bstMorse.put("1101101", '"');
		bstMorse.put("1100101", '@');
		bstMorse.put("1001101", 'Ź');
		bstMorse.put("1010101", ';');

		// Added two more characters for file encoding
		bstMorse.put("1000110", (char) 13); // carriage return
		bstMorse.put("1000101", (char) 10); // new line

	} 

	/** Time complexity: O(log (N)) - depending on bstMorse.getValue(key)
	 * @param String key
	 * @return char value
	 *
	 */
	// 
	public char getValue(String key) {
		return bstMorse.getValue("1" + key);
	}

	/** Time complexity: O(log (N)) - depending on bstMorse.getValue(key)
	 * 
	 * @param char
	 * @return a String
	 */
	public String getKeyByValue(char value) {
		List<NodeType> morse = bstMorse.getKeyByValue(value);
		StringBuffer finalString = new StringBuffer();
		for (NodeType nodeType : morse) {
			finalString.append(nodeType);
		}
		return finalString.toString();
	}

}
