loop = [[0,6,5,12],[],[2,7,8],[],[4]]
x, n = map(int,input().split())
while True:
    if n==0 or (x<5 and x%2==0): break
    if x%2==0 : x>>=1
    else : x<<=1
    x^=6
    n-=1
if n>0 : x = loop[x][n%len(loop[x])]
print(x)