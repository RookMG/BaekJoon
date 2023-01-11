r, c = map(int,input().split())
visit = [False]*26
board = [input() for _ in range(r)]
answer = 0
def dfs(x,y,l):
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<=nx<r and 0<=ny<c:
            if visit[ord(board[nx][ny])-65]:
                global answer
                answer = max(answer,l)
            else:
                visit[ord(board[nx][ny])-65] = True
                dfs(nx,ny,l+1)
                visit[ord(board[nx][ny])-65] = False
visit[ord(board[0][0])-65]=True
dfs(0,0,1)
print(answer)