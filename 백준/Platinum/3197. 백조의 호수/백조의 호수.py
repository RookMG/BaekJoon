import sys
from collections import deque

vector = [[1,0],[0,1],[-1,0],[0,-1]]
def bfs():
    while sq:
        i, j = sq.popleft()
        if i == si and j == sj:
            return True
        for di, dj in vector:
            if 0<=i+di<h and 0<=j+dj<w and scheck[i+di][j+dj]==0:
                sq.append([i+di,j+dj]) if map[i+di][j+dj]!='X' else snext.append([i+di,j+dj])
                scheck[i+di][j+dj]=1
    return False
        
def melt():
    while wq:
        i, j = wq.popleft()
        if map[i][j] == 'X':
            map[i][j] = '.'
        for di, dj in vector:
            if 0<=i+di<h and 0<=j+dj<w and wcheck[i+di][j+dj]==0:
                wq.append([i+di,j+dj]) if map[i+di][j+dj]!='X' else wnext.append([i+di,j+dj])
                wcheck[i+di][j+dj]=1

h, w = map(int,sys.stdin.readline().split())
wq,sq,wnext,snext = deque(),deque(),deque(),deque()
map=[list(sys.stdin.readline().strip()) for line in range(h)]
wcheck,scheck = [[0]*w for _ in range(h)],[[0]*w for _ in range(h)]
for i in range(h):
    for j in range(w):
        if map[i][j] in '.L':
            if map[i][j] == 'L':
                map[i][j] = '.'
                if sq:
                    si,sj = i, j
                else:
                    sq.append([i,j])
                    scheck[i][j]=1
            wq.append([i,j])
            wcheck[i][j]=1
answer = 0
while True :
    melt()
    if bfs():
        print(answer)
        break
    wq,sq = wnext,snext
    wnext,snext = deque(),deque()
    answer += 1