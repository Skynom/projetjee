package DAO;

import bean.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO extends DAO{

	public UserDAO(){
		super();
	}

	public User findById(int id){

		User user = null;
		Statement stmt = null;

		try {
			stmt = getConn().createStatement();
		}catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM user WHERE id = " + id ;
		ResultSet rs = null;

		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e){
			e.printStackTrace();
		}

		try {
			rs.next();
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public ArrayList<User> findAll() {
		ArrayList<User> list = new ArrayList<User>();
		Statement stmt = null;

		try {
			stmt = getConn().createStatement();
		}catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM user";
		ResultSet rs = null;

		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e){
			e.printStackTrace();
		}

		try {
			while(!rs.isLast()) {
				rs.next();
				User d = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insertUser(String username, String password, String nom, String prenom, String email) {
		
		for (User user : findAll())
			if (user.getUsername().equals(username))
				return false;
		
		Statement stmt = null;
		
		try {
			stmt = getConn().createStatement();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		String sql = "INSERT INTO user (username, password, nom, prenom, email) VALUES (" + username + ", " + password + ", " + nom  + ", " + prenom  + ", " + email + ");";

		try {
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
}
