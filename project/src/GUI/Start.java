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
	//static JButton start = new JButton("�}�l�C��");
	JButton end = new JButton("�����C��");
	
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
	
	JLabel rk;
	ImageIcon Brank = new ImageIcon("resources/image/rank.png");
	Rank rank = new Rank();
	
	Option op = new Option();
	
	public void run() {
		JFrame app = new JFrame();
		app.setSize(width, height);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setTitle("123");
		app.setResizable(false);  //�L�k�վ�j�p
		app.setLocationRelativeTo(null);  //�X�{�b�ù�������
		app.setLayout(null);
		
		
		//start.setContentAreaFilled(false); //�z�����s
		/*start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.getContentPane().removeAll();  //�M��app�Ҧ�����
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
				app.revalidate();  //app�[�J�s������Χ��ܤ���j�p, �ݭn�q�� container ���վ�
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
		IMG = img.getScaledInstance(width,height,java.awt.Image.SCALE_SMOOTH); //�]�w�Ϥ��j�p�������j�p
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
				game = new Game(op.player1, op.player2);
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
				app.getContentPane().removeAll();
				op.exit.addMouseListener(new MouseListener() {
					public void mouseClicked(MouseEvent e) {
					}
					public void mouseEntered(MouseEvent e) {
					}
					public void mouseExited(MouseEvent e) {
					}
					public void mousePressed(MouseEvent e) {
						app.remove(op);
						app.add(BB);
						option.setVisible(false);
						app.revalidate();
						app.repaint();
					}
					public void mouseReleased(MouseEvent e) {
					}
				});
				app.add(op);
				op.setSize(app.getWidth(), app.getHeight());
				app.revalidate();
				app.repaint();
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		
		BB.add(Pstart);
		BB.add(Poption);
		app.add(BB);
		start.setVisible(false);
		option.setVisible(false);
		
		Image img4 = Brank.getImage();
		rk = new JLabel(new ImageIcon(img4.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH)));
		rk.setBounds(5, 515, 50, 50);
		//rk.setBackground(Color.RED);
		rk.setOpaque(true);
		JPanel R = new JPanel();
		R.setLayout(null);
		R.setBounds(60, 385, 200, 180);
		//R.setBackground(Color.BLUE);
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