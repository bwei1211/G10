package GUI;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.Savedata;

public class Game extends JPanel implements MouseListener,MouseMotionListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x,y,go=0,turn=0;
	int i,j;
	Color color = Color.BLACK;
	
	JButton exit = new JButton("離開");
	//JButton back = new JButton("悔棋");
	
	//int loc[][] = new int[19][19];
	Locate locate[][] = new Locate[19][19];
	JPanel gaming = new JPanel();
	
	int lastx,lasty;
	//int stepx[] = new int[400];
	//int stepy[] = new int[400];
	int chesscount;
	
	Chess count[];
	
	//int commandback=0;
	
	int over=0;
	
	JLabel win_message = new JLabel();
	JPanel winpan = new JPanel();
	
	Font winfont = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	ImageIcon chessgod = new ImageIcon(getClass().getResource("/images/chessgod.png"));
	ImageIcon alphago = new ImageIcon(getClass().getResource("/images/alphago.jpg"));
	JLabel player1 = new JLabel(chessgod);
	JLabel player2;
	
	Image play2;
	
	String name1, name2;
	
	Savedata sd;
	
	public Game(String name1, String name2) {
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setLayout(null);
		
		gaming.setBounds(0, 0, 570, 570);
		gaming.setLayout(new GridLayout(19,19,0,0));
		gaming.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				locate[j][i] = new Locate(j,i);
				gaming.add(locate[j][i]);
			}
		}
		
		count = new Chess[400];
		
		p1.setBounds(570, 65, 200, 213);
		p2.setBounds(570, 277, 200, 213);
		player1.setBounds(575, 70, 190, 203);
		play2 = alphago.getImage();
		play2 = play2.getScaledInstance(200, 203, java.awt.Image.SCALE_SMOOTH);
		player2 = new JLabel(new ImageIcon(play2));
		player2.setBounds(570, 282, 200, 203);
		p1.add(player1);
		p2.add(player2);
		add(p1);
		add(p2);
		p1.setBackground(Color.RED);
		
		add(winpan);
		winpan.add(win_message,BorderLayout.EAST);
		winpan.setBounds(570, 0, 200, 65);
		winpan.setBackground(Color.LIGHT_GRAY);
		//win_message.setText("win");
		win_message.setFont(winfont);
		
		add(exit);
		exit.setBounds(570,490,200,80);
		/*add(back);
		back.addActionListener(this);
		back.setBounds(570,490,100,80);*/
		
		this.name1 = name1;
		this.name2 = name2;
		
		this.add(gaming);
		this.revalidate();
		this.repaint();
		Go();
	}
	
	public void Go() {
		repaint();
		go = 1;
	}
	
	public void paintComponent(Graphics g){
		
	}
	
	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		/*if(e.getSource()==back) {
			if(chesscount==0){
				JOptionPane.showMessageDialog(null,"已經是第一步了",JOptionPane.WARNING_MESSAGE);
			}
			//locate[stepx[chesscount]][stepy[chesscount]].back();
			if(turn==0) {
				turn = 1;
				color = Color.WHITE;
			}
			else {
				turn = 0;
				color = Color.BLACK;
			}
			commandback = 1;
			//count[chesscount] = null;
			
			locate[stepx[chesscount]][stepy[chesscount]].draw = 0;
			locate[stepx[chesscount]][stepy[chesscount]].val = 0;
			chesscount--;
			repaint();
		}*/
	}
	
	public class Locate extends JPanel implements MouseListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int x,y;
		Chess temp = null;
		//Chess count[] = new Chess[400];
		//int chesscount=0;
		int draw = 0;
		int val = 0;
		int index = 0;
		
		public Locate(int x, int y) {
			this.x = x;
			this.y = y;
			
			this.setBackground(new Color(255,187,6));
			
			
			addMouseListener(this);
		}

		public Locate(int x, int y, int draw) {
			this.x = x;
			this.y = y;
			this.draw = draw;
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(go==0) {
				drawback(g);
			}
			if(temp!=null) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));  //graphics透明度
				temp.draw(g);
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
			}
			/*for(i=0;i<chesscount;i++) {
				count[i].draw(g);
			}*/
			if(this.draw==1) {
				count[index].draw(g);
			}
			/*if(commandback==1) {
				commandback = 0;
				count[index] =  null;
			}*/
			/*if(this.draw==1) {
				count[chesscount].draw(g);
				if(turn==0) {
					turn = 1;
				}
				else {
					turn = 0;
				}
				chesscount++;
			}*/
		}
		
		public void mouseClicked(MouseEvent e) {
			
		}
		
		public void mouseEntered(MouseEvent e) {
			if(this.val==0&&over==0) {
				temp = new Chess(color);
				this.add(temp);
				repaint();
			}
		}
		
		public void mouseExited(MouseEvent e) {
			temp = null;
			repaint();
		}
		
		public void mousePressed(MouseEvent e) {
			if(this.val==0&&over==0){
				if(turn==0) {
					this.val = 1;
				}
				else {
					this.val = -1;
				}
				//count[chesscount++] = new Chess(x, y, color);
				//locate[x][y] = new Chess(x, y, color);
				index = chesscount;
				count[index] = new Chess(color);
				this.draw = 1;
				//lastx = x;
				//lasty = y;
				//stepx[chesscount] = x;
				//stepy[chesscount] = y;
				temp = null;
				//this.add(count[index]);
				repaint();
				CheckGame(this.x,this.y);
				if(turn==0) {
					turn = 1;
					color = Color.WHITE;
					p1.setBackground(Color.WHITE);
					p2.setBackground(Color.RED);
				}
				else {
					turn = 0;
					color = Color.BLACK;
					p2.setBackground(Color.WHITE);
					p1.setBackground(Color.RED);
				}
				chesscount++;
			}
		}
		
		public void mouseReleased(MouseEvent e) {
			
		}
		
		public void drawback(Graphics g) {
			g.setColor(Color.BLACK);
			if(x==0) {
				g.drawLine(15, 15, 30, 15);
			}
			else if(x==18) {
				g.drawLine(0, 15, 15, 15);
			}
			else {
				g.drawLine(0, 15, 30, 15);
			}
			if(y==0) {
				g.drawLine(15, 15, 15, 30);
			}
			else if(y==18) {
				g.drawLine(15, 0, 15, 15);
			}
			else {
				g.drawLine(15, 0, 15, 30);
			}
			if(x%6==3&&y%6==3) {
				drawpoint(g);
			}
		}
		
		public void drawpoint(Graphics g) {
			g.fillOval(11, 11, 8, 8);
		}
		
		public void back() {
			if(turn==0) {
				turn = 1;
				color = Color.WHITE;
			}
			else {
				turn = 0;
				color = Color.BLACK;
			}
			//count[chesscount].back = 1;
			count[chesscount] = null;
			this.draw = 0;
			this.val = 0;
			chesscount--;
			repaint();
		}
	}
	
	class Chess extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Color color;
		
		public Chess(Color color){
			this.color = color;
		}

		public void draw(Graphics g) {
			g.setColor(color);
			/*if(turn==0) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.WHITE);
			}*/
			g.fillOval(4, 4, 22, 22);
		}
	}

	public void CheckGame(int x, int y) {
		int win;
		if(turn==0) { //val = 1
			for(i=0;i<4;i++) {
				win = Check(x,y,1,i);
				if(win>=5) {
					//win_message.setText(name1+" win!");
					JOptionPane.showMessageDialog(null,"黑子勝利","訊息",JOptionPane.INFORMATION_MESSAGE);
					over = 1;
					sd = null;
					sd = new Savedata(name1, name2);
					break;
				}
			}
		}
		else { // val = -1
			for(i=0;i<4;i++) {
				win = Check(x,y,-1,i);
				if(win>=5) {
					//win_message.setText(name2+" win!");
					JOptionPane.showMessageDialog(null,"白子勝利","訊息",JOptionPane.INFORMATION_MESSAGE);
					sd = null;
					sd = new Savedata(name2, name1);
					over = 1;
					break;
				}
			}
		}
	}
	
	public int Check(int x, int y, int val, int choose) {
		int count = -1;
		int x2 = x;
		int y2 = y;
		
		switch(choose) {
		
		case 0:
			while(x+1<20&&y+1<20) {
				if(locate[x][y].val==val) {
					count++;
					x++;
					y++;
				}
				else {
					break;
				}
			}
			while(x2-1>-1&&y2-1>-1) {
				if(locate[x2][y2].val==val) {
					count++;
					x2--;
					y2--;
				}
				else {
					break;
				}
			}
			break;
			
		case 1:
			while(x+1<20) {
				if(locate[x][y].val==val) {
					count++;
					x++;
				}
				else {
					break;
				}
			}
			while(x2-1>-1) {
				if(locate[x2][y2].val==val) {
					count++;
					x2--;
				}
				else {
					break;
				}
			}
			break;
			
		case 2:
			while(x+1<20&&y-1>-1) {
				if(locate[x][y].val==val) {
					count++;
					x++;
					y--;
				}
				else {
					break;
				}
			}
			while(x2-1>-1&&y2+1<20) {
				if(locate[x2][y2].val==val) {
					count++;
					x2--;
					y2++;
				}
				else {
					break;
				}
			}
			break;
			
		case 3:
			while(y+1<20) {
				if(locate[x][y].val==val) {
					count++;
					y++;
				}
				else {
					break;
				}
			}
			while(y2-1>-1) {
				if(locate[x2][y2].val==val) {
					count++;
					y2--;
				}
				else {
					break;
				}
			}
			break;
			
		}
		
		return count;
	}
	
}
