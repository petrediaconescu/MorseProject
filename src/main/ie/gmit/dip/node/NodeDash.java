package ie.gmit.dip.node;

/** @author Petre Diaconescu
 * @version 1.0 */
public class NodeDash<Key, Value> extends AbstractNode<Key, Value> {
	/**
	 * It creates a NodeDash.
	 * Time complexity: O(1)
	 * @param key
	 * @param val
	 */
	public NodeDash(Key key, Value val) {
		this.key = key;
		this.value = val;
		this.nodeType = NodeType.DASH;
	}
	// O(1)
	public NodeType getNodeType() {
		return NodeType.DASH;
	}

}
