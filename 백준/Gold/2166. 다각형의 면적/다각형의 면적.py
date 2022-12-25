import sys
input = sys.stdin.readline

n = int(input())
x1, y1 = map(int,input().split())
x, y = x1, y1
answer = 0
for _ in range(1,n):
    x2, y2 = map(int,input().split())
    answer += x1*y2 - x2*y1
    x1, y1 = x2, y2
answer += x1*y - x*y1
answer = round(answer/2, 1)
print(abs(answer))