dice = list(map(int,input().split()))
dup = 4 - len(list(set(dice)))
if dup==3:
    print(10000 + 1000*dice[0])
elif dup==1:
    print(100*max(dice))
elif dice.count(dice[0])==2:
    print(1000+100*dice[0])
else:
    print(1000+100*dice[1])