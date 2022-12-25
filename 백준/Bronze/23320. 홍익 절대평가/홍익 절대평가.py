num = int(input())
score = list(map(int,input().split()))
cut = list(map(int,input().split()))
print(num*cut[0]//100)
ab = 0
for i in score :
    if i >= cut[1] :
        ab+=1
print(ab)
