package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	protected final String url = "jdbc:mysql://localhost:3306/jee";
	private String login, password;
	private Connection conn;

	public DAO(){
		this.login = "root";
		this.password = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver PROBLEM ");
		}

		try {
			this.conn = DriverManager.getConnection(this.url, this.login, this.password);
			System.out.println("Connection établie");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection non établie");
		}
	}

	public String getUrl() {
		return url;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
