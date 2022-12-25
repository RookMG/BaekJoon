def solution(s):
    answer = []
    pos = [-1]*26
    for i in range(len(s)):
        before = pos[ord(s[i])-97]
        pos[ord(s[i])-97]=i
        if before==-1:
            answer.append(-1)
        else:
            answer.append(i-before)
    return answer