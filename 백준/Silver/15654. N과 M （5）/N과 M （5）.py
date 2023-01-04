from itertools import permutations
n, m = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()
for pick in permutations(arr,m):
    for num in pick:
        print(num, end = ' ')
    print("")