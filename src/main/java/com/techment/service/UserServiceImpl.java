package com.techment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.dao.IUserDao;
import com.techment.dto.UserDto;
import com.techment.entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userdao;

	@Override
	public UserDto register(User user) {
		// TODO Auto-generated method stub
		
		
		
		User u = userdao.save(user);
		UserDto dto = new UserDto(u.getUsername(), u.getPassword());
		return dto;
	}

	@Override
	public String deleteUser(int userId) {
	userdao.deleteById(userId);
	
		return "User deleted";
	}

	@Override
	public String updateUser(User user,int userId) {

       User oldUser = userdao.findById(userId).get();
       
       oldUser.setUsername(user.getUsername());
       oldUser.setPassword(user.getPassword());
       oldUser.setRole(user.getRole());
       
       userdao.save(oldUser);
       
      
		
		
		return "Updated";
	}

	@Override
	public UserDto validateUser(User user) {

       String username = user.getUsername();
       
      UserDto dto =  userdao.findByusername(username);
		return dto;
	}




}
