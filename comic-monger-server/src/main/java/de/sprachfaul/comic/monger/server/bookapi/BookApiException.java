package de.sprachfaul.comic.monger.server.bookapi;

public class BookApiException extends Exception {

	private static final long serialVersionUID = 1L;

	public BookApiException() {
		super();
	}

	public BookApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BookApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookApiException(String message) {
		super(message);
	}

	public BookApiException(Throwable cause) {
		super(cause);
	}
}
