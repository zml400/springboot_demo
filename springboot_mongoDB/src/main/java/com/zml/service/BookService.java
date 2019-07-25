/**
 * 
 */
package com.zml.service;

import java.util.List;

import com.zml.model.Book;

/**
 * @author zhangml
 *
 */
public interface BookService {
	public String addBook(Book book);
	public String deleteBook(String id);
	public String updateBook(Book book);
	public Book findById(String id);
	public Book findByName(String name);
	public List<Book> findAll();

}
