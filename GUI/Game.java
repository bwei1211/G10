package GUI;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JPanel implements MouseListener,MouseMotionListener{
	int x,y,go=0;
	int i,j;
	//Draw d = null;
	//Draw step[] = new Draw[1000];
	//Draw ing = null;
	
	JButton exit = new JButton("離開");
	JButton back = new JButton("悔棋");
	
	int loc[][] = new int[19][19];
	Locate locate[][] = new Locate[19][19];
	JPanel gaming = new JPanel();
	
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
		x = e.getX();
		y = e.getY();
		System.out.println(x+","+y);
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
	class Locate extends JPanel implements MouseListener {
		int x,y;
		Color color;
		Locate temp = null;
		
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
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(go==0) {
				drawback(g);
			}
			if(temp!=null) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));  //設置透明度
				temp.draw(g);
			}
		}
		
		public void mouseClicked(MouseEvent e) {
			
		}
		
		public void mouseEntered(MouseEvent e) {
			 temp = new Locate(x,y,color);
			 repaint();
		}
		
		public void mouseExited(MouseEvent e) {
			temp = null;
			repaint();
		}
		
		public void mousePressed(MouseEvent e) {
			
		}
		
		public void mouseReleased(MouseEvent e) {
			
		}
		
		public void draw(Graphics g) {
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
	}
	
}
