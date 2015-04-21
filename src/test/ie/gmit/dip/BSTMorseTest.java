/**
 * 
 */
package ie.gmit.dip;

import static org.junit.Assert.*;

import ie.gmit.dip.exceptions.ElementNotFoundException;
import ie.gmit.dip.node.NodeType;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Petre Diaconescu
 */
public class BSTMorseTest {
	BSTMorse<String, Character> bstMorse;

	/** @throws java.lang.Exception */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/** @throws java.lang.Exception */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Initializing the bstMorse object (BSTMorse Data Structure)
	 * @throws java.lang.Exception */
	@Before
	public void setUp() throws Exception {
		bstMorse = new BSTMorse<String, Character>();
	}

	/**Populating the Tree with values from Morse Code */
	private void prepareDataForGet() {
		bstMorse.put("1", '#');
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
		bstMorse.put("1000110", (char) 13); // carriage return
		bstMorse.put("1000101", (char) 10); // new line
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ie.gmit.dip.BSTMorse#getValue(java.lang.Object)}.
	 */
	@Test
	public void testGetE() {
		prepareDataForGet();
		testCharacter(new Character('E'), "11");
	}

	/**
	 * Test method for {@link ie.gmit.dip.BSTMorse#getValue(java.lang.Object)}.
	 */
	@Test
	public void testGetB() {
		prepareDataForGet();
		testCharacter(new Character('B'), "10111");
	}

	/**
	 * Test method for {@link ie.gmit.dip.BSTMorse#getValue(java.lang.Object)}.
	 */
	@Test
	public void testGet1() {
		prepareDataForGet();
		testCharacter(new Character('1'), "110000");
	}

	/**
	 * Test method for {@link ie.gmit.dip.BSTMorse#getValue(java.lang.Object)}.
	 */
	@Test(expected = ElementNotFoundException.class)
	public void testThrowExceptionInvalidKey()
			throws ElementNotFoundException {
		prepareDataForGet();
		// test an invalid key
		bstMorse.getValue(new String("11000000"));
	}

	/**
	 * Test method for {@link ie.gmit.dip.BSTMorse#getValue(java.lang.Object)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testThrowExceptionNullKey() throws NullPointerException {
		prepareDataForGet();
		// test a null key
		bstMorse.getValue(null);
	}

	/**
	 * Test method for
	 * {@link ie.gmit.dip.BSTMorse#getKeyByValue(java.lang.Object)}.
	 */
	@Test(expected = ElementNotFoundException.class)
	public void testThrowExceptionInvalidValue() throws ElementNotFoundException {
		prepareDataForGet();
		// test an invalid value
		bstMorse.getKeyByValue('|');
	}

	/**
	 * Test method for
	 * {@link ie.gmit.dip.BSTMorse#put(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public void testPutV() {
		bstMorse.put("11110", 'V');
		char expected = new Character('V');
		char actual = bstMorse.getValue("11110");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link ie.gmit.dip.BSTMorse#put(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public void testPutDotCharacter() {
		bstMorse.put("101010", '.');
		char expected = new Character('.');
		char actual = bstMorse.getValue("101010");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link ie.gmit.dip.BSTMorse#getKeyByValue(java.lang.Object)}.
	 */
	@Test
	public void testGetKeyByValue4() {

		// 1. prepare data
		prepareDataForGet();

		// 2. run method
		List<NodeType> actualPath = bstMorse.getKeyByValue(new Character('4'));

		// 3. assert
		List<NodeType> expectedPath = new ArrayList<NodeType>();
		expectedPath.add(NodeType.DOT);
		expectedPath.add(NodeType.DOT);
		expectedPath.add(NodeType.DOT);
		expectedPath.add(NodeType.DOT);
		expectedPath.add(NodeType.DASH);

		assertArrayEquals(expectedPath.toArray(), actualPath.toArray());
	}

	/**
	 * Test method for
	 * {@link ie.gmit.dip.BSTMorse#getKeyByValue(java.lang.Object)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetKeyByValueIfDataMissing() throws NullPointerException {

		// 2. run method
		List<NodeType> actualPath = bstMorse.getKeyByValue(new Character('4'));

		// 3. assert
		List<NodeType> expectedPath = new ArrayList<NodeType>();
		expectedPath.add(NodeType.DOT);
		expectedPath.add(NodeType.DOT);
		expectedPath.add(NodeType.DOT);
		expectedPath.add(NodeType.DOT);
		expectedPath.add(NodeType.DASH);

		assertArrayEquals(expectedPath.toArray(), actualPath.toArray());
	}

	/** It will call <code>getValue(morseValue)</code>;
	 * 
	 * @param expectedCharacter
	 * @param morseValue
	 */
	private void testCharacter(Character expectedCharacter, String morseValue) {
		Character actualCharacter = bstMorse.getValue(morseValue);
		assertEquals(expectedCharacter, actualCharacter);
	}
}
