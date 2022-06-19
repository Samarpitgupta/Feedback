package utils;

public class RequestDataMissingException extends RuntimeException{
	 /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
   /**
    * 
    */
    public RequestDataMissingException(){
	         super();
    }
    /**
     * 
     * @param message
     */
    public RequestDataMissingException(String message) {
	this.message = message;
    }
}
