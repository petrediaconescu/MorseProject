package ie.gmit.dip.node;

/** @author Petre Diaconescu
 * @version 1.0 */
public class NodeDot<Key, Value> extends AbstractNode<Key, Value> {
	/**
	 * It creates a NodeDot.
	 * Time complexity: O(1)
	 * @param key
	 * @param val
	 */
	public NodeDot(Key key, Value val) {
		this.key = key;
		this.value = val;
		this.nodeType = NodeType.DOT;
	}
	// O(1)
	public NodeType getNodeType() {
		return NodeType.DOT;
	}

}
