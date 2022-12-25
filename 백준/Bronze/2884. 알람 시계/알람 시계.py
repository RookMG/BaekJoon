hour, min = map(int,input().split())
if min<45:
    min+=15
    hour-=1
    if hour<0:
        hour+=24
else:
    min-=45
print(hour,min)