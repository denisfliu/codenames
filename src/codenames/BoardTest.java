package codenames;


import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class BoardTest 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		JFrame frame = new BoardFrame();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setVisible(true);
	}
}
