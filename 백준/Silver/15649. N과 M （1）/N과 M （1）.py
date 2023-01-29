from itertools import permutations
n, r = map(int,input().split())
for out in permutations(range(1,n+1),r):
    for num in out:
        print(num, end = " ")
    print()