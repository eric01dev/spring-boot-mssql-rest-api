package com.example.springbootmssqlrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootmssqlrestapi.domain.User;
import com.example.springbootmssqlrestapi.exception.ObjectNotFoundException;
import com.example.springbootmssqlrestapi.repository.UsersRepository;

@Service
@Transactional
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	public User findById(Integer id) {

		Optional<User> result = this.usersRepository.findById(id);
		User user = result.isPresent() ? result.get() : null;
		if (user == null)
			throw new ObjectNotFoundException("Could not find user with id '" + id + "'");
		return user;
	}

	public List<User> findAll() {
		return this.usersRepository.findAll();
	}

	public void save(User user) {
		this.usersRepository.save(user);
	}

	public void update(User user) {

		User entity = this.findById(user.getId());

		if (user.getName() == null)
			user.setName(entity.getName());
		if (user.getAge() == 0)
			user.setAge(entity.getAge());

		this.save(user);
	}

	public void delete(Integer id) {

		Optional<User> result = this.usersRepository.findById(id);
		User user = result.isPresent() ? result.get() : null;
		if (user == null)
			throw new ObjectNotFoundException("Could not find user with id '" + id + "'");
		this.usersRepository.delete(user);
	}
}