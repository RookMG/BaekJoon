n = int(input())
arr = list(map(int,input().split()))
left = [1]*n
right = [0]*n
for i in range(n):
    num1 = arr[i]
    num2 = arr[n-1-i]
    for j in range(i,n):
        if arr[j]>num1:
            left[j] = max(left[i]+1,left[j])
        if arr[n-1-j]>num2:
            right[n-1-j] = max(right[n-1-i]+1,right[n-1-j])
for i in range(n):
    left[i]+=right[i]
left.sort()
print(left[n-1])