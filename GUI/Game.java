package GUI;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Game extends JPanel implements MouseListener,MouseMotionListener, ActionListener{
	int x,y,go=0,turn=0;
	int i,j;
	Color color = Color.BLACK;
	
	JButton exit = new JButton("���}");
	JButton back = new JButton("����");
	
	int loc[][] = new int[19][19];
	Locate locate[][] = new Locate[19][19];
	JPanel gaming = new JPanel();
	
	int lastx,lasty;
	int stepx[] = new int[400];
	int stepy[] = new int[400];
	int chesscount;
	
	Locate temp = null;
	
	public Game() {
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
		
		add(exit);
		exit.setBounds(670,490,100,80);
		add(back);
		back.addActionListener(this);
		back.setBounds(570,490,100,80);
		
		
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
		if(go==0) {
			
		}
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
		if(e.getSource()==back) {
			locate[stepx[chesscount]][stepy[chesscount]].back();
		}
	}
	
	class Locate extends JPanel implements MouseListener {
		int x,y;
		Color color;
		Chess temp = null;
		Chess count[] = new Chess[400];
		//int chesscount=0;
		int draw = 0;
		int val = 0;
		
		public Locate(int x, int y) {
			this.x = x;
			this.y = y;
			
			this.setBackground(new Color(255,187,6));
			
			addMouseListener(this);
		}

		public Locate(int x, int y, Color color) {
			this.x = x;
			this.y = y;
			this.color = color;
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
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));  //�]�m�z����
				temp.draw(g);
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
			}
			/*for(i=0;i<chesscount;i++) {
				if(count[i].back==0) {
					count[i].draw(g);
				}
			}*/
			if(this.draw==1) {
				this.drawChess(g);
			}
		}
		
		public void mouseClicked(MouseEvent e) {
			
		}
		
		public void mouseEntered(MouseEvent e) {
			if(this.val==0) {
				temp = new Chess(x,y);
				repaint();
			}
		}
		
		public void mouseExited(MouseEvent e) {
			temp = null;
			repaint();
		}
		
		public void mousePressed(MouseEvent e) {
			if(turn==0) {
				this.val = 1;
				color = Color.BLACK;
			}
			else {
				this.val = -1;
				color = Color.WHITE;
			}
			//count[chesscount++] = new Chess(x, y, color);
			//locate[x][y] = new Chess(x, y, color);
			this.draw = 1;
			//lastx = x;
			//lasty = y;
			stepx[chesscount] = x;
			stepy[chesscount++] = y;
			temp = null;
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
			
		}
		
		public void drawChess(Graphics g) {
			if(turn==0) {
				turn = 1;
			}
			else {
				turn = 0;
			}
			g.setColor(color);
			g.fillOval(4, 4, 22, 22);
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
			}
			else {
				turn = 0;
			}
			//count[chesscount].back = 1;
			this.draw = 0;
			chesscount--;
			repaint();
		}
	}
	
	class Chess extends Locate implements MouseListener {
		Color color;
		public Chess(int x, int y, Color color) {
			super(x, y);
			this.color = color;
		}
		
		public Chess(int x, int y) {
			super(x, y);
		}

		public void draw(Graphics g) {
			//g.setColor(color);
			if(turn==0) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.WHITE);
			}
			g.fillOval(4, 4, 22, 22);
		}
	}
	
}
