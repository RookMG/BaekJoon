from itertools import combinations
import sys
input = sys.stdin.readline
a, b = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()
for c in combinations(arr,b):
    for i in c:
        print(i,end=' ')
    print()