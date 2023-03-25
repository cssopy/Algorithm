def solution(angle):
    if(angle<=90):
        return 1 if angle<90 else 2
    return 3 if angle<180 else 4

inps = [
    70,
    91,
    180
]

for inp in inps:
    print(solution(inp))