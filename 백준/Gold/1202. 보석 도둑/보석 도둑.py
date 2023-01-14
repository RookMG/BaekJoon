import heapq, sys
input = sys.stdin.readline
n, k = map(int,input().split())
jewels, bags, jewelSorted = [], [], []
answer = 0
for i in range(n):
    heapq.heappush(jewels, list(map(int,input().split())))
for i in range(k):
    bags.append(int(input()))
bags.sort()
for b in bags:
    while jewels and jewels[0][0]<=b:
        heapq.heappush(jewelSorted,-jewels[0][1])
        heapq.heappop(jewels)
    if jewelSorted:
        answer-=heapq.heappop(jewelSorted)
    elif not jewels:
        break
print(answer)