def solution(numer1, denom1, numer2, denom2):
    a = numer1*denom2+numer2*denom1
    b = denom1*denom2
    
    gcd = GCD(a, b)
    return [a//gcd , b//gcd]

def GCD(a, b):
    return b if a%b==0 else GCD(b, a%b)

inps = [
    [1,	2,	3,	4],
    [9,	2,	1,	3]
]

for (n1, d1, n2, d2) in inps:
    print(solution(n1, d1, n2, d2))