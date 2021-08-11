package com.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.BookEntityDao;
import com.daoImpl.BookEntityDaoImpl;
import com.model.BookEntity;

@Path("/book")
public class BookController {
	BookEntityDao bookDao = new BookEntityDaoImpl();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addBook")
	public BookEntity addBook(BookEntity entity)
	{
		bookDao.addBook(entity);
		return entity;
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateBook")
	public BookEntity updateBook(BookEntity entity)
	{
		bookDao.updateBook(entity);
		return entity;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteBook/{id}")
	public String deleteBook(@PathParam("id") Integer id)
	{
		BookEntity book = bookDao.getBookById(id);
		Integer roll = bookDao.deleteBook(book);
		if(roll>0)
		{
			return "Delete Successfully";
		}
		return "Error Occure";
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/BookGetById/{id}")
	public BookEntity bookGetById(@PathParam("id") Integer id)
	{
		return bookDao.getBookById(id);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllBooks")
	public List<BookEntity> getAll(){
		return bookDao.getAllBooks();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getByName/{name}")
	public BookEntity getByName(@PathParam("name") String name) {
		return bookDao.getBookByName(name);
	}
}
