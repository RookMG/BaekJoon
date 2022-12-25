def lcm(a,b):
    m = 2
    ans = 1
    if b>a:
        tmp = a
        a = b
        b = tmp
    while a>=m:
        if (a%m==0)&(b%m==0):
            a=a//m
            b=b//m
            ans*=m
        else:
            m+=1
    return ans*a*b
n = int(input())
for _ in range(n):
    l = list(map(int,input().split()))
    print(lcm(l[0],l[1]))