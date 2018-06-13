package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sound.PlayBGM;

public class Option extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon X = new ImageIcon(getClass().getResource("/images/X.png"));
	JLabel exit;
	
	String player1 = "player1";
	String player2 = "player2";
	
	JTextField p1 = new JTextField("player1",10);
	JTextField p2 = new JTextField("player2",10);
	
	JLabel P1 = new JLabel();
	JLabel P2 = new JLabel();
	
	Font f = new Font(Font.SERIF, Font.PLAIN, 50);
	Font f2 = new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 70);
	
	ImageIcon bgm1 = new ImageIcon(getClass().getResource("/images/check1.png"));
	ImageIcon bgm2 = new ImageIcon(getClass().getResource("/images/check2.png"));
	JLabel BGM;
	JLabel BGM2;
	JLabel BGMtext = new JLabel();
	
	Image pro;
	
	boolean closeBGM = false;
	
	public Option() {
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		Image imgX = X.getImage();
		exit = new JLabel(new ImageIcon(imgX.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH)));
		exit.setBounds(712, 15, 50, 50);
		add(exit);
		
		p1.setBounds(300, 50, 300, 80);
		p1.setFont(new Font(Font.SERIF, Font.PLAIN, 40));
		p1.setHorizontalAlignment(JTextField.RIGHT);  //文字靠右
		p1.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {
			}
			public void keyReleased(KeyEvent arg0) {
			}
			public void keyTyped(KeyEvent arg0) {
				//player1 = p1.getText();
			}
		});
		add(p1);
		
		p2.setBounds(300, 150, 300, 80);
		p2.setFont(new Font(Font.SERIF, Font.PLAIN, 40));
		p2.setHorizontalAlignment(JTextField.RIGHT);
		p2.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {
			}
			public void keyReleased(KeyEvent arg0) {
			}
			public void keyTyped(KeyEvent arg0) {
				//player2 = p2.getText();
			}
		});
		add(p2);
		
		pro = bgm1.getImage();
		BGM = new JLabel(new ImageIcon(pro.getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH)));
		BGM.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
				closeBGM = true;
				setbgm();
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		BGM.setBounds(50, 350, 100, 100);
		add(BGM);
		
		pro = bgm2.getImage();
		BGM2 = new JLabel(new ImageIcon(pro.getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH)));
		BGM2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
				closeBGM = false;
				setbgm();
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		BGM2.setBounds(50, 350, 100, 100);
		
		P1.setFont(f);
		P2.setFont(f);
		P1.setText("Player1 :");
		P2.setText("Player2 :");
		P1.setForeground(Color.RED);
		P2.setForeground(Color.BLUE);
		P1.setBounds(75, 50, 200, 80);
		P2.setBounds(75, 150, 200, 80);
		add(P1);
		add(P2);
		
		BGMtext.setFont(f);
		BGMtext.setText("關閉音樂");
		BGMtext.setForeground(Color.YELLOW);
		BGMtext.setBounds(170, 340, 200, 100);
		add(BGMtext);
	}

	protected void setbgm() {
		if(closeBGM){
			remove(BGM);
			add(BGM2);
			PlayBGM.CloseVolume();
		}
		else{
			remove(BGM2);
			add(BGM);
			PlayBGM.OpenVolume();
		}
		this.revalidate();
		this.repaint();
	}
}
