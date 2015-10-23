
start = "TOON"

target = "PLEA"

dict = ["POON", "COON", "ALEE", "PLEE", "SAME", "LOIE", "POIE", "PLEA", "PLIE", "POIN"]

next = [start]
depth = 0

while len(next) != 0:
    curr = next.pop()
    if curr == target:
        break

    for word in dict:
        num_diff = 0
        for idx, c in enumerate(word):
            if c != curr[idx]:
                num_diff += 1
        if num_diff == 1:
            dict.remove(word)
            next.append(word)

    print next
    depth += 1

print depth
