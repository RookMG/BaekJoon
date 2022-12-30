def solution(n, l, r):
    fives = [5**i for i in range(n)]
    def count(num):
        if num<5:
            return [0,1,2,2,3,4][num]
        for i in range(n):
            if fives[i]<num:
                base=i
            else:
                break
        part = num//fives[base]
        remains = num%fives[base] if part!=2 else 0
        answer = part*(4**base) if part<3 else (part-1)*(4**base)
        return answer + count(remains)
    return count(r)-count(l-1)