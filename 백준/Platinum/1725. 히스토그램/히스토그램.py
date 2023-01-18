from collections import deque
import sys
input = sys.stdin.readline
stack = deque()
def calc(i,ans):
    l = line[stack.pop()]
    w = i
    if stack:
        w -= stack[-1] + 1
    return max(ans,l*w)
line = []
n = int(input())
for i in range(n):
    line.append(int(input()))
stack = deque()
answer = 0
for _ in range(n):
    while stack and line[stack[-1]] > line[_]:
        answer = calc(_,answer)
    stack.append(_)
while stack:
    answer = calc(n,answer)
print(answer)