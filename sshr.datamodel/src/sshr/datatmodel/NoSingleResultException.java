package sshr.datamodel;public final class NoSingleResultException extends Exception {	public NoSingleResultException() {			super();	}	public NoSingleResultException(String msg) {			super(msg);	}	public NoSingleResultException(Throwable t) {			super(t);	}	public NoSingleResultException(String msg, Throwable t) {			super(msg, t);	}}