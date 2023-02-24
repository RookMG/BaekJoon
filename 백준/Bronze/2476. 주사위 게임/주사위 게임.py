n = int(input())
ans = []
for _ in range(n):
    dice = list(map(int,input().split()))
    dup = 4 - len(list(set(dice)))
    if dup==3:
        ans.append(10000 + 1000*dice[0])
    elif dup==1:
        ans.append(100*max(dice))
    elif dice.count(dice[0])==2:
        ans.append(1000+100*dice[0])
    else:
        ans.append(1000+100*dice[1])
print(max(ans))