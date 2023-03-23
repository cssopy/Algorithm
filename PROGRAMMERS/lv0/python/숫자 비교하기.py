def solution(num1, num2):
    return 1 if num1==num2 else -1

inps = [
    [2,	3],
    [11, 11],
    [7,	99]
]

for (n1, n2) in inps:
    print(solution(n1, n2))