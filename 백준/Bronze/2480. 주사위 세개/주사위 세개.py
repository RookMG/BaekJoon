dice = list(map(int,input().split()))
dset = list(set(dice))
if len(dset)==3:
    print(max(dice)*100)
elif len(dset)==2:
    print(1000 + (sum(dice) - sum(dset)) * 100)
else:
    print(10000 + dset[0] * 1000)