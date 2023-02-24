n = int(input())
idx = 2
ans = []
while(n!=1):
    if n%idx == 0:
        n = n//idx
        ans.append(idx)
    else :
        idx +=1
for _ in ans:
    print(_)