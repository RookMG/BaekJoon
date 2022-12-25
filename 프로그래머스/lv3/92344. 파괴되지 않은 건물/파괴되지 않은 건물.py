def solution(board, skill):
    answer = 0
    n, m = len(board), len(board[0])
    change = [[0]*(m+1) for i in range(n+1)]
    for s in skill:
        sign = 1 if s[0]==1 else -1
        change[s[1]][s[2]]+=sign*s[5]
        change[s[1]][s[4]+1]-=sign*s[5]
        change[s[3]+1][s[2]]-=sign*s[5]
        change[s[3]+1][s[4]+1]+=sign*s[5]
    for i in range(n):
        for j in range(m):
            change[i][j+1]+=change[i][j]
    for j in range(m):
        for i in range(n):
            change[i+1][j]+=change[i][j]
            if board[i][j]>change[i][j]:
                answer+=1
    return answer