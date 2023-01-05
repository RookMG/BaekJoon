from itertools import permutations
n, m = map(int,input().split())
arr = list(map(int,input().split()))
s = set()
for pick in permutations(arr,m):
    s.add(pick)
arr = list(s)
arr.sort()
for pick in arr:
    for num in pick:
        print(num, end = ' ')
    print("")