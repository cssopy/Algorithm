def solution(my_string, n):
    return ''.join(i*n for i in my_string)

inps = [
    ["hello", 3]
]

for (s, n) in inps:
    print(solution(s, n))