package dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dtos.RegisterDTO;

@Repository
public class UserDAO {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	
	 /**
     * Registers a new user if the email doesn't already exist.
     * @param registerDTO the user data
     * @return true if user is registered, false if email already exists
     */
	public boolean registerUser(RegisterDTO registerDTO) {
	  String hobbiesCsv = String.join(",", registerDTO.getHobbies());
	  String sql = "INSERT INTO users (full_name, gender, age, email, password, hobbies, agreed_terms) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?)";
	  int result =jdbcTemplate.update(sql,registerDTO.getName(),registerDTO.getGender(),registerDTO.getAge(),registerDTO.getEmail().toLowerCase(),registerDTO.getPassword(),hobbiesCsv,registerDTO.isAgree());
	  return result==1;
	}
	
	
	/**
     * Checks if a user with the given email already exists.
     * @param email the email to check
     * @return true if exists, false otherwise
     */
	public boolean emailExist(String email) {
		String sql = "SELECT COUNT(*) FROM users WHERE email=?";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email.toLowerCase());
		return count != null && count > 0;
	}

	/**
     * Checks if a user entered the correct password or not.
     * @param email the retrieve password from the database
     * @return password 
     */
	public String checkPassword(String email) {
		String sql="SELECT password FROM users WHERE email=?";
		 try {
		        return jdbcTemplate.queryForObject(sql, String.class, email);
		    } catch (EmptyResultDataAccessException e) {
		        // No user found with the given email
		        return null;
		    }
		
	}
	
	/**
     * Retrieves full name and user id based on the given email
     * @param email the email to get information
     * @return map that contains user id and full name as pair
     */
	//get the user id
	public Map<String, Object> getUserDetailsByEmail(String email) {
	    String sql = "SELECT user_id, full_name FROM users WHERE email = ?";
	    try {
	        return jdbcTemplate.queryForMap(sql, email);
	    } catch (EmptyResultDataAccessException e) {
	        return null; // or Collections.emptyMap();
	    }
	}

	
}
