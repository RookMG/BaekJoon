def solution(s):
    nums = list(map(int,s.split()))
    nums.sort()
    answer = str(nums[0])+' '+str(nums[-1])
    return answer