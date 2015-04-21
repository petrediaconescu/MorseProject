/**
 * 
 */
package ie.gmit.dip;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Petre Diaconescu
 */
public class MorseTreeTest {
	
	MorseTree morseTree;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		morseTree = new MorseTree();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ie.gmit.dip.MorseTree#getValue(java.lang.String)}.
	 */
	@Test
	public void testGetA() {
		testCharacter(new Character('A'), "10");
	} 
	
	/**
	 * Test method for {@link ie.gmit.dip.MorseTree#getValue(java.lang.String)}.
	 */
	@Test
	public void testGetNewLineChar() {
		testCharacter(new Character((char) 10), "000101");
	}

	/**
	 * Test method for {@link ie.gmit.dip.MorseTree#getKeyByValue(char)}.
	 */
	@Test
	public void testGetKeyOf4() {
		String actualPath = morseTree.getKeyByValue(new Character('4'));
		String expectedPath = "....-";
		assertEquals(expectedPath, actualPath);
	}
	
	/**
	 * Test method for {@link ie.gmit.dip.MorseTree#getKeyByValue(char)}.
	 */
	@Test
	public void testGetKeyOfG() {
		String actualPath = morseTree.getKeyByValue(new Character('G'));
		String expectedPath = "--.";
		assertEquals(expectedPath, actualPath);
	}
	
	/** It will call <code>getValue(morseValue)</code>;
	 * 
	 * @param expectedCharacter
	 * @param morseValue
	 */
	private void testCharacter(Character expectedCharacter, String morseValue) {
		Character actualCharacter = morseTree.getValue(morseValue);
		assertEquals(expectedCharacter, actualCharacter);
	}

}
