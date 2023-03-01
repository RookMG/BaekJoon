from fractions import Fraction
d = dict()
x, y = map(int,input().split())
n = int(input())
for i in range(n):
    a, b = map(int,input().split())
    if y<=b or x==a: continue
    div = Fraction(abs(x-a)*(x-a),y-b)
    if div not in d:
        d[div] = 1
    else :
        d[div] += 1
if d:
    print(max(d.values()))
else:
    print(0)