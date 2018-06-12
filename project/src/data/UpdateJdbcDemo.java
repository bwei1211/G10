package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateJdbcDemo {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/g10?user=root&password=0000&serverTimezone=UTC&useSSL=false");

			Statement stmt = conn.createStatement();
			
			PreparedStatement sql = conn.prepareStatement("UPDATE student_table SET student_name = ?,java_teacher = ? WHERE student_id = ?");
			sql.setString(1,"David");
			sql.setInt(2, 4);
			sql.setInt(3, 6);
			sql.execute();

			ResultSet rs = stmt.executeQuery("select s.student_id, student_name, java_teacher , teacher_name" + " from student_table s , teacher_table t"
					+ " where t.teacher_id = s.java_teacher");

			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
			}

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
}