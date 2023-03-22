def solution(array, height):
    return len(list(filter(lambda x:x>height, array)))

inps = [
    [[149, 180, 192, 170], 167],
    [[180, 120, 140], 190]
]

for (array, height) in inps:
    print(solution(array, height))