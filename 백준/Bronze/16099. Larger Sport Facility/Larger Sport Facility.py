n = int(input())
for i in range(n):
    a,b,c,d = map(int,input().split())
    print("Eurecom" if a*b<c*d else ("Tie" if a*b==c*d else "TelecomParisTech"))