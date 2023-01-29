n = int(input())
crane = sorted(list(map(int,input().split())))
m = int(input())
box = sorted(list(map(int,input().split())))
if crane[-1]<box[-1]:
    print(-1)
    exit()
answer = 0
while box:
    for c in crane:
        for i in range(len(box)-1,-1,-1):
            if box[i]<=c:
                box.remove(box[i])
                break
    answer+=1
print(answer)