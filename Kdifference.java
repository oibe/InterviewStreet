/*
 Enter your code here. Read input from STDIN. Print output to STDOUT
 Your class should be named Solution
*/import java.util.HashSet;
import java.util.Scanner;


public class Solution 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String[] vals = sc.nextLine().trim().split(" ");
		long N = Long.parseLong(vals[0]);
		long K = Long.parseLong(vals[1]);
		String[] numbers = sc.nextLine().split(" ");
		
		HashSet<Long> set = new HashSet<Long>();
		for(int i = 0; i < numbers.length;i++)
		{
			set.add(Long.parseLong(numbers[i]));
		}
		
		long total = 0;
		for(int j = 0; j < numbers.length;j++)
		{
			long current = Long.parseLong(numbers[j]);
			long currentPlusK = current+K;
			long currentMinusK = current-K;
			if(set.contains(currentPlusK))
				total++;
			if(set.contains(currentMinusK))
				total++;
			set.remove(current);
		}
		System.out.println(total);
	}
}
