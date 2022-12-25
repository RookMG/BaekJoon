#2 * 1 = 2
import sys
input = sys.stdin.readline
n = int(input())
for i in range(1,10):
    print(str(n)+" * "+str(i)+" = "+str(n*i))