def solution(n):
    s = set()
    
    for v in range(1, int(n**0.5)+1):
        if(n%v==0):
            s.add(v)
            s.add(n/v)
            
    return len(s)

inps = [
    20,
    100
]

for inp in inps:
    print(solution(inp))