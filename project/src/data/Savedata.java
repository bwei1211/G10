package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Savedata {
	
	int tempID;
	
	public Savedata(String name1, String name2) {
		
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
			ResultSet getID;
			ResultSet getID2;
			ResultSet getData;
			
			ResultSet rs = stmt.executeQuery("select count(*) from players_table where playername = '"+name1+"'");
			rs.next();
			
			PreparedStatement Pstmt;
			PreparedStatement Pstmt2;
			
			if(rs.getInt(1)==0){
				getID = stmt.executeQuery("select * from players_table order by playerID desc limit 1;");
				getID.next();
				
				Pstmt = conn.prepareStatement(
						"INSERT INTO players_table (playerID, playername) VALUES (?,?);");
				Pstmt.setInt(1, getID.getInt(1)+1);
				Pstmt.setString(2, name1);
				Pstmt.executeUpdate();
				
				Pstmt = conn.prepareStatement(
						"INSERT INTO game_data (playerID, win, lose, winrate) VALUES (?,?,?,?);");
				Pstmt.setInt(1, getID.getInt(1)+1);
				Pstmt.setInt(2, 1);
				Pstmt.setInt(3, 0);
				Pstmt.setInt(4, 1);
				Pstmt.executeUpdate();
			}
			else{
				getID = stmt.executeQuery("select playerID from players_table where playername = '"+name1+"' limit 1");
				getID.next();
				tempID = getID.getInt(1);
				
				getData = stmt.executeQuery("select win, lose from game_data where playerID = "+tempID+" limit 1");
				getData.next();
				
				Pstmt = conn.prepareStatement("UPDATE game_data SET win = ?, lose = ?, winrate = ? WHERE playerID = ?");
				Pstmt.setInt(1,getData.getInt(1)+1);
				Pstmt.setInt(2,getData.getInt(2));
				Pstmt.setFloat(3,(float) ((getData.getInt(1)+1)/(float) (getData.getInt(1)+1+getData.getInt(2))));
				Pstmt.setInt(4,tempID);
				Pstmt.execute();
			}
			
			rs = stmt.executeQuery("select count(*) from players_table where playername = '"+name2+"'");
			rs.next();
			
			if(rs.getInt(1)==0){
				getID = stmt.executeQuery("select * from players_table order by playerID desc limit 1;");
				getID.next();
				
				Pstmt = conn.prepareStatement(
						"INSERT INTO players_table (playerID, playername) VALUES (?,?);");
				Pstmt.setInt(1, getID.getInt(1)+1);
				Pstmt.setString(2, name2);
				Pstmt.executeUpdate();
				
				Pstmt = conn.prepareStatement(
						"INSERT INTO game_data (playerID, win, lose, winrate) VALUES (?,?,?,?);");
				Pstmt.setInt(1, getID.getInt(1)+1);
				Pstmt.setInt(2, 0);
				Pstmt.setInt(3, 1);
				Pstmt.setInt(4, 0);
				Pstmt.executeUpdate();
			}
			else{
				getID2 = stmt.executeQuery("select playerID from players_table where playername = '"+name2+"' limit 1");
				getID2.next();
				tempID = getID2.getInt(1);
				
				getData = stmt.executeQuery("select win, lose from game_data where playerID = "+tempID+" limit 1");
				getData.next();
				
				Pstmt2 = conn.prepareStatement("UPDATE game_data SET win = ?, lose = ?, winrate = ? WHERE playerID = ?");
				Pstmt2.setInt(1,getData.getInt(1));
				Pstmt2.setInt(2,getData.getInt(2)+1);
				Pstmt2.setFloat(3,(float) (getData.getInt(1)/(float) (getData.getInt(1)+getData.getInt(2)+1)));
				Pstmt2.setInt(4,tempID);
				Pstmt2.execute();
			}

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	
	}

}
