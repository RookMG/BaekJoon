import sys
input = sys.stdin.readline
N, D = map(int,input().split())
ans, limit = 0, 0
enemy, weapon = [], []
for _ in range(N):
    A, X = map(int,input().split())
    (enemy if A==1 else weapon).append(X)
    limit = max(limit, X)
enemy.sort()
weapon.sort()
E, e, W, w = len(enemy), 0, len(weapon), 0
while E != e:
    if D > limit:
        ans = N
        w = W
        break
    if enemy[e] >= D:
        if w == W:
            break
        D *= weapon[w]
        w += 1
    else:
        D += enemy[e]
        e += 1
    ans += 1
print(ans + len(weapon) - w)