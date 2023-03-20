package com.libraryapp.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryapp.main.entity.UserEntity;
import com.libraryapp.main.exception.ResourceNotFoundException;
import com.libraryapp.main.model.User;
import com.libraryapp.main.repository.IUserRepository;

@Service
public class UserService  implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		// convert product model to product entity
				UserEntity userEntity = new UserEntity();
				BeanUtils.copyProperties(user, userEntity);

				UserEntity newUserEntity = userRepository.save(userEntity);

				// convert product entity to product model
			    User newUser= new User();
				BeanUtils.copyProperties(newUserEntity, newUser);

				return newUser;
	}

	@Override
	public User viewUserById(int userId) {
		// TODO Auto-generated method stub
		Optional<UserEntity> optionalUser = userRepository.findById(userId);
		
		if (!optionalUser.isPresent()) {
			throw new ResourceNotFoundException("User not existing with id: " + userId);
		}
		
		UserEntity userEntity = optionalUser.get();

		// convert product entity to product model
		User user = new User();
		BeanUtils.copyProperties(userEntity, user);

		return user;
		
	
	}

	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		
        List<UserEntity> userEntities = userRepository.findAll();
		
		//convert product entity list to product list
		List<User> products = new ArrayList<>();
		
		userEntities.forEach(uentity-> {
			User user = new User();
			BeanUtils.copyProperties(uentity, user);
			products.add(user);
		});		
		
		return products;
		
	}
	
	


}
