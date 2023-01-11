from collections import deque
n = int(input())
answer = deque()
dq = deque([n])
limit = 1000000
def to1(num):
    global dq, limit
    if num==1:
        global answer
        if not answer:
            answer = dq.copy()
            limit = len(answer)
        elif len(answer)>len(dq):
            answer = dq.copy()
            limit = len(answer)
    elif num>1 and len(dq)<limit:
        if num%3==0:
            dq.append(num//3)
            to1(num//3)
            dq.pop()
        if num%2==0:
            dq.append(num//2)
            to1(num//2)
            dq.pop()
        dq.append(num-1)
        to1(num-1)
        dq.pop()
to1(n)
l = len(answer)
print(l-1)
for i in range(l):
    print(answer.popleft(), end = ' ')