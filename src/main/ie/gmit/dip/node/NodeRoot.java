package ie.gmit.dip.node;

/** @author Petre Diaconescu 
 * @version 1.0*/
public class NodeRoot<Key, Value> extends AbstractNode<Key, Value> {
	/**
	 * It creates a NodeRoot.
	 * Time complexity: O(1)
	 * @param key
	 * @param val
	 */
	public NodeRoot(Key key, Value val) {
		this.key = key;
		this.value = val;
		this.nodeType = NodeType.ROOT;
	}

	// O(1)
	public NodeType getNodeType() {
		return NodeType.ROOT;
	}

}
