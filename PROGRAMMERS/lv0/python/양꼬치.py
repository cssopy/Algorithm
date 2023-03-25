def solution(n, k):
    return 12_000*n+(k-n//10)*2000

inps = [
    [10, 3],
    [64, 6]
]

for (n, k) in inps:
    print(solution(n, k))