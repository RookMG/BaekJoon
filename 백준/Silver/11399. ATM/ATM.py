num = int(input())
time = list(map(int,input().split()))
time.sort()
sum = 0
wait = 0
for i in time :
    wait += i
    sum += wait
print(sum)