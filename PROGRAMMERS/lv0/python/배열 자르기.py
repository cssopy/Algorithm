def solution(numbers, num1, num2):
    return numbers[num1:num2+1]

inps = [
    [[1, 2, 3, 4, 5], 1, 3],
    [[1, 3, 5], 1, 2]
]

for (ns, n1, n2) in inps:
    print(solution(ns, n1, n2))