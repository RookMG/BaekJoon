a = int(input())
b = a
s = input()
for _ in s:
    a-=1 if _=="B" else 0
b -= a
if a == b:
    print("Tie")
else :
    print("A" if a>b else "B")