package com;

import java.sql.*;

public class Employee {
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electrogrid", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String readEmployees() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			
			output = "<table class='table table-hover'><tr><th>First Name</th><th>Last Name</th><th>Email</th>"
					+ "<th>User Role</th><th>Password</th><th>Update</th><th>Remove</th></tr>";

			String query = "select * from employee";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String id = Integer.toString(rs.getInt("id"));
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String user_role = rs.getString("user_role");
				String password = rs.getString("password");
				// Add into the html table
				output += "<tr><td><input id='hididUpdate' name='hididUpdate' type='hidden' value='" + id
						+ "'>" + first_name + "</td>";
				output += "<td>" + last_name + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + user_role + "</td>";
				output += "<td>" + password + "</td>";
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='"
						+ id + "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Employees.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String insertEmployees(String first_name, String last_name, String email, String user_role,
			String password) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into employee(`id`,`first_name`,`last_name`,`email`,`user_role`,`password`)"
					+ "values(?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			System.out.println(password);
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, first_name);
			preparedStmt.setString(3, last_name);
			preparedStmt.setString(4, email);
			preparedStmt.setString(5, user_role);
			preparedStmt.setString(6, password);
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newUse = readEmployees();
			output = "{\"status\":\"success\", \"data\": \"" +newUse+ "\"}";
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the Users.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateEmployees(String id,String first_name, String last_name, String email, String user_role,
			String password) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE employee SET first_name=?,last_name=?,email=?,user_role=?,password=? WHERE id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			
		
			preparedStmt.setString(1, first_name);
			preparedStmt.setString(2, last_name);
			preparedStmt.setString(3, email);
			preparedStmt.setString(4, user_role);
			preparedStmt.setString(5, password);
			preparedStmt.setInt(6, Integer.parseInt(id));
	
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newUse =readEmployees();
			output = "{\"status\":\"success\", \"data\": \"" +newUse+ "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the user.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteEmployees(String id) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from employee where id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(id));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newUse = readEmployees();
			output = "{\"status\":\"success\", \"data\": \"" +newUse + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the user.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String readEmployeesonly() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			
			output = "<table class='table table-hover'><tr><th>First Name</th><th>Last Name</th><th>Email</th>"
					+ "<th>User Role</th><th>Password</th><th>Remove</th></tr>";

			String query = "select * from employee";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String id = Integer.toString(rs.getInt("id"));
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String user_role = rs.getString("user_role");
				String password = rs.getString("password");
				// Add into the html table
				output += "<tr><td><input id='hididUpdate' name='hididUpdate' type='hidden' value='" + id
						+ "'>" + first_name + "</td>";
				output += "<td>" + last_name + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + user_role + "</td>";
				output += "<td>" + password + "</td>";
				// buttons
				output += "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='"
						+ id + "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Employees.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}