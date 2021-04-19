package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
	private static Connection connect() throws ClassNotFoundException{		
		Class.forName("org.sqlite.JDBC");
		String path = "jdbc:sqlite:src/model/data.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(path);
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
	}
	
	public int insertStudent(Student student) {
		Connection conn = null;
		try {
			conn = Database.connect();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		String query = "insert into student('id', 'name', 'year', 'gender') values (?,?,?,?)";
		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, student.getId());
			st.setString(2, student.getName());
			st.setString(3, student.getYear());
			st.setString(4, student.getGender());
			
			return st.executeUpdate();
		} catch (SQLException e){
			System.out.println("error: " + e.getMessage());
			return -1;
		}
	}

}
