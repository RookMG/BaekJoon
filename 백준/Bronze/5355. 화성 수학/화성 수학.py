n = int(input())
def calc(a,b):
    if b =='@':
        return a*3
    elif b=='%':
        return a+5
    elif b=='#':
        return a-7

for i in range(n):
    l = list(map(str,input().split()))
    ans = float(l[0])
    for j in range(len(l)-1):
        ans=calc(ans,l[j+1])
    print("{:.2f}".format(ans))