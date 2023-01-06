a,b,c = map(int,input().split())
answer = 1
a%=c
def mul(n):
    if n==1:
        return a
    if n%2==0:
        return ((mul(n//2)%c)**2)%c
    else:
        return (a*((mul(n//2)%c)**2))%c
answer *= mul(b)
print(answer)