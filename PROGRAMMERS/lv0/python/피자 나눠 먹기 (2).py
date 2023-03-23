def solution(n):
    GCD = lambda a,b : b if a%b==0 else GCD(b, a%b)
    return n // GCD(n, 6)

inps = [
    6,
    10,
    4
]

for inp in inps:
    print(solution(inp))