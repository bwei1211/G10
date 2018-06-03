package GUI;

import java.awt.Graphics;
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
