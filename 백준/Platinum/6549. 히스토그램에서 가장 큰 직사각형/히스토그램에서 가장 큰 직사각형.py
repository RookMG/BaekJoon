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
while True:
    line = list(map(int,input().split()))
    n = line.pop(0)
    if n == 0 :
        break
    stack = deque()
    answer = 0
    for _ in range(n):
        while stack and line[stack[-1]] > line[_]:
            answer = calc(_,answer)
        stack.append(_)
    while stack:
        answer = calc(n,answer)
    print(answer)