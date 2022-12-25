def solution(numbers):
    answer = 45
    for _ in numbers:
        answer-=_
    return answer