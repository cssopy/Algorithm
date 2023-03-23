def solution(slice, n):
    return (n-1) // slice + 1

inps = [
    [7, 10],
    [4, 12]
]

for inp in inps:
    print(solution(inp[0], inp[1]))