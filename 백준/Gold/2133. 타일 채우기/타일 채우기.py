n = int(input())
answers = [0 for _ in range(31)]
answers[2] = 3
for i in range(4,n+1,2):
    answers[i] += 2 + 3*answers[i-2]
    for j in range(2,i-2,2):
        answers[i]+=2*answers[j]
print(answers[n])