def solution(numbers, hand):
    answer = ''
    left = [3,0]
    right = [3,2]
    close = ''
    for num in numbers:
        if num % 3 == 2 or num == 0 :
            pos = [3,1] if num==0 else [num//3,1]
            if mannd(pos,left)>mannd(pos,right):
                close = 'right'
            elif mannd(pos,left)<mannd(pos,right):
                close = 'left'
            else:
                close = hand
            if close == 'left':
                left = pos
                answer+='L'
            else:
                right = pos
                answer+='R'
        elif num % 3 == 1 :
            answer+='L'
            left = [num//3,0]
        elif num % 3 == 0 :
            answer+='R'
            right = [num//3 -1,2]
    return answer

def mannd(pos1,pos2):
    return abs(pos1[0]-pos2[0])+abs(pos1[1]-pos2[1])