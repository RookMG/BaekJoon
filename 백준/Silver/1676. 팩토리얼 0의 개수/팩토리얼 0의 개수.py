def totdiv(n, div):
    i = div
    sum = 0
    while n//i :
        sum += n//i
        i*=div 
    return sum
num = int(input())
t = totdiv(num,2)
f = totdiv(num,5)
print(min(t,f))