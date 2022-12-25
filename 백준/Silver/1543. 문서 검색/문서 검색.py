str = input()
key = input()
num=0
dup = 0
for i in range(len(str)) :
    if (str[i:i+len(key)] == key)&(dup==0) :
        num+=1
        dup += len(key)
    if dup :
        dup-=1
print(num)