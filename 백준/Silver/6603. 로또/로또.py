from itertools import combinations
arr = list(map(int,input().split()))
while len(arr)!=1:
    for c in combinations(arr[1:],6):
        for i in c:
            print(i,end=' ')
        print()
    print()
    arr = list(map(int, input().split()))