from math import gcd, sqrt
import sys
input = sys.stdin.readline

g, l = map(int,input().split())
tmp = g
mult = g*l
answer = [g,l]
while tmp<sqrt(mult):
    if mult%tmp == 0 and gcd(tmp,mult//tmp) == g:
        if answer[0]+answer[1]>tmp+mult//tmp:
            answer=[tmp,mult//tmp]
    tmp += g
print(answer[0],answer[1])