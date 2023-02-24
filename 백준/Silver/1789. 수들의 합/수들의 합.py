n = int(input())
ans = 1
while True :
    if (ans*(ans+1)//2) > n :
        print(ans-1)
        break
    ans+=1