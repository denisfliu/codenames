package codenames;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.jscience.mathematics.vector.Float64Vector;

public class AI
{
	public AI()
	{
		this("src/wiki-news-300d-1M.vec");
	}
	
	public AI(String path) 
	{
		Scanner scanner;
		File f;
		try
		{
			f = new File(path);
			scanner = new Scanner(f);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("noob");
			return;
		}
		scanner.next();
		int dimensionSize = Integer.parseInt(scanner.next());
		System.out.println(dimensionSize);
		
		while (scanner.hasNext())
		{	
			String word = scanner.next();
			String nextLine = scanner.nextLine();
			System.out.println(word);
			wordMap.put(word, populateFloat(dimensionSize, nextLine));
		}
		scanner.close();
	}
	
	public Float64Vector populateFloat(int dimensionSize, String line)
	{
 		double [] numbers = new double [dimensionSize];
		String [] strings = line.split(" ");
		for (int i = 0; i < dimensionSize; i++)
		{
			if (i + 2 > strings.length)
			{
				numbers [i] = 0.0;
				continue;
			}
			numbers [i] = Double.parseDouble(strings [i+1]);
		}
		return Float64Vector.valueOf(numbers);
	}
	
	public List<Integer> guess(ArrayList<String> wordList, String clue, int num)
	{
		//ArrayList<Integer> numbers = new ArrayList<Integer>();
		List<Double> distances = wordList.stream().map(word -> 
			wordMap.get(clue).minus(wordMap.get(word)).normValue()
		).collect(Collectors.toList());
		List<Integer> sorted = IntStream.range(0,wordList.size()).boxed().sorted((i, j) -> 
			Double.compare(distances.get(i), distances.get(j))
		).collect(Collectors.toList());
		return sorted.subList(0, num);
	}
	
	private HashMap<String, Float64Vector> wordMap = new HashMap<String, Float64Vector>();
}
