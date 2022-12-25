num, value = map(int,input().split())
coin = list()
count = 0
for i in range(num) :
    coin.append(int(input()))
for i in reversed(range(num)) :
    count += value//coin[i]
    value%=coin[i]
print(count)