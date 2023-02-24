n = int(input())
ans = 0
if (n%400 == 0) :
    ans+=1
elif (n%100 != 0) & (n%4 == 0) :
    ans+=1
print(ans)