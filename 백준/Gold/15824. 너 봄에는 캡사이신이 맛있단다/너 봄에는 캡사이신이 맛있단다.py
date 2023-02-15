MOD = 1000000007
n, answer = int(input()), 0
arr = list(map(int,input().split()))
arr.sort()
for i in range(len(arr)-1):
    for j in range(i,len(arr)):
        answer +=(arr[j]-arr[i])*pow(2,j-i-1,MOD)%MOD
print(answer%MOD)