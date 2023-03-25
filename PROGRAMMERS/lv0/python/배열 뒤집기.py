def solution(num_list):
    return num_list[::-1]

inps = [
    [1, 2, 3, 4, 5],
    [1, 1, 1, 1, 1, 2],
    [1, 0, 1, 1, 1, 3, 5]
]

for inp in inps:
    print(solution(inp))