package codenames;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class BoardTest 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		
		/*
		 * AI ai = new AI("src/test2.vec");
		 * ArrayList<String> str = new ArrayList<String>();
		str.add(",");
		str.add("and");
		str.add("of");
		List<Integer> list = ai.guess(str, "that", 2);
		System.out.println(ai);
	
		 */
		
		
		
		JFrame frame = new BoardFrame();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setVisible(true);
	}
}
