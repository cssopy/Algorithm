def solution(array, n):
    return array.count(n)

inps = [
    [[1, 1, 2, 3, 4, 5], 1],
    [[0, 2, 3, 4], 1]
]

for (array, n) in inps:
    print(solution(array, n))