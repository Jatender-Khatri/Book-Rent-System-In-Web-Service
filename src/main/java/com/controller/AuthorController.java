package com.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.AuthorEntityDao;
import com.daoImpl.AuthorEntityDaoImpl;
import com.model.AuthorEntity;
@Path("/author")
public class AuthorController {
	AuthorEntityDao authorDao = new AuthorEntityDaoImpl();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addAuthor")
	public AuthorEntity addAuthor(AuthorEntity entity)
	{
		authorDao.addAuthor(entity);
		return entity;
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateAuthor")
	public AuthorEntity updateAuthor(AuthorEntity entity)
	{
		authorDao.updateAuthor(entity);
		return entity;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteAuthor/{id}")
	public String deleteAuthor(@PathParam("id") Integer id)
	{
		AuthorEntity author = authorDao.getAuthorById(id);
		Integer roll = authorDao.deleteAuthor(author);
		if(roll>0)
		{
			return "Delete Successfully";
		}
		return "Error Occure";
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/authorGetById/{id}")
	public AuthorEntity AuthorGetById(@PathParam("id") Integer id)
	{
		return authorDao.getAuthorById(id);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllAuthor")
	public List<AuthorEntity> getAll(){
		return authorDao.getAuthors();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getByName/{name}")
	public AuthorEntity getByName(@PathParam("name") String name) {
		return authorDao.getAuthorByName(name);
	}
}
