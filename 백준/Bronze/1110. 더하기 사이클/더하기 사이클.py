import sys
input = sys.stdin.readline
n = int(input())
count, now = 0, n
while True:
    a, b = now//10, now%10
    now = (b)*10 + (a+b)%10
    count += 1
    if now == n:
        print(count)
        break