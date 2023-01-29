from itertools import combinations
from collections import deque
import copy
R, C = map(int,input().split())
lab, cell, virus, visit = [], [], [], []
delta = [[-1,0],[1,0],[0,1],[0,-1]]
for r in range(R):
    lab.append(list(map(int,input().split())))
safe = -3
for r in range(R):
    visit.append([])
    for c in range(C):
        if lab[r][c]==0:
            safe+=1
            cell.append([r,c])
            visit[r].append(False)
        elif lab[r][c]==2:
            visit[r].append(True)
            virus.append([r,c])
        else:
            visit[r].append(True)
answer = 0
for walls in combinations(cell,3):
    v = copy.deepcopy(visit)
    result = safe
    for w in walls:
        v[w[0]][w[1]]=True
    q = deque()
    for vr in virus:
        q.append(vr)
    while q:
        nq = deque()
        while q:
            now = q.pop()
            r, c = now[0], now[1]
            for d in delta:
                nr, nc = r+d[0], c+d[1]
                if 0<=nr<R and 0<=nc<C and not v[nr][nc] and lab[nr][nc]==0:
                    nq.append([nr,nc])
                    result-=1
                    v[nr][nc] = True
        q = nq
    answer = max(answer,result)
    if answer==safe:
        break
print(answer)