import sys
from collections import deque
input = sys.stdin.readline

def day():
    global left
    while go:
        i,j = go.pop()
        for di, dj in vector:
            ni = i+di
            nj = j+dj
            if 0<=ni<n and 0<=nj<m and box[ni][nj]==0:
                next.append([ni,nj])
                box[ni][nj] = 1
                left -= 1

vector = [[1,0],[-1,0],[0,1],[0,-1]]
m, n = map(int,input().split())
box = []
visit = [[0]*m for _ in range(n)]
for _ in range(n):
    box.append(list(map(int,input().strip().split())))
count, left = 0, 0
go,next = deque(),deque()
for i in range(n):
    for j in range(m):
        if box[i][j] == 0:
            left += 1
        else:
            if box[i][j] == 1:
                go.append([i,j])
            visit[i][j] = 1
while go:
    if left <= 0:
        break
    day()
    go = next
    next = deque()
    count += 1
print(count if left<=0 else -1)