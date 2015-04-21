package ie.gmit.dip.node;

/**
 * @author Petre Diaconescu
 * @version 1.0
 * 
 * @see Time Complexity: All the methods run in O(1)>
 */
public abstract class AbstractNode<Key, Value> {

	// default access modifiers to be accessible by other classes in the package
	// (ie. NodeDash)
	Key key;
	Value value;
	AbstractNode<Key, Value> left;
	AbstractNode<Key, Value> right;
	NodeType nodeType;

	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * @return the value
	 */
	public Value getValue() {
		return value;
	}

	/**
	 * @param val
	 *            the value to set
	 */
	public void setValue(Value val) {
		this.value = val;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(AbstractNode<Key, Value> left) {
		this.left = left;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(AbstractNode<Key, Value> right) {
		this.right = right;
	}

	/**
	 * @return the left
	 */
	public AbstractNode<Key, Value> getLeft() {
		return left;
	}

	/**
	 * @return the right
	 */
	public AbstractNode<Key, Value> getRight() {
		return right;
	}

	/**
	 * Abstract method with no implementation.
	 */
	public abstract NodeType getNodeType();

}