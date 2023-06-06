from functools import cmp_to_key
n = int(input())
def compare(x, y):
    if str(x)+str(y) > str(y)+str(x):
        return -1
    if str(x)+str(y) < str(y)+str(x):
        return 1
    return 0
nums = input().split()
nums.sort(key=cmp_to_key(compare))
ans = ""
for num in nums:
    ans += num
print(int(ans))