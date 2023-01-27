def combinations(n,k):
    num = 1
    for i in range(n-k+1,n+1):
        num *= i
    for i in range(1,k+1):
        num //= i
    return num

n = int(input())
for i in range(n):
    a, b = map(int,input().split())
    print(combinations(b,a))