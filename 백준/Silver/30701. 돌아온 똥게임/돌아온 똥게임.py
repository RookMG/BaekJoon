import sys
import heapq
input = sys.stdin.readline
N, D = map(int,input().split())
ans, limit = 0, 0
enemy, weapon = [], []
for _ in range(N):
    A, X = map(int,input().split())
    heapq.heappush(enemy if A==1 else weapon, X)
    limit = max(limit, X)
while len(enemy) != 0:
    if D>limit:
        ans = N - len(weapon)
        break
    now = heapq.heappop(enemy)
    if now >= D:
        if len(weapon) == 0:
            break
        D *= heapq.heappop(weapon)
        heapq.heappush(enemy, now)
    else:
        D += now
    ans += 1
print(ans + len(weapon))