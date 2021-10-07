package com.techment.service;

import com.techment.dto.UserDto;
import com.techment.entity.User;

public interface IUserService {

	UserDto register(User user);
	String deleteUser(int userId);
	String updateUser(User user,int userId);
	UserDto validateUser(User user);
}
