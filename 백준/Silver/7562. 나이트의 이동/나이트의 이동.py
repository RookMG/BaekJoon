from collections import deque
n = int(input())
delta = ((-2,-1),(-2,1),(-1,-2),(-1,2),(1,-2),(1,2),(2,-1),(2,1))
for i in range(n):
    size = int(input())
    q = deque()
    q.append(list(map(int,input().split())))
    tr, tc = map(int,input().split())
    move = -1
    visit = [[False for _ in range(size)] for __ in range(size)]
    while q:
        nq = deque()
        move+=1
        while q:
            r,c = map(int,q.pop())
            if r==tr and c==tc:
                nq=deque()
                break
            for d in delta:
                nr, nc = r+d[0], c+d[1]
                if 0<=nr<size and 0<=nc<size and not visit[nr][nc]:
                    nq.append([nr,nc])
                    visit[nr][nc] = True
        q = nq
    print(move)