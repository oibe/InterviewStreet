/* Enter your code here. Read input from STDIN. Print output to STDOUT */#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 100001

int solve(char* input)
{
	int i;
	int j = 1;
	int n;	
	int counter;
	int len = strlen(input);
	int sum = len;
	
	for(n = 1; n < len;n++)
	{
		i = 0;
		counter = 0;
		for(j = n; j < len;j++)
		{
			if(input[j]==input[i])
			{
				counter++;
			}
			else
			{
				break;
			}
			i++;
		}
		sum+=counter;

	}
	
	return sum;
}

int main(int argc,char* argv[])
{
	char* buffer = (char*)malloc(sizeof(char)*MAX);
	fgets(buffer,MAX,stdin);
	int number = atoi(buffer);
	int i = 0;
	for(;i < number;i++)
	{
		fgets(buffer,MAX,stdin);
              
                if(buffer[strlen(buffer)-1] == '\n')
                {
                    
                   buffer[strlen(buffer)-1] = '\0';
                }
                
		printf("%d\n",solve(buffer));
	}

	return 0;
}
