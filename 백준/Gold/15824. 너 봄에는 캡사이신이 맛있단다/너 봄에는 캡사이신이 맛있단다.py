n, answer = int(input()), 0
arr = list(map(int,input().split()))
arr.sort()
pows = [0 for _ in range(n+1)]
pows[0] = 1
pows[1] = 2

def square(k):
    if pows[k]==0:
        pows[k] = 2 * (square(k // 2)**2) % 1000000007 if k % 2 == 1 else (square(k // 2)**2)
    return pows[k]


for i in range(len(arr)-1):
    for j in range(i+1,len(arr)):
        answer +=(arr[j]-arr[i])*square(j-i-1)%1000000007
print(answer%1000000007)