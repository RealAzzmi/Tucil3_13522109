import os
import glob

# Delete previous files

pattern = 'src/wordladder/dictionary/word_size_*.txt'
files_to_delete = glob.glob(pattern)

for file in files_to_delete:
    os.remove(file)
    print(f"Deleted file: {file}")

# Create new files

d = dict()

with open('src/wordladder/dictionary/dictionary_asisten.txt') as file:
    for line in file:
        line = line.strip()

        if len(line) in d:
            d[len(line)].append(line)
        else:
            d[len(line)] = [line]

for k, v in d.items():
    with open('src/wordladder/dictionary/word_size_' + str(k) + '.txt', 'x') as file:
        file.write('\n'.join(v))
    
