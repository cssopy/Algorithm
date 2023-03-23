def solution(numbers):
    return [v*2 for v in numbers]

inps = [
    [1, 2, 3, 4, 5],
    [1, 2, 100, -99, 1, 2, 3]
]

for inp in inps:
    print(solution(inp))