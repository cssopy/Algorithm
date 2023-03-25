def solution(my_string, letter):
    return my_string.replace(letter, '')

inps = [
    ["abcdef",	"f"],
    ["BCBdbe",	"B"]
]

for (nl, n) in inps:
    print(solution(nl, n))