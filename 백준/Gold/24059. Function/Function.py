n = int(input())
arr = list(map(int,input().split()))
mod = int(input())
ans = arr[0]
for i in range(n):
    ans = pow(arr[i+1],ans,mod-n+i+1)
    if ans==0:
        ans = mod-n+i+1
print(ans%mod)