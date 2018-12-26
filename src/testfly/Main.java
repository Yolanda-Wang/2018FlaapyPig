package testfly;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	//public static JFrame[] frame=new JFrame[5];
	public static JFrame frame0;
	public static JFrame frame1;
	public static JFrame frame2;
	public static JFrame frame3;
	public static JFrame frame4;

	public static int count = 0;
	public static void main(String[] args)
			throws Exception {
			frame0 = new JFrame();

			frame0.setTitle("flappy pig");;
			TestBirdFly []game = new TestBirdFly[5];//扫雷有4次 所以flaapy有5次
			game[0]=new TestBirdFly();
			frame0.add(game[0]);
			frame0.setSize(440, 670);
			frame0.setLocationRelativeTo(null);
			frame0.setDefaultCloseOperation(
					JFrame.EXIT_ON_CLOSE);
			frame0.setVisible(true);
			game[0].action();
			frame0.dispose();
			count++;
			
			mainBomb []app = new mainBomb[5];
			app[0]=new mainBomb(count,game[0].score);
	        JOptionPane.showMessageDialog(app[0], "复活~", "确认复活", JOptionPane.INFORMATION_MESSAGE);
	        frame0.hide();
	        app[0].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        app[0].setVisible(true);
	        app[0].setLocationRelativeTo(null);

			int win=app[0].win;
			System.out.println(win);
			
			while(win==0) {			
				win=app[0].win;
				System.out.println(app[0].win);}

			frame1=new JFrame();
			int a=count-1;
			game[count]=new TestBirdFly(game[a].score);
			frame1.add(game[count]);
			frame1.setSize(440, 670);
			frame1.setLocationRelativeTo(null);
			app[a].hide();
			frame1.setDefaultCloseOperation(
					JFrame.EXIT_ON_CLOSE);
			frame1.setVisible(true);
			System.out.println("fly");
			game[count].action();
			System.out.println(count);

			System.out.println("flyok");

			count++;

			app[count] = new mainBomb(count,game[a].score); 
	        JOptionPane.showMessageDialog(app[count], "复活~", "确认复活", JOptionPane.INFORMATION_MESSAGE);
	        frame1.hide();
	        app[count].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        app[count].setVisible(true);
	        app[count].setLocationRelativeTo(null);
	        
	        win=0;
	        while(win==0) {			
				win=app[count].win;
				System.out.println(app[count].win);}
	        frame2=new JFrame();
			game[count]=new TestBirdFly(game[a].score);
			frame2.add(game[count]);
			frame2.setSize(440, 670);
			frame2.setLocationRelativeTo(null);
			app[a].hide();
			frame2.setDefaultCloseOperation(
					JFrame.EXIT_ON_CLOSE);
			frame2.setVisible(true);
			System.out.println("fly");
			game[count].action();
			System.out.println(count);

			System.out.println("flyok");

			count++;

			app[count] = new mainBomb(count,game[a].score); 
	        JOptionPane.showMessageDialog(app[count], "复活~", "确认复活", JOptionPane.INFORMATION_MESSAGE);
	        frame2.hide();
	        app[count].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        app[count].setVisible(true);
	        app[count].setLocationRelativeTo(null);
	        win=0;
	        while(win==0) {			
				win=app[count].win;
				System.out.println(app[count].win);}
	        
	        frame3=new JFrame();
			game[count]=new TestBirdFly(game[a].score);
			frame3.add(game[count]);
			frame3.setSize(440, 670);
			frame3.setLocationRelativeTo(null);
			app[a].hide();
			frame3.setDefaultCloseOperation(
					JFrame.EXIT_ON_CLOSE);
			frame3.setVisible(true);
			System.out.println("fly");
			game[count].action();
			System.out.println(count);

			System.out.println("flyok");

			count++;

			app[count] = new mainBomb(count,game[a].score); 
	        JOptionPane.showMessageDialog(app[count], "复活~", "确认复活", JOptionPane.INFORMATION_MESSAGE);
	        frame3.hide();
	        app[count].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        app[count].setVisible(true);
	        app[count].setLocationRelativeTo(null);
	        win=0;
	        while(win==0) {			
				win=app[count].win;
				System.out.println(app[count].win);}

	        frame4=new JFrame();
			game[count]=new TestBirdFly(game[a].score);
			frame4.add(game[count]);
			frame4.setSize(440, 670);
			frame4.setLocationRelativeTo(null);
			app[a].hide();
			frame4.setDefaultCloseOperation(
					JFrame.EXIT_ON_CLOSE);
			frame4.setVisible(true);
			System.out.println("fly");
			game[count].action();
			System.out.println(count);

			System.out.println("flyok");

			count++;	     		
	}
}
