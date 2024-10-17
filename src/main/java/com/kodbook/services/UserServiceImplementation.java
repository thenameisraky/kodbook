package com.kodbook.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.entities.User;
import com.kodbook.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	UserRepository repo;

	@Override
	public void addUser(User user) {
		System.out.println(user);
		repo.save(user);
		
	}

	@Override
	public boolean userExists(String username, String email) {
		User user1=repo.findByUsername(username);
		User user2=repo.findByEmail(email);
		
		if(user1!=null||user2!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean usernameExists(String username) {
		return repo.findByUsername(username) != null;
	}

	@Override
	public boolean emailExists(String email) {
		return repo.findByEmail(email) != null;
	}

//	@Override
//	public boolean validateUser(String username, String password) {
//		String dbpass=repo.findByUsername(username).getPassword();
//		if(password.equals(dbpass))
//		{
//			return true;
//		}
//		return false;
//	}
	
	
//	@Override
//	public boolean validateUser(String username, String password) {
//	    User user = repo.findByUsername(username);
//	    System.out.println(user);
//	    if (user == null) {
//	        return false; 
//	    }
//	    String dbpass = user.getPassword();
//	  
//	    if (password.equals(dbpass)) {
//	        return true;
//	    }
//	    return false;
//	}
	
	
	//new way
	
	@Override
	public boolean validateUser(String credential, String password) {
	    User user = repo.findByUsername(credential);
	    if (user == null) {
	        user = repo.findByEmail(credential);
	    }
	    if (user == null) {
	        return false;
	    }
	    String dbpass = user.getPassword();
	    if (password.equals(dbpass)) {
	        return true;
	    }
	    return false;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return repo.findByUsername(username);
	}

	@Override
	public void updateUser(User user) {
		repo.save(user);
		
	}

	

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return repo.findByUsername(username);
	}

	@Override
	public void saveUser(User user) {
		repo.save(user);
		
	}
	
	@Override
	public User getUserByUser(User user) {
	    return getUserByUsername(user.getUsername());
	}





	
}
