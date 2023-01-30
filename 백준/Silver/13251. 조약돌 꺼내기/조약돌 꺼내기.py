from fractions import Fraction
def com(n,m):
    answer = 1
    div = 1
    for i in range(n-m+1,n+1):
        answer*=i
    for i in range(1,1+m):
        div*=i
    return Fraction(answer,div)
m,data,k = int(input()),list(map(int,input().split())),int(input())
s = sum(data)
coms = 0
for d in data:
    coms+=com(d,k)
print(float(Fraction(coms,com(s,k))))