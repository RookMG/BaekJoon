from collections import deque
import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline
dx, dy = [1,-1,0,0],[0,0,1,-1]

def dfs(x,y,color,blind):
    if blind and color=='G':
        color = 'R'
    for i in range(4):
        nx, ny = min(max(x+dx[i],0),n-1), min(max(y+dy[i],0),n-1)
        if not visited[nx][ny]:
            if blind:
                if (graph[nx][ny]==color) or (graph[nx][ny]=='G' and color=='R'):
                    visited[nx][ny]=True
                    dfs(nx,ny,color,blind)
            elif graph[nx][ny]==color:
                visited[nx][ny]=True
                dfs(nx,ny,color,blind)
        
n = int(input())
graph = []
for i in range(n):
    graph.append(input().rstrip())
a,b = 0,0
visited = [[False]*n for i in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            visited[i][j] = True
            dfs(i,j,graph[i][j],False)
            a+=1

visited = [[False]*n for i in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            visited[i][j] = True
            dfs(i,j,graph[i][j],True)
            b+=1

print(a,b)