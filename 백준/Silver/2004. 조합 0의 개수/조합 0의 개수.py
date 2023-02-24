def totdiv(n, div):
    i = div
    sum = 0
    while n//i :
        sum += n//i
        i*=div 
    return sum
n, m = map(int,input().split())
t = totdiv(n,2)-totdiv(m,2)-totdiv(n-m,2)
f = totdiv(n,5)-totdiv(m,5)-totdiv(n-m,5)
print(min(t,f))