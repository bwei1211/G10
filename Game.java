package GUI;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Game extends JPanel implements MouseListener,MouseMotionListener{
	int x,y,go=0;
	Draw d = null;
	Draw step[] = new Draw[1000];
	Draw ing = null;
	
	JButton exit = new JButton("ย๗ถ}");
	JButton back = new JButton("ฎฌดั");
	
	public Game() {
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setLayout(null);
		
		d = new Board();
		repaint();
		
		add(exit);
		exit.setBounds(670,490,100,80);
		add(back);
		back.setBounds(570,490,100,80);
		this.revalidate();
		this.repaint();
		Go();
		Gaming ing = new Gaming();
	}
	public void Go() {
		go = 1;
	}
	
	public void paintComponent(Graphics g){
		if(go==0) {
			d.draw(g);
		}
		else {
			
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
	
}

class Gaming {
	int loc[][] = new int[19][19];
	GridBagConstraints gb = new GridBagConstraints();
	Locate locate[][] = new Locate[19][19];
	public Gaming() {
		JPanel ing = new JPanel();
		ing.setLayout(new GridBagLayout());
		ing.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		ing.setBounds(0, 0, 570, 570);
		gb.fill = GridBagConstraints.BOTH;
		gb.gridheight = 1;
		gb.gridwidth = 1;
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				locate[i][j] = new Locate(i,j);
				gb.gridx = i;
				gb.gridy = j;
				ing.add(locate[i][j], gb);
			}
		}
	}
	
	class Locate extends JPanel implements MouseListener {
		int x,y;
		
		public Locate(int x, int y) {
			this.x = x;
			this.y = y;
			addMouseListener(this);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}
		
		public void mouseClicked(MouseEvent e) {
			
		}
		
		public void mouseEntered(MouseEvent e) {
			
		}
		
		public void mouseExited(MouseEvent e) {
			
		}
		
		public void mousePressed(MouseEvent e) {
			
		}
		
		public void mouseReleased(MouseEvent e) {
			
		}
		
		class DrawChess {
			int x,y;
			Color color;
			public DrawChess(int x, int y, Color color) {
				this.x = x;
				this.y = y;
				this.color = color;
			}
			public void draw(Graphics g) {
				g.setColor(color);
				g.fillOval(x-10, y-10, 20, 20);
			}
		}
	}
}
