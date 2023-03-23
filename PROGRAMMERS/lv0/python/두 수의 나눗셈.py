def solution(num1, num2):
    return int(num1 / num2 * 1_000)

inps = [
    [3, 2],
    [7, 3],
    [1, 16]
]

for (n1, n2) in inps:
    print(solution(n1, n2))