package com.example.springbootmssqlrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmssqlrestapi.domain.User;
import com.example.springbootmssqlrestapi.service.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ExampleProperty;
import io.swagger.annotations.Example;


@Api(tags = "UserController")
@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@ApiOperation(value="Find All Users",notes="Find All Users")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findAll() {
		List<User> users = this.usersService.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@ApiOperation(value="Find User",notes="Find User By ID")
	@ApiImplicitParams({
        @ApiImplicitParam(
        		required = true,
        		name = "id", 
        		value = "User ID", 
        		dataType = "Integer"
        )
	})
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findOne(@PathVariable Integer id) {
		User user = this.usersService.findById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@ApiOperation(value="Create User",notes="Create User")
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> create(@RequestBody User user) {
		this.usersService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
		user.setId(id);
		this.usersService.update(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity delete(@PathVariable Integer id) {
		this.usersService.delete(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}