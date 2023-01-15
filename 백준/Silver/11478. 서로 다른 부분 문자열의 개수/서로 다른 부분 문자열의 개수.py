s = input()
l = set()
for i in range(len(s)):
    for j in range(i,len(s)):
        l.add(s[i:j+1])
print(len(l))