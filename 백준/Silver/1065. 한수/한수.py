n = int(input())
if n == 1000:
    n = 999
answer = 99
if n<100:
    print(n)
else:
    for i in range(100,n+1):
        a,b,c = int(str(i)[0]),int(str(i)[1]),int(str(i)[2])
        if a+c == 2*b:
            answer +=1
    print(answer)