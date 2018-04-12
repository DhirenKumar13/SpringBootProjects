package com.udemy.springboot.basics.springbootstarter;

public class Book {
	private Long Id;
	private String bookName;
	private String bookAuthor;
	public Book(Long id, String bookName, String bookAuthor) {
		super();
		Id = id;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}
	public Long getId() {
		return Id;
	}
	public String getBookName() {
		return bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	@Override
	public String toString() {
		return "Book [Id=" + Id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + "]";
	}
	
}
