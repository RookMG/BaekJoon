s = input()
p = ' '
ans = 0
for _ in s:
    if p != _ :
        ans += 5
    ans+=5
    p = _
print(ans)