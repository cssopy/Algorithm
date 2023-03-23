def solution(array):
    return sorted(array)[len(array)//2]

inps = [
    [1, 2, 7, 10, 11],
    [9, -1, 0]
]

for inp in inps:
    print(solution(inp))