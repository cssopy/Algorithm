def solution(dot):
    if(dot[0]*dot[1] < 0):
        return 2 if dot[0]<0 else 4
    return 1 if dot[0]>0 else 3

inps = [
    [2, 4],
    [-7, 9]
]

for inp in inps:
    print(solution(inp))