package data;

import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Readtest {
	
	static JLabel rank1[] = new JLabel[10];
	static JLabel rank2[] = new JLabel[10];
	static JLabel rank3[] = new JLabel[10];
	static JLabel rank4[] = new JLabel[10];
	
	static JLabel A = new JLabel();
	static JLabel B = new JLabel();
	static JLabel C = new JLabel();
	static JLabel D = new JLabel();
	
	static JPanel P = new JPanel();
	
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
			
			//ResultSet Pname = stmt.executeQuery("select rank.playername" + " from players_table rank");
			//ResultSet Pname = stmt.getResultSet();
			
			//ResultSet Pdata = stmt.executeQuery("select rank.win, lose, winrate" + " from playerdata rank");
			//ResultSet Pdata = stmt.getResultSet();
			
			/*ResultSet rs = stmt.executeQuery("select players_table.playername , game_data.win, lose, winrate " + 
						"from players_table, game_data where players_table.playerID=game_data.playerID");*/
			/*ResultSet test = stmt.executeQuery(
					"SELECT players_table.playername, game_data.win, lose, winrate, rank FROM (SELECT players_table.playername, game_data.win, lose, winrate, "+
					"@curRank := IF(@prevRank = winrate, @curRank, @incRank) AS rank, " + 
					"@incRank := @incRank + 1, @prevRank := winrate FROM players_table, game_data where players_table.playerID=game_data.playerID, " + 
					"(SELECT @curRank :=0, @prevRank := NULL, @incRank := 1 ) r ORDER BY winrate) s");*/
			
			ResultSet test2 = stmt.executeQuery("SELECT playerID, win, lose, winrate, rank FROM" + 
					"(SELECT playerID, win, lose, winrate, " + 
					"@curRank := IF(@prevRank = winrate, @curRank, @incRank) AS rank, " + 
					"@incRank := @incRank + 1, " + 
					"@prevRank := winrate " + 
					"FROM game_data g, (" + 
					"SELECT @curRank :=0, @prevRank := NULL, @incRank := 1" + 
					") r ORDER BY winrate) w");
			
			/*ResultSet rs2 = stmt.executeQuery("SELECT players_table.playername , game_data.playerID, win, lose, winrate, rank "+ 
					"FROM players_table,(SELECT playerID, win, lose, winrate, " + 
					"@curRank := IF(@prevRank = winrate, @curRank, @incRank) AS rank, " + 
					"@incRank := @incRank + 1, " + 
					"@prevRank := winrate " + 
					"FROM game_data g, (" + 
					"SELECT @curRank :=0, @prevRank := NULL, @incRank := 1" + 
					") r ORDER BY winrate) w where players_table.playerID = game_data.playerID");*/
			
			ResultSet rs = stmt.executeQuery("select playername , g.win, lose, winrate " +
							"from players_table p, game_data g where p.playerID = g.playerID ORDER BY winrate DESC");
			
			
			int i=0;
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			JFrame f = new JFrame("JLabel1");
			f.setSize(300, 200);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			Container cp = f.getContentPane();
			cp.setLayout(null);
			String[] str=new String[100];
			A.setText("排名");
			B.setText("玩家");
			C.setText("勝  敗");
			D.setText("勝率");
			A.setBounds(10, 0, 30, 40);
			B.setBounds(60, 0, 70, 40);
			C.setBounds(120, 0, 50, 40);
			D.setBounds(170, 0, 30, 40);
			cp.add(A);
			cp.add(B);
			cp.add(C);
			cp.add(D);
			/*while (rs.next()) {
				rank1[i] = new JLabel();
				rank2[i] = new JLabel();
				rank3[i] = new JLabel();
				rank4[i] = new JLabel();
				
				str[i]=String.format("%02d", i+1);
				rank1[i].setText(str[i]);
				str[i]=String.format("%10s", rs.getString("playername"));
				rank2[i].setText(str[i]);
				str[i]=String.format("%02d  %02d", rs.getInt("win"), rs.getInt("lose"));
				rank3[i].setText(str[i]);
				str[i]=String.format("%.2f", rs.getFloat("winrate"));
				rank4[i].setText(str[i]);
				cp.add(rank1[i]);
				cp.add(rank2[i]);
				cp.add(rank3[i]);
				cp.add(rank4[i]);
				rank1[i].setBounds(20, 20 + i*30, 20, 40);
				rank2[i].setBounds(40, 20 + i*30, 80, 40);
				rank3[i].setBounds(120, 20 + i*30, 50, 40);
				rank4[i].setBounds(170, 20 + i*30, 30, 40);
				i++;
			}*/
			while (rs.next()) {
				rank1[i] = new JLabel();
				rank2[i] = new JLabel();
				rank3[i] = new JLabel();
				rank4[i] = new JLabel();
				
				str[i]=String.format("%02d", i+1);
				rank1[i].setText(str[i]);
				str[i]=String.format("%10s", rs.getString("playername"));
				rank2[i].setText(str[i]);
				str[i]=String.format("%02d  %02d", rs.getInt("win"), rs.getInt("lose"));
				rank3[i].setText(str[i]);
				str[i]=String.format("%.2f", rs.getFloat("winrate"));
				rank4[i].setText(str[i]);
				cp.add(rank1[i]);
				cp.add(rank2[i]);
				cp.add(rank3[i]);
				cp.add(rank4[i]);
				rank1[i].setBounds(20, 20 + i*30, 20, 40);
				rank2[i].setBounds(40, 20 + i*30, 80, 40);
				rank3[i].setBounds(120, 20 + i*30, 50, 40);
				rank4[i].setBounds(170, 20 + i*30, 30, 40);
				i++;
			}
			
			
			
			
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

}
