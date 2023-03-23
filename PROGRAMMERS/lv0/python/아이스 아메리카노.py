def solution(money):
    return [money//5_500, money%5_500]

inps = [
    5_500,
    15_000
]

for inp in inps:
    print(solution(inp))