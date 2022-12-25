x,y=map(int,input().split())
def cut(m,n):
    if (m==1)&(n==1):
        return 0
    elif m>n:
        return 1+cut(m//2,n)+cut(m-m//2,n)
    else:
        return 1+cut(m,n//2)+cut(m,n-n//2)
print(cut(x,y))