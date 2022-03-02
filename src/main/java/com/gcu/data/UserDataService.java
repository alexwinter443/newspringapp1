package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import com.gcu.model.UserEntity;
import com.gcu.model.UserModel;
import com.gcu.model.UserModelMapper;
import com.gcu.model.UsersMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDataService {
	
	@Autowired
	DataSource datasource;
	JdbcTemplate jdbcTemplate;
	
	public UserDataService(DataSource datasource)
	{
		this.datasource = datasource;
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	
	/** 
	 * get a single user by their username and password
	 * @param username The username of the user to be retrieved
	 * @param password The password of the user to be retrieved
	 * @return int
	 */
	//@SuppressWarnings("deprecation")
	@SuppressWarnings("deprecation")
	public int getUsersByUsername(String username, String password)
	{
		System.out.println("OLD user data service getting user by username");
		//String sql = "SELECT COUNT(*) FROM users where username = ?";
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users where username = ? and password = ?", new Object[]{username, password}, Integer.class);

	}
	
	
	/** 
	 * get a single user by their username
	 * @param username The username of the user to be retrieved
	 * @return UserEntity
	 */
	// NOTE CHANGED FROM USERMODEL TO USERENTITY
	public UserEntity findByUsername(String username) {
		System.out.println("OLD user data service find by username");
		// query but easier with jdbc
		UserEntity result = jdbcTemplate.queryForObject("SELECT ID, USERNAME, PASSWORD, ROLE FROM users WHERE USERNAME = ?", 
				new UsersMapper(),
				new Object[] {username});
		// return the user
		return result;
	}

	
	/** 
	 * Add a user to the database
	 * @param user UserModel of the user to be added
	 * @return int
	 */
	public int addUser(UserModel user)
	{
		System.out.println("OLD user data service add user method");
		return jdbcTemplate.update("insert into users (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, PHONE) VALUES(?,?,?,?,?,?,?)",
				0,
				user.getUsername(),
				user.getPassword(),
				user.getFirstname(),
				user.getLastname(),
				user.getEmail(),
				user.getPhone()
				);
	}
	
	
	/** 
	 * get all users from the DB
	 * @return List<UserModel>
	 */
	// NOTE CHANGED FROM USERMODEL TO USERENTITY
	public List<UserModel> getAllUsers() {
		System.out.println("OLD user data service get all users");
		// query but easier with jdbc
		List<UserModel> result = jdbcTemplate.query("SELECT * FROM users", new UserModelMapper());
		// return the user
		return result;
	}
	
	
	/** 
	 * delete a user from the database by their id
	 * @param id The id of the user to be deleted
	 * @return boolean
	 */
	public boolean deleteOne(Long id) {
		int updateResult = jdbcTemplate.update(
				"DELETE FROM users WHERE ID = ?",
				new Object[] {id});
		System.out.println("user data service: Trying to delete" + id);
		System.out.println("user data service: result: " + updateResult);
		return (updateResult > 0);
	}

	
	/** 
	 * update a single user in the database
	 * @param idToUpdate The id of the user to be updated
	 * @param updateUser UserModel of the user to be updated
	 * @return UserModel
	 */
	// update a user by id with new user details
	public UserModel updateOne(Long idToUpdate, UserModel updateUser) {
		// sql query with injection protection
		int result = jdbcTemplate.update(
				"UPDATE users SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE = ?, ROLE = ? WHERE ID = ?",
				updateUser.getFirstname(),
				updateUser.getLastname(),
				updateUser.getEmail(),
				updateUser.getPhone(),
				updateUser.getRoles(),
				idToUpdate);
		if (result > 0) {
			return updateUser;
		}
		else {
			return null;
		}
	}
}
