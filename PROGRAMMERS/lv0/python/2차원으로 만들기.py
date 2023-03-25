def solution(num_list, n):
    ans = []

    for v in range(0, len(num_list), n):
        ans.append(num_list[v:v+n])

    return ans

inps = [
    [[1, 2, 3, 4, 5, 6, 7, 8], 2],
    [[100, 95, 2, 4, 5, 6, 18, 33, 948], 3]
]

for (nl, n) in inps:
    print(solution(nl, n))