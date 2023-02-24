num, max = map(int,input().split())
b =list(map(int,input().split()))
ans = 0
sum = 0
for p1 in range(0,num-2):
    for p2 in range(p1+1,num-1):
        for p3 in range(p2+1,num):
            sum = b[p1]+b[p2]+b[p3]
            if (sum>ans)&(sum<max+1):
                ans = sum
print(ans)