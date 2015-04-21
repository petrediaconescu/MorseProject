package ie.gmit.dip.exceptions;

/** @author Petre Diaconescu 
 * @version 1.0*/
public class ElementNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 777L;
	
	public ElementNotFoundException() {
		super("Element not found");
	}
	/**
	 * 
	 * @param message to be thrown.
	 */
	public ElementNotFoundException(String message) {
		super(message);
	}

	public String getMessage() {
		return super.getMessage();
	}

}
