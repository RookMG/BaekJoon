import sys
input = sys.stdin.readline
n = int(input())
answer = n
for i in range(n):
    line = input().rstrip()
    used = set()
    before = ''
    for ch in line:
        if ch != before:
            before = ch
            if ch in used:
                answer -= 1
                break
            else:
                used.add(ch)
print(answer)