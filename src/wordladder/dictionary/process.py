d = dict()
with open('words_alpha.txt') as file:
    for line in file:
        line = line.strip()

        if len(line) in d:
            d[len(line)].append(line)
        else:
            d[len(line)] = [line]

for k, v in d.items():
    with open('word_size_' + str(k) + '.txt', 'x') as file:
        file.write('\n'.join(v))
    
