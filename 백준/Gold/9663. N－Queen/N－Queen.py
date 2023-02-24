import sys
input = sys.stdin.readline
n = int(input())
placement = [0]*n
answer = 0
def dfs(i):
    if i==n:
        global answer
        answer += 1
        return
    for j in range(n):
        attack = False
        for k in range(i):
            if placement[k] == j or abs(placement[k] - j) == i - k :
                attack = True
                break
        if not attack:
            placement[i] = j
            dfs(i+1)
dfs(0)
print(answer)