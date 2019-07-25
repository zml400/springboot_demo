/**
 * 
 */
package com.zml.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.zml.model.Book;

/**
 * @author zhangml
 *
 */

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
	 * 添加对象
	 * @param book
	 * @return
	 */
	@Override
	public String addBook(Book book) {
		book.setCreateTime(new Date());
		book.setState(1);
		mongoTemplate.save(book);
		return "true";
	}

	/**
	 * 删除对象
	 * @param id
	 * @return
	 */
	@Override
	public String deleteBook(String id) {
		Book book =findById(id);
		mongoTemplate.remove(book);
		return "true";
	}

	/**
	 * 更新对象
	 * @param book
	 * @return
	 */
	@Override
	public String updateBook(Book book) {
		Query query = new Query(Criteria.where("id").is(book.getId()));
		Update update = new Update();
		update.set("name", book.getName());
		update.set("price", book.getPrice());
		update.set("publish", book.getPublish());
		update.set("info", book.getInfo());
		update.set("updateTime", new Date());
		mongoTemplate.upsert(query, update, Book.class);
		return "true";
	}

	/**
	 * 根据id查找对象
	 * @param id
	 * @return
	 */
	@Override
	public Book findById(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, Book.class);
	}

	/**
	 * 根据名称查找对象
	 * @param name
	 * @return
	 */
	@Override
	public Book findByName(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		return mongoTemplate.findOne(query, Book.class);
	}

	/**
	 * 查找所有对象
	 * @return
	 */
	@Override
	public List<Book> findAll() {
		return mongoTemplate.findAll(Book.class);
	}
	

}
