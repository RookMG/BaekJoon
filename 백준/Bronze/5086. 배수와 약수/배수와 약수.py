a = list(map(int,input().split()))
while a != [0, 0] :
    if a[0]%a[1]:
        if a[1]%a[0]:
            print("neither")
        else :
            print("factor")
    else :
        print("multiple")
    a = list(map(int,input().split()))
