arr = [0,1,1,1,2]
for i in range(96):
    arr.append(arr[i]+arr[i+4])
for i in range(int(input())):
    print(arr[int(input())])