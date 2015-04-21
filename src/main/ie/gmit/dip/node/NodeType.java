package ie.gmit.dip.node;

/** @author Petre Diaconescu 
 * @version 1.0*/
public enum NodeType {
	ROOT(null), DOT("."), DASH("-");
	
	private String type;
	
	// O(1)
	NodeType(String type) {
		this.type = type;
	}
	
	/**
	 * @return <code>type</code> String or null
	 */
	// O(1)
	@Override
	public String toString() {
		return type;
	}
}
