def solution(numbers):
    return sum(numbers)/len(numbers)

inps = [
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
    [89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]
]

for inp in inps:
    print(solution(inp))