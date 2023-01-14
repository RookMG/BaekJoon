sum = 0
arr = []
for i in range(5):
    num = int(input())
    sum+=num
    arr.append(num)
arr.sort()
print(sum//5)
print(arr[2])