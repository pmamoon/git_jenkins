package com.victolee.guestbook.exception;

public class GuestbookExcpetion extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GuestbookExcpetion() {
		super("GuestBookDAOException Occurs");
	}
	
	public GuestbookExcpetion(String msg) {
		super(msg);
	}
}
