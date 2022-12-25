n = int(input())
a, b = list(map(int,input().split())),list(map(int,input().split()))
a.sort()
b.sort(reverse=True)
answer = 0
for i in range(n):
    answer += a[i]*b[i]
print(answer)