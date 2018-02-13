package facebook;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FacebookDatabase {

	final private String dbName = "facebook2.db";
	final private String url = "jdbc:sqlite:db_file/" + dbName;
	final private String tableName = "Facebook";

	private Connection connect() {
		// SQLite connection string

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void createNewDatabase() {
		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createNewTable() {
		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (\n" + "	email text PRIMARY KEY,\n"
				+ "	password text,\n" + "	firstName text,\n" + "	lastName text,\n" + "	birthday text,\n"
				+ "	age text,\n" + "	isAdmin text\n" + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
			System.out.println("Table created sucessfully.");
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insert(String email, String password, String firstName, String lastName, String birthday, String age,
			String isAdmin) {
		String sql = "INSERT INTO " + tableName
				+ " (email,password,firstName,lastName,birthday,age,isAdmin) VALUES(?,?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setString(3, firstName);
			pstmt.setString(4, lastName);
			pstmt.setString(5, birthday);
			pstmt.setString(6, age);
			pstmt.setString(7, isAdmin);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean checkIsAdmin(String email) {
		String sql = "SELECT email,password,firstName,lastName,birthday,age,isAdmin FROM " + tableName + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				if (email.equals(rs.getString("email"))) {
					if (rs.getString("isAdmin").equals("1")) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public String getIndividualInformation(String email) {

		String sql = "SELECT email,password,firstName,lastName,birthday,age,isAdmin FROM " + tableName + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				if (email.equals(rs.getString("email"))) {
					String temp = rs.getString("email") + "," + rs.getString("password") + ","
							+ rs.getString("firstName") + "," + rs.getString("lastName") + ","
							+ rs.getString("birthday") + "," + rs.getString("age") + "," + rs.getString("IsAdmin");

					return temp;

				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "noMatch";
	}

	public boolean checkLoginForCustomer(String email, String password) {
		String sql = "SELECT email,password,firstName,lastName,birthday,age FROM " + tableName + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				if (email.equals(rs.getString("email")) && password.equals(rs.getString("password"))) {
					return true;

				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void showAllInformationInDatabase() {

		String sql = "SELECT email, password, firstName, lastName, birthday, age,isAdmin FROM " + tableName + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getString("email") + "\t" + rs.getString("password") + "\t"
						+ rs.getString("firstName") + "\t" + rs.getString("lastName") + "\t" + rs.getString("birthday")
						+ "\t" + rs.getString("age") + "\t" + rs.getString("IsAdmin"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<String[]> createTableFromDatabase() {
		String sql = "SELECT email, password, firstName, lastName, birthday, age,isAdmin FROM " + tableName + "";
		ArrayList<String[]> arr = new ArrayList<String[]>();
		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
//				System.out.println(rs.getString("email") + "\t" + rs.getString("password") + "\t"
//						+ rs.getString("firstName") + "\t" + rs.getString("lastName") + "\t" + rs.getString("birthday")
//						+ "\t" + rs.getString("age") + "\t" + rs.getString("IsAdmin"));
				String s[] = new String[4];
				s[0] = rs.getString("email");
				s[1] = rs.getString("firstName");
				s[2] = rs.getString("lastName");
				s[3] = rs.getString("age");
				arr.add(s);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		//System.out.println(arr.size());
		return arr;
	}

}
