import sys
import heapq
n = int(sys.stdin.readline())
left = []
right = []
for _ in range(n):
    num = int(sys.stdin.readline())
    if len(left)>len(right):
        heapq.heappush(right,(num,num))
    else:
        heapq.heappush(left,(-num,num))
    if right and (left[0][1] > right [0][1]):
        tmp1 = heapq.heappop(left)[1]
        tmp2 = heapq.heappop(right)[1]
        heapq.heappush(left,(-tmp2,tmp2))
        heapq.heappush(right,(tmp1,tmp1))
    print(left[0][1])