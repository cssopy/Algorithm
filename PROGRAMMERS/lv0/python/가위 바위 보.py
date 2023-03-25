def solution(rsp):
    dic = {
        '2':'0',
        '0':'5',
        '5':'2'
    }
    return ''.join([dic[v] for v in rsp])

inps = [
    '2',
    '205'
]

for inp in inps:
    print(solution(inp))