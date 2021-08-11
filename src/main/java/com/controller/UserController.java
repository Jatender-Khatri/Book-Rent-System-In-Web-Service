package com.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.UserEntityDao;
import com.daoImpl.UserEntityDaoImpl;
import com.model.UserEntity;


@Path("/user")
public class UserController {
	UserEntityDao userDao = new UserEntityDaoImpl();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addUser")
	public UserEntity addUser(UserEntity entity)
	{
		userDao.addUser(entity);
		return entity;
	}
}
