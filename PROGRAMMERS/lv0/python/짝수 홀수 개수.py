def solution(num_list):
    ans = [0, 0]

    for num in num_list:
        ans[num%2] += 1

    return ans

inps = [
    [1, 2, 3, 4, 5],
    [1, 3, 5, 7]
]

for inp in inps:
    print(solution(inp))