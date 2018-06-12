package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Rank;


public class Start extends Thread {
	int i;
	int width = 777,height = 604;
	
	JPanel BP = new JPanel(new GridBagLayout());
	GridBagConstraints gb = new GridBagConstraints();
	
	//Icon st = new ImageIcon(Start.class.getResource("start.png"));
	//static JButton start = new JButton("開始遊戲");
	JButton end = new JButton("結束遊戲");
	
	Game game;// = new Game();
	
	BufferedImage bg;
	ImageIcon background = new ImageIcon("resources/image/background.png");
	JLabel BG;
	JPanel BB = new JPanel();
	
	JLabel start;
	ImageIcon Bstart = new ImageIcon("resources/image/start2.png");
	JLabel option;
	ImageIcon Boption = new ImageIcon("resources/image/option2.png");
	
	Image IMG,IMG2,IMG3;
	
	JLabel rk = new JLabel();
	Rank rank = new Rank();
	
	public void run() {
		JFrame app = new JFrame();
		app.setSize(width, height);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setTitle("123");
		app.setResizable(false);  //無法調整大小
		app.setLocationRelativeTo(null);  //出現在螢幕正中央
		app.setLayout(null);
		
		
		//start.setContentAreaFilled(false); //透明按鈕
		/*start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.getContentPane().removeAll();  //清除app所有元件
				game = new Game();
				game.exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						game.go = 0;
						app.remove(game);
						app.add(BP,BorderLayout.SOUTH);
						app.repaint();
					}
				});
				app.add(game);
				game.setSize(app.getWidth(), app.getHeight());
				game.go = 0;
				app.revalidate();  //app加入新的元件或改變元件大小, 需要通知 container 做調整
				app.repaint();
			}
		});*/
		
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		BB.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				
			}
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				System.out.print(e.getX()+","+e.getY()+"\n");
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			
		});
		
		BB.setLayout(null);
		BB.setBounds(0, 0, width, height);
		
		Image img = background.getImage();
		IMG = img.getScaledInstance(width,height,java.awt.Image.SCALE_SMOOTH); //設定圖片大小為視窗大小
		BG = new JLabel(new ImageIcon(IMG));
		BG.setBounds(0, 0, width, height);
		BG.setOpaque(false);
		BB.add(BG);
		
		Image img2 = Bstart.getImage();
		IMG2 = img2.getScaledInstance(322,49,java.awt.Image.SCALE_SMOOTH);
		start = new JLabel(new ImageIcon(IMG2));
		start.setBounds(257, 413, 322, 49);
		start.setOpaque(false);
		
		JPanel Pstart = new JPanel();
		Pstart.setOpaque(false);
		Pstart.setBounds(257, 413, 322, 49);
		Pstart.add(start);
		Pstart.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				start.setVisible(true);
				Pstart.repaint();
			}
			public void mouseExited(MouseEvent e) {
				start.setVisible(false);
				Pstart.repaint();
			}
			public void mousePressed(MouseEvent e) {
				app.getContentPane().removeAll();
				game = new Game();
				game.exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						game.go = 0;
						app.remove(game);
						app.add(BB);
						start.setVisible(false);
						app.repaint();
					}
				});
				app.add(game);
				game.setSize(app.getWidth(), app.getHeight());
				game.go = 0;
				app.revalidate();
				app.repaint();
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		
		Image img3 = Boption.getImage();
		IMG3 = img3.getScaledInstance(345,60,java.awt.Image.SCALE_SMOOTH);
		option = new JLabel(new ImageIcon(IMG3));
		option.setBounds(258, 490, 345, 60);
		option.setOpaque(true);
		
		JPanel Poption = new JPanel();
		Poption.setOpaque(false);
		Poption.setBounds(258, 490, 345, 60);
		Poption.add(option);
		Poption.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				option.setVisible(true);
				//Poption.repaint();
			}
			public void mouseExited(MouseEvent e) {
				option.setVisible(false);
				//Poption.repaint();
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		
		BB.add(Pstart);
		BB.add(Poption);
		app.add(BB);
		start.setVisible(false);
		option.setVisible(false);
		
		rk.setBounds(5, 515, 50, 50);
		rk.setBackground(Color.RED);
		rk.setOpaque(true);
		JPanel R = new JPanel();
		R.setLayout(null);
		R.setBounds(60, 385, 200, 180);
		R.setBackground(Color.BLUE);
		R.setOpaque(true);
		R.setVisible(false);
		rk.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				rank = new Rank();
				rank.setBounds(0, 0, 200, 180);
				R.add(rank);
				R.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				R.setVisible(false);
				R.remove(rank);
				rank = null;
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		BB.add(rk);
		//BB.add(rank);
		//rank.setSize(200, 150);
		BB.add(R);
		
		app.setVisible(true);
	}

}