n = int(input())
for _ in range(n):
    s = list(map(int,input().split()))
    ans = "advertise" if s[0]<s[1]-s[2] else "do not advertise"
    if s[0]==s[1]-s[2]:
        ans = "does not matter"
    print(ans)