l = input()
answer = 0
while len(l)>1:
    new = sum(map(int,l))
    answer+=1
    l = str(new)
print(answer)
print("YES" if l in {"3","6","9"} else "NO")