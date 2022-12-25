obj = int(input())
a = [0,0,0]
if obj%10 !=0:
    print(-1)
else:
    a[0] = obj//300
    a[1] = (obj//60)%5
    a[2] = (obj//10)%6
    print(a[0],a[1],a[2])