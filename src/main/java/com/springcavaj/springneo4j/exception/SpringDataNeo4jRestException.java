package com.springcavaj.springneo4j.exception;

public class SpringDataNeo4jRestException extends RuntimeException {

	private static final long serialVersionUID = -6516355976276869122L;

	private String exceptionMessage;
	private String exceptionCause;
	
	public SpringDataNeo4jRestException() {
	}
	
	public SpringDataNeo4jRestException(String exceptionMessage, String exceptionCause) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.exceptionCause = exceptionCause;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public String getExceptionCause() {
		return exceptionCause;
	}
	public void setExceptionCause(String exceptionCause) {
		this.exceptionCause = exceptionCause;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SpringDataNeo4jRestException [exceptionMessage=");
		builder.append(exceptionMessage);
		builder.append(", exceptionCause=");
		builder.append(exceptionCause);
		builder.append("]");
		return builder.toString();
	}
}
