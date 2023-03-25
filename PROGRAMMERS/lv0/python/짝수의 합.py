def solution(n):
    return sum([v for v in range(2, n+1, 2)])

inps = [
    10,
    4
]

for n in inps:
    print(solution(n))