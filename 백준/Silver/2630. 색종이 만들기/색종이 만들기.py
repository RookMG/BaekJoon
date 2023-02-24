size = int(input())
def onecolor(n,paper):
    key = paper[0][0]
    for i in range(n):
        for j in range(n):
            if paper[i][j]!=key:
                return False
    return True
def cut(n, paper,b,w):
    key = paper[0][0]
    if (n == 1) | (onecolor(n,paper)):
        b+=key
        w+=1-key
        return [w, b]
    else :
        left = [i[:n//2] for i in paper]
        right = [i[n//2:] for i in paper]
        return [i+j+k+l for i,j,k,l in zip(cut(n//2,left[n//2:],b,w),cut(n//2,left[:n//2],b,w),cut(n//2,right[n//2:],b,w),cut(n//2,right[:n//2],b,w))]
data = []
for i in range(size):
    data.append(list(map(int,input().split())))
result = cut(size,data,0,0)
print(result[0])
print(result[1])