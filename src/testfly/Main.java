package testfly;

import javax.swing.JFrame;

public class Main {
	public static JFrame frame;
	public static void main(String[] args)
			throws Exception {
			frame = new JFrame();
			frame.setTitle("flappy pig");;
			TestBirdFly game = new TestBirdFly();
			frame.add(game);
			frame.setSize(440, 670);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(
					JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			game.action();
		}
}
