n = 1
while True:
    arr = list(map(int,input().split()))
    if arr[0] == 0 and len(arr)==1:
        break
    print("Case "+str(n)+": Sorting... done!")
    n+=1