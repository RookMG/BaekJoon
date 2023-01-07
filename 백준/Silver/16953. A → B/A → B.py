from collections import deque
a, b = map(int,input().split())
answer = 1
found = False
q = deque()
q.append(a)
while not found:
    nq = deque()
    while q:
        num = q.pop()
        if 10*num+1==b or 2*num==b:
            found = True
            break
        if 10*num<b:
            nq.append(10*num+1)
        if 2*num<b:
            nq.append(2*num)
    if not nq and not found:
        answer = -1
        break
    else:
        q = nq
    answer+=1
print(answer)