def solution(price):
    dis = [[500_000, 0.8], [300_000, 0.9], [100_000, 0.95]]
    for (v, r) in dis:
        if(price >= v): return int(price*r)
    return price

inps = [
    150_000,
    580_000
]

for inp in inps:
    print(solution(inp))