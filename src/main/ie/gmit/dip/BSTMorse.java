package ie.gmit.dip;

import ie.gmit.dip.exceptions.ElementNotFoundException;
import ie.gmit.dip.node.AbstractNode;
import ie.gmit.dip.node.NodeDash;
import ie.gmit.dip.node.NodeDot;
import ie.gmit.dip.node.NodeType;
import ie.gmit.dip.node.NodeRoot;

import java.util.*;

/**
 * @author Petre Diaconescu
 * @version 1.0
 * @param <Key>
 * @param <Value>
 */
public class BSTMorse<Key, Value> {

	private AbstractNode<Key, Value> root;

	/**
	 * Time complexity: O(log (N)) - depending on getValue(node, key)
	 * 
	 * @param key
	 *            - Any type of a key
	 * @return <tt>value</tt> associated with the key
	 * @throws ElementNotFoundException
	 *             if the value was not found
	 */
	public Value getValue(Key key) throws ElementNotFoundException {
		Value value = getValue(root, key);
		if (value != null) {
			return value;
		} else {
			throw new ElementNotFoundException(
					"The given key is not corresponding to any value");
		}
	}

	/**
	 * It's recursively visiting the Nodes that are on the way down to the given
	 * path (key), and return when found the match. If nothing found, it returns
	 * <code>null.</code>
	 * 
	 * <pre></pre>
	 * 
	 * Time complexity: O(log (N)) if the Tree is balanced. It might go to O(N)
	 * if inserting just to the left or just to the right. However this is not a
	 * good practice when using a Tree data structure. If your binary mappable
	 * data is very unbalanced, it is recommended to use a different Data
	 * Structure
	 * 
	 * <pre></pre>
	 * 
	 * @param node
	 *            starting from the root
	 * @param key
	 *            any type of a key
	 * @return <code>value</code> associated with the key if found, otherwise
	 *         <code>null</>
	 */
	private Value getValue(AbstractNode<Key, Value> node, Key key) {
		if (node == null) {
			return null;
		}

		NodeCompare nodeComparator = new NodeCompare();
		String usersKey = key.toString();
		String currentNodesKey = node.getKey().toString();

		// They are at the same level following the right path, it means it is
		// the right Node
		if (usersKey.length() == currentNodesKey.length()) {
			return node.getValue();
		}
		// cmp tells if should go left (1), right (0) or the key is equal (-1)
		// It will recursively call getValue until the value is found
		int cmp = nodeComparator.compare(key, node.getKey());
		if (cmp == 1) {
			return getValue(node.getLeft(), key);
		} else { // cmp = 0
			return getValue(node.getRight(), key);
		}
	}

	/**
	 * Time complexity: O(log (N)) - depending on put(currentNode, key, val,
	 * nodeType)
	 * 
	 * @param key
	 *            any type of a key
	 * @param val
	 *            any type of a value
	 * 
	 * @see {@link ie.gmit.dip.BSTMorse#put(AbstractNode, Object, Object, NodeType)}
	 */
	public void put(Key key, Value val) {
		root = put(root, key, val, NodeType.ROOT);
	}

	/**
	 * Time complexity: O(log (N)). It might go to O(N) if inserting just to the
	 * left or just to the right. However this is not a good practice when using
	 * a Tree data structure. If your binary mappable data is very unbalanced,
	 * it is recommended to use a different Data Structure
	 * 
	 * <pre></pre>
	 * 
	 * @param currentNode
	 *            starting from the root
	 * @param key
	 *            any type of a key
	 * @param val
	 *            any type of a value
	 * @param nodeType
	 *            NodeType.DOT, NodeType.DASH, NodeType.ROOT
	 * @return <code>node</code> the inserted node
	 * 
	 * @see {@link ie.gmit.dip.BSTMorse#createNodeInstance(Object, Object, NodeType)
	 */
	private AbstractNode<Key, Value> put(AbstractNode<Key, Value> currentNode,
			Key key, Value val, NodeType nodeType) {
		//
		NodeCompare nodeComparator = new NodeCompare();

		if (currentNode == null) {
			return createNodeInstance(key, val, nodeType);
		}
		int cmp = nodeComparator.compare(key, currentNode.getKey());
		if (cmp == 1) {
			// put returns a Node
			currentNode.setLeft(put(currentNode.getLeft(), key, val,
					NodeType.DOT));
		} else { // cmp ==0
			// put returns a Node
			currentNode.setRight(put(currentNode.getRight(), key, val,
					NodeType.DASH));
		}
		return currentNode;
	}

	/**
	 * Time complexity: O(1) - constant operation
	 * 
	 * @param key
	 * @param val
	 * @param nodeType
	 * @return <code>new Node</code> of type ROOT, DOT or DASH
	 */
	private AbstractNode<Key, Value> createNodeInstance(Key key, Value val,
			NodeType nodeType) {
		if (nodeType == NodeType.ROOT) {
			return new NodeRoot<Key, Value>(key, val);
		} else if (nodeType == NodeType.DOT) {
			return new NodeDot<Key, Value>(key, val);
		} else {
			return new NodeDash<Key, Value>(key, val);
		}
	}

	private class NodeCompare implements Comparator<Key> {
		/**
		 * It converts the keys into String and subtract one from the other and
		 * returning the next char which is 1 or 0
		 * 
		 * Time complexity: O(1) - constant time
		 * 
		 * @param Key
		 *            the one from user
		 * @param Key
		 *            the one from current node
		 * @return <code>1</code> or <code>0</code>
		 * 
		 */
		public int compare(Key fromUser, Key fromCurrentNode) {

			String fromUserString = fromUser.toString();
			String fromCurrentNodeString = fromCurrentNode.toString();

			String temp = fromUserString.substring(fromCurrentNodeString
					.length());

			if (temp.charAt(0) == '1') {
				return 1; // go left
			} else {
				return 0; // go right
			}
		}
	}

	//
	/**
	 * Time complexity: O(log (N)) depending on getKeyByValue(value, root,
	 * nodePath)
	 * 
	 * @param value
	 * @return <code>nodePath</code> a <code>List</code> of Node Types
	 * @throws ElementNotFoundException
	 */
	public List<NodeType> getKeyByValue(Value value)
			throws ElementNotFoundException {
		// creates a new ArrayList to store the elements of the key
		// and then reverse them to have the correct key
		List<NodeType> nodePath = new ArrayList<NodeType>();
		nodePath = getKeyByValue(value, root, nodePath);
		Collections.reverse(nodePath);

		if (nodePath.isEmpty()) {
			throw new ElementNotFoundException(
					"The given value is not corresponding to any element");
		}

		return nodePath;
	}

	/**
	 * It goes down through the Tree and on the way back is collecting all the
	 * symbols representing the path. When hits the ROOT it will stop and return the path (nodePath)
	 * 
	 * Time complexity: O(log (N))
	 * 
	 * @param value
	 * @param currentNode
	 * @param nodePath
	 * @return <code>nodePath</code> a <code>List</code> of Node Types
	 */
	private List<NodeType> getKeyByValue(Value value,
			AbstractNode<Key, Value> currentNode, List<NodeType> nodePath) {
		if (currentNode == null) {
			return null;
		}
		if (currentNode.getValue().equals(value)) {
			nodePath.add(currentNode.getNodeType());
			return nodePath;
		}
		if (currentNode.getLeft() != null && nodePath.isEmpty()) {
			nodePath = getKeyByValue(value, currentNode.getLeft(), nodePath);
			if (!nodePath.isEmpty()
					&& !(currentNode.getNodeType().equals(NodeType.ROOT))) {
				nodePath.add(currentNode.getNodeType());
			}

		}
		if (currentNode.getRight() != null && nodePath.isEmpty()) {
			nodePath = getKeyByValue(value, currentNode.getRight(), nodePath);
			if (!nodePath.isEmpty()
					&& !(currentNode.getNodeType().equals(NodeType.ROOT))) {
				nodePath.add(currentNode.getNodeType());
			}
		}
		return nodePath;
	}
}