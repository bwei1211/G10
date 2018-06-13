package data;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rank extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel rank1[] = new JLabel[10];
	JLabel rank2[] = new JLabel[10];
	JLabel rank3[] = new JLabel[10];
	JLabel rank4[] = new JLabel[10];
	JLabel rank5[] = new JLabel[10];
	
	JPanel rk1[] = new JPanel[10];
	JPanel rk2[] = new JPanel[10];
	JPanel rk3[] = new JPanel[10];
	JPanel rk4[] = new JPanel[10];
	JPanel rk5[] = new JPanel[10];
	
	JLabel A = new JLabel();
	JLabel B = new JLabel();
	JLabel C = new JLabel();
	JLabel D = new JLabel();
	
	
	public Rank() {
		
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		this.setOpaque(true);
		
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
			
			
			ResultSet rs = stmt.executeQuery("select playername , g.win, lose, winrate " +
							"from players_table p, game_data g where p.playerID = g.playerID " + 
							"ORDER BY winrate DESC");
			
			
			int i=0;
			
			String str=new String();
			
			A.setText("名次");
			B.setText("玩家");
			C.setText("勝    敗");
			D.setText("勝率");
			
			A.setBounds(15, 0, 30, 40);
			B.setBounds(60, 0, 70, 40);
			C.setBounds(120, 0, 50, 40);
			D.setBounds(170, 0, 30, 40);
			
			A.setOpaque(false);
			B.setOpaque(false);
			C.setOpaque(false);
			D.setOpaque(false);
			
			A.setForeground(Color.WHITE);
			B.setForeground(Color.WHITE);
			C.setForeground(Color.WHITE);
			D.setForeground(Color.WHITE);
			
			add(A);
			add(B);
			add(C);
			add(D);
			
			while (rs.next()&&i<5) {
				rank1[i] = new JLabel();
				rank2[i] = new JLabel();
				rank3[i] = new JLabel();
				rank4[i] = new JLabel();
				rank5[i] = new JLabel();
				
				rk1[i] = new JPanel();
				rk2[i] = new JPanel();
				rk3[i] = new JPanel();
				rk4[i] = new JPanel();
				rk5[i] = new JPanel();
				
				str=String.format("%02d", i+1);
				rank1[i].setText(str);
				rank1[i].setForeground(Color.CYAN);
				
				str=String.format("%10s", rs.getString("playername"));
				rank2[i].setText(str);
				rank2[i].setForeground(Color.WHITE);
				
				str=String.format("%02d", rs.getInt("win"));
				rank3[i].setText(str);
				rank3[i].setForeground(Color.GREEN);
				
				str=String.format("%02d", rs.getInt("lose"));
				rank4[i].setText(str);
				rank4[i].setForeground(Color.RED);
				
				str=String.format("%.0f", rs.getFloat("winrate")*100)+"%";
				rank5[i].setText(str);
				rank5[i].setForeground(Color.WHITE);
				
				/*rank1[i].setBounds(10, 20 + i*30, 20, 40);
				rank2[i].setBounds(40, 20 + i*30, 80, 40);
				rank3[i].setBounds(120, 20 + i*30, 25, 40);
				rank4[i].setBounds(145, 20 + i*30, 25, 40);
				rank5[i].setBounds(170, 20 + i*30, 30, 40);*/
				
				rank1[i].setOpaque(true);
				rank2[i].setOpaque(true);
				rank3[i].setOpaque(true);
				rank4[i].setOpaque(true);
				rank5[i].setOpaque(true);
				rank1[i].setBackground(Color.DARK_GRAY);
				rank2[i].setBackground(Color.DARK_GRAY);
				rank3[i].setBackground(Color.DARK_GRAY);
				rank4[i].setBackground(Color.DARK_GRAY);
				rank5[i].setBackground(Color.DARK_GRAY);
				
				rk1[i].setBounds(15, 20 + i*30, 20, 40);
				rk2[i].setBounds(35, 20 + i*30, 80, 40);
				rk3[i].setBounds(115, 20 + i*30, 25, 40);
				rk4[i].setBounds(140, 20 + i*30, 25, 40);
				rk5[i].setBounds(165, 20 + i*30, 30, 40);
				
				rk1[i].setOpaque(false);
				rk2[i].setOpaque(false);
				rk3[i].setOpaque(false);
				rk4[i].setOpaque(false);
				rk5[i].setOpaque(false);
				
				rk1[i].add(rank1[i]);
				rk2[i].add(rank2[i]);
				rk3[i].add(rank3[i]);
				rk4[i].add(rank4[i]);
				rk5[i].add(rank5[i]);
				
				add(rk1[i]);
				add(rk2[i]);
				add(rk3[i]);
				add(rk4[i]);
				add(rk5[i]);
				i++;
			}
			
			
			
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		this.revalidate();
		this.repaint();
	}
	
}
