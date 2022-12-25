n,k = map(int,input().split())
money = {0}
count = 0
coin = []
for _ in range(n):
    coin.append(int(input()))
while True:
    count +=1
    tmp = set()
    for m in money:
        for c in coin:
            tmp.add(m+c)
    money = tmp
    if k in money:
        print(count)
        break
    elif min(money)>k:
        print(-1)
        break
