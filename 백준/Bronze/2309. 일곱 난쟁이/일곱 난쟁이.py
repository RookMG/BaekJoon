from itertools import combinations
h=[int(input()) for i in range(9)]
h.sort()
for case in combinations(h,7):
    if sum(case)==100:
        for i in case:
            print(i)
        break