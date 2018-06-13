package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.Rank;


public class Start extends Thread {
	int i;
	int width = 777,height = 604;
	
	JPanel BP = new JPanel(new GridBagLayout());
	GridBagConstraints gb = new GridBagConstraints();
	
	//Icon st = new ImageIcon(Start.class.getResource("start.png"));
	//JButton start = new JButton("開始遊戲");
	//JButton end = new JButton("結束遊戲");
	
	Game game;// = new Game();
	
	BufferedImage bg;
	ImageIcon background = new ImageIcon(getClass().getResource("/images/background.png"));
	JLabel BG;
	JPanel BB = new JPanel();
	
	JLabel start;
	ImageIcon Bstart = new ImageIcon(getClass().getResource("/images/start2.png"));
	JLabel option;
	ImageIcon Boption = new ImageIcon(getClass().getResource("/images/option2.png"));
	
	Image IMG,IMG2,IMG3;
	
	JLabel rk;
	ImageIcon Brank = new ImageIcon(getClass().getResource("/images/rank.png"));
	Rank rank = new Rank();
	
	Option op = new Option();
	
	public void run() {
		JFrame app = new JFrame();
		app.setSize(width, height);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setTitle("五子棋");
		app.setResizable(false);  //關閉調整大小
		app.setLocationRelativeTo(null);  //將視窗設置到正中央
		app.setLayout(null);
		
		
		//start.setContentAreaFilled(false); //按鈕設置成透明
		/*start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.getContentPane().removeAll();  //移除app視窗的所有元件
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
				app.revalidate();  //對於app加入新的元件或改變元件大小去做調整
				app.repaint();
			}
		});*/
		
		/*end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});*/
		
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
		IMG = img.getScaledInstance(width,height,java.awt.Image.SCALE_SMOOTH); //將圖片設置為想要的大小
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
						op.player1 = op.p1.getText();
						op.player2 = op.p2.getText();
						if(op.player1.length()==0||op.player2.length()==0) {
							JOptionPane.showMessageDialog(null,"請輸入玩者名稱","提示", JOptionPane.WARNING_MESSAGE);
						}
						else if(op.player1.equals(op.player2)){
							JOptionPane.showMessageDialog(null,"請輸入不同的玩者名稱","提示", JOptionPane.WARNING_MESSAGE);
						}
						else {
							app.remove(op);
							app.add(BB);
							option.setVisible(false);
							app.revalidate();
							app.repaint();
						}
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