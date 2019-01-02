package codenames;

import java.io.FileNotFoundException;
import java.util.List;

public class AITest 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// AI ai = new AI("src/test3.vec");
		AI ai = new AI();
		Words words = new Words();
		List<Integer> list = ai.guess(words.getList(), "animal", 7);
		System.out.println(list);
	}
}
