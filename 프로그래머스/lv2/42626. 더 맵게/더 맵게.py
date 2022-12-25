import heapq
def solution(heap, K):
    answer = 0
    heapq.heapify(heap)
    if max(heap) == 0:
        return -1
    while heap[0]<K:
        if len(heap) == 1:
            return -1
        answer+=1
        i = heapq.heappop(heap)
        j = heapq.heappop(heap)
        heapq.heappush(heap,i+2*j)
    return answer