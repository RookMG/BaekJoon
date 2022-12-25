num = int(input())
for i in range(num):
    score = 0
    flag = 0
    for j in input():
        if j == 'O':
            flag+=1
            score += flag
        else :
            flag = 0
    print(score)