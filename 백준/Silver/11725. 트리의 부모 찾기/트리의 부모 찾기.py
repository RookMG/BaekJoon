import sys
sys.setrecursionlimit(10**5)
n = int(input())
links = [set() for _ in range(n+1)]
parent = [0 for _ in range(n+1)]
parent[1] = -1
for i in range(n-1):
    a, b = map(int,input().split())
    links[a].add(b)
    links[b].add(a)
def setP(num):
    for c in links[num]:
        if(parent[c]==0):
            parent[c] = num
            setP(c)
setP(1)
for i in range(2,n+1):
    print(parent[i])