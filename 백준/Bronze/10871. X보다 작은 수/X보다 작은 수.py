import sys
input = sys.stdin.readline
n, x = map(int,input().split())
l = list(map(int,input().split()))
for _ in l:
    if _<x:
        print(_,end=' ')