package edu.softserveinc.healthbody.webclient.soap;

public class SOAPCustomException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SOAPCustomException() { 
        super(); 
    } 
 
    public SOAPCustomException(String message) { 
        super(message); 
    } 
  
    public SOAPCustomException(Throwable cause) { 
        super(cause); 
    } 
 
    public SOAPCustomException(String message, Throwable cause) { 
        super(message, cause); 
    } 

}
