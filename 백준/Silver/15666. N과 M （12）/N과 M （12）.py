from itertools import combinations_with_replacement
n, m = map(int,input().split())
arr = list(set(map(int,input().split())))
arr.sort()
for pick in combinations_with_replacement(arr,m):
    for num in pick:
        print(num, end = ' ')
    print("")