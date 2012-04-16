# Enter your code here. Read input from STDIN. Print output to STDOUT# Enter your code here. Read input from STDIN. Print output to STDOUT# Enter your code here. Read input from STDIN. Print output to STDOUT# Enter your code here. Read input from STDIN. Print output to STDOUT
import sys
from math import *

def min(a,b):
    if a < b:
        return a
    else:
        return b

def calc(points,index):
    sum = 0
    for i in range(len(points)):
        if i != index:
            sum+= dist(points[i][0],points[i][1],points[index][0],points[index][1])
    return sum
    
def dist(x,y,start,end):
    l = []
    l.append(abs(start-x))
    l.append(abs(end-y))
    max = l[0]
    for i in range(len(l)):
        if l[i] > max:
            max = l[i]
    return max

def solve(points):
    centerX = 0
    centerY = 0
    for p in points:
        centerX+=p[0]
        centerY+=p[1]
    centerX/=len(points)
    centerY/=len(points)
    min = dist(points[0][0],points[0][1],centerX,centerY)
    for p in points:
        temp = dist(p[0],p[1],centerX,centerY)
        if temp < min:
            min = temp
    l = []
    for p in range(len(points)):
        if dist(points[p][0],points[p][1],centerX,centerY) <= 2*min:
            l.append(p)
    
    min = calc(points,l[0])

    for p in l:
        temp = calc(points,p)
        if temp < min:
            min = temp
    print min    
            
num_cases = int(raw_input())

points = []
for i in range(num_cases):
    l = raw_input().split()
    l[0] = int(l[0])
    l[1] = int(l[1])
    points.append(l)

solve(points)
