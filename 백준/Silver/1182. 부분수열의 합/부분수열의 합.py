from itertools import combinations
n, s  = map(int,input().split())
answer = 0
arr = list(map(int,input().split()))
for i in range(1,1+n):
    for picks in combinations(arr,i):
        if sum(picks)==s:
            answer+=1
print(answer)