import sys
from collections import deque

input = sys.stdin.readline
ans = 0
for test in range(int(input())):
    str = input().rstrip()
    stack = deque()
    for ch in str:
        if len(stack) == 0 or stack[-1] != ch:
            stack.append(ch)
        else:
            stack.pop()
    if len(stack) == 0:
        ans += 1
print(ans)