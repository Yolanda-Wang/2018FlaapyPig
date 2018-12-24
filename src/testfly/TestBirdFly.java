package testfly;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import testfly.Main;

public class TestBirdFly extends JPanel {
	Bird bird;
//	Bird [] bird=new Bird[5];
	Column column1, column2; 
	Ground ground;
	BufferedImage background;
	public static boolean gameOver;
	public static boolean started;
	BufferedImage gameoverImg;
	boolean flag = true;
	public static int count = 0;
	//分数
	public static int score;
	/** 初始化 BirdGame 的属性变量 */
	public TestBirdFly() throws Exception {
		score = 0;
		bird = new Bird();
		column1 = new Column(1);
		column2 = new Column(2);
		ground = new Ground();
		gameOver=false;
		background = ImageIO.read(
			new File("I:\\eclipse-workplace\\FF\\Image\\birdbg.png")); 
		gameoverImg= ImageIO.read(
				new File("I:\\eclipse-workplace\\FF\\Image\\birdgameover.png"));
	}
	
	public  TestBirdFly(int s) throws Exception {
		score=s;
		bird = new Bird();
		column1 = new Column(1);
		column2 = new Column(2);
		ground = new Ground();
		gameOver=false;
		background = ImageIO.read(
			new File("I:\\eclipse-workplace\\FF\\Image\\birdbg.png")); 
		gameoverImg= ImageIO.read(
				new File("I:\\eclipse-workplace\\FF\\Image\\birdgameover.png"));
		
		
		
	}
	
	/** "重写(修改)"paint方法实现绘制 */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);
		g.drawImage(column1.image, 
			column1.x-column1.width/2, 
			column1.y-column1.height/2, null);
		g.drawImage(column2.image, 
			column2.x-column2.width/2, 
			column2.y-column2.height/2, null);
		//在paint方法中添加绘制分数的算法
		Font f = new Font(Font.SANS_SERIF,
				Font.BOLD, 40);
		g.setFont(f);
		g.drawString(""+score, 40, 60);
		g.setColor(Color.red);
		g.drawString(""+score, 40-3, 60-3);
		
		g.drawImage(ground.image, ground.x, 
			ground.y, null);
		if (gameOver){
			count++;
			/*if(count==1)
			{
				Main.frame.dispose();
			}
			else
			{
				mainBomb.a.dispose();
			}
	        mainBomb app = new mainBomb(count,score); 
	        JOptionPane.showMessageDialog(app, "复活~", "确认复活", JOptionPane.INFORMATION_MESSAGE);
	        Main.frame.hide();
	        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        app.setVisible(true);
	        app.setLocationRelativeTo(null);*/
	 //       boolean flag2 = true;
	  //      	try {
	//				if(app.isWin()) {
						
//					}
//				} catch (Exception e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        JOptionPane.showMessageDialog(app, "复活成功", "继续游戏", JOptionPane.INFORMATION_MESSAGE);
//	        app.hide();
	        return;
		}
		//旋转(rotate)绘图坐标系，是API方法
		Graphics2D g2 = (Graphics2D)g;
		g2.rotate(-bird.alpha, bird.x, bird.y);
		g.drawImage(bird.image, 
			bird.x-bird.width/2, 
			bird.y-bird.height/2, null);
		g2.rotate(bird.alpha, bird.x, bird.y);
	}//paint方法的结束
	//BirdGame中添加方法action()
	public void action() throws Exception {
		MouseListener l=new MouseAdapter(){
			//Mouse 老鼠 Pressed按下
			public void mousePressed(                      
					MouseEvent e){
				//鸟向上飞扬
				started=true;
				bird.flappy();
				
			}
		};
		//将l挂接到当前的面板（game）上
		addMouseListener(l);
		while(flag){
			
			
			//计分逻辑
			if(!gameOver||started){
				//System.out.println("mmmm1");

				ground.step();
				column1.step();
				column2.step();
				bird.step();
				//System.out.println("mmmm2");

			}
			bird.fly();
			ground.step();
			
			if(bird.hit(ground) ||bird.hit(column1)||bird.hit(column2)){
				gameOver=true;
				flag = false;
			}
			bird.fly();
			if (!gameOver&&(bird.x==column1.x||bird.x==column2.x)){
				score++;
			}repaint();
			
			Thread.sleep(1000/60);
		}
	}
}







