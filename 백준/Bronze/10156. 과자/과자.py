l = list(map(int,input().split()))
ans = l[0]*l[1] - l[2]
if ans<0:
    ans = 0
print(ans)