/*
 Enter your code here. Read input from STDIN. Print output to STDOUT
 Your class should be named Solution
*/import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class Solution 
{
	static HashMap<String,String> mappings;
	static HashMap<String,String> cache;
	public static boolean done(String input)
	{
		for(int i = 0; i < input.length()-1;i++)
			if(input.charAt(i) != input.charAt(i+1))
				return false;
		return true;
	}

	public static String replace(String input,int first, int second,String sub)
	{
		String result = "";
		for(int i = 0; i < input.length();i++)
		{
			if(i == first)
			{
				result+=sub;
			}
			else if(i == second)
			{
				
			}
			else{
				result+= input.charAt(i);
			}
			
		}
		return result;
	}
	
	public static String solve(String input)
	{
		if(done(input))
			return input;
		
		String min = input;
		boolean skip = false;
		String pref = "";
		String curr = "";
		for(int i = 0; i < input.length()-1;i++)
		{
			String word = ""+input.charAt(i)+input.charAt(i+1);
			String next = replace(input,i,i+1,mappings.get(word));
			if(next.equals(input))
				continue;
			
			
			if(cache.containsKey(next)){
				min = min.length() < cache.get(next).length()?min:cache.get(next);
				continue;
			}else{
				String temp=solve(next);
				min = min.length()< temp.length()? min: temp;
			}
			
			if(min.length() ==1  || (min.length() == 2 && done(min)))
					return min;
		}
		
		cache.put(input, min);
		return min;
	}
	
	public static void main(String[] args) 
	{
		mappings = new HashMap<String,String>();
		cache = new HashMap<String,String>();
		mappings.put("aa", "aa");
		mappings.put("bb", "bb");
		mappings.put("cc", "cc");
		mappings.put("ab", "c");
		mappings.put("ac", "b");
		mappings.put("ba", "c");
		mappings.put("bc", "a");
		mappings.put("cb", "a");
		mappings.put("ca", "b");
		
		Scanner sc = new Scanner(System.in);
		int cases = Integer.parseInt(sc.nextLine().trim());
		while(sc.hasNext())
		{
			String word = sc.nextLine().trim();
			System.out.println(solve(word).length());
		}
		sc.close();
		
	}
}
