def gcd(a,b):
    return gcd(b, a % b) if b else a
n = int(input())
arr = list(map(int,input().split()))
for i in range(1,n):
    g =gcd(arr[0],arr[i])
    print(str(arr[0]//g)+"/"+str(arr[i]//g))