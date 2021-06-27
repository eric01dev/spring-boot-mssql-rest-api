package com.example.springbootmssqlrestapi.domain;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="User",description = "User Model")
@Entity
@Table(name = "users", catalog = "dbo")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "User ID", readOnly = true)
	private Integer id;
	@ApiModelProperty(value = "User Name", example = "Tom")
	private String name;
	@ApiModelProperty(value = "User Age", example = "18")
	private Integer age;

	public User() {
	}

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("Users[id=%d, name='%s', lastName='%s']", id, name, age);
	}
}