def solution(age):
    return ''.join(map(lambda x:chr(int(x)+ord('a')), str(age)))

inps = [
    23,
    51,
    100
]

for inp in inps:
    print(solution(inp))