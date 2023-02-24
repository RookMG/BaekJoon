x, y = int(input()),int(input())
answer = 2
if x*y > 0:
    answer -= 1
if y<0:
    answer += 2
print(answer)