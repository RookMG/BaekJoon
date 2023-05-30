# https://www.geeksforgeeks.org/pollards-rho-algorithm-prime-factorization/
import random

def pollard_rho(n):
    if is_prime(n):
        return n
    if n == 1:
        return 1
    if n % 2 == 0:
        return 2
    x = random.randrange(2, n)
    y = x
    c = random.randrange(1, n)
    d = 1
    while d == 1:
        x = (power(x, 2, n) + c) % n
        y = (power(y, 2, n) + c) % n
        y = (power(y, 2, n) + c) % n
        d = gcd(abs(x - y), n)
        if d == n:
            return pollard_rho(n)
    if is_prime(d):
        return d
    else:
        return pollard_rho(d)


def is_prime(num):
    primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41]
    if num == 1 or (num != 2 and num % 2 == 0):
        return False
    for prime in primes:
        if num == prime:
            return True
        if not miller_rabin(num, prime):
            return False
    return True


def miller_rabin(num, prime):
    r = 0
    d = num - 1
    while d % 2 == 0:
        r += 1
        d = d // 2
    x = power(prime, d, num)
    if x == 1 or x == num - 1:
        return True
    for i in range(r - 1):
        x = power(x, 2, num)
        if x == num - 1:
            return True
    return False


def gcd(a, b):
    if a < b:
        a, b = b, a
    while b != 0:
        r = a % b
        a = b
        b = r
    return a


def power(x, y, p):
    res = 1
    x = x % p
    while y > 0:
        if y & 1:
            res = (res * x) % p
        y = y >> 1
        x = (x*x) % p
    return res

n = int(input())
ans = n
if n==1:
    print(1)
else:
    s = set()
    while n > 1:
        div = pollard_rho(n)
        s.add(div)
        n = n // div
    for i in s:
        ans //= i
        ans *= (i-1)
    print(ans)