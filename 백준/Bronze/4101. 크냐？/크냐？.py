n = [1,1]
while (n[0]!=0)|(n[1]!=0):
    n = list(map(int,input().split()))
    if n[0]>n[1]:
        print("Yes")
    elif (n[0]!=0)|(n[1]!=0):
        print("No")