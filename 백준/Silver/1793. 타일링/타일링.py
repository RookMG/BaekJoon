answer = [0]*251
answer[0] = 1
answer[1] = 1
for i in range(2,251):
    answer[i] = answer[i-2]*2+answer[i-1]
while True:
    try:
        print(answer[int(input())])
    except:
        break