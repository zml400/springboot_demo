/**
 * 
 */
package com.zml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zml.model.Book;
import com.zml.service.BookService;

/**
 * @author zhangml
 *
 */

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@ResponseBody
	@RequestMapping("/addBook.action")
	public String addBook(Book book) {
		return bookService.addBook(book);
	}
	@ResponseBody
	@RequestMapping("/deleteBook.action")
	public String deleteBook(String id) {
		return bookService.deleteBook(id);
	}
	@ResponseBody
	@RequestMapping("/updateBook.action")
	public String updateBook(Book book) {
		return bookService.updateBook(book);
	}
	@ResponseBody
	@RequestMapping("/findByName.action")
	public Book findByName(String name) {
		return bookService.findByName(name);
	}
	
	@ResponseBody
	@RequestMapping("/findAll.action")
	public List<Book> findAll() {
		return bookService.findAll();
	}
}
