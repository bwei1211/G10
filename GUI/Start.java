package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Start{
	int i;
	static int width = 777,height = 604;
	
	static JPanel BP = new JPanel(new GridBagLayout());
	static GridBagConstraints gb = new GridBagConstraints();
	
	Icon st = new ImageIcon(Start.class.getResource("start.png"));
	static JButton start = new JButton("開始遊戲");
	static JButton end = new JButton("結束遊戲");
	
	static Game game;// = new Game();

	public static void main(String[] args) {
		JFrame app = new JFrame();
		app.setSize(width, height);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setTitle("123");
		app.setResizable(false);  //無法調整大小
		app.setLocationRelativeTo(null);  //出現在螢幕正中央
		//app.setLayout(null);
		
		start.setContentAreaFilled(false); //透明按鈕
		start.addActionListener(new ActionListener() {
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
		});
		
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
		gb.gridx = 0;
		gb.gridy = 0;
		gb.gridheight = 1;
		gb.gridwidth = 1;
		gb.fill = GridBagConstraints.BOTH;
		gb.anchor = GridBagConstraints.CENTER;
		BP.add(start,gb);
		gb.gridx = 0;
		gb.gridy = 2;
		gb.gridheight = 1;
		gb.gridwidth = 1;
		BP.add(end,gb);
		//BP.setBounds(width/2-100, 0, 200, height);
		//app.add(start);
		app.add(BP,BorderLayout.SOUTH);
		//start.setBounds(width/2-100, height/2-30, 200, 60);
		app.setVisible(true);
	}

}