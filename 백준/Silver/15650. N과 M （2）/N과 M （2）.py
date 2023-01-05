from itertools import combinations
n, m = map(int,input().split())
arr = [i for i in range(1,n+1)]
arr.sort()
for pick in combinations(arr,m):
    for num in pick:
        print(num, end = ' ')
    print("")