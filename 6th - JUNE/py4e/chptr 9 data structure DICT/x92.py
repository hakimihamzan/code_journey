#hardest so far

name = input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"
handle = open(name)
enil = list()
snail = dict()

for lin in handle:
    if not lin.startswith('From: '): continue
    lol = lin.split()
    for x in lol:
        enil.append(x)

for name in enil:
    if name == 'From:':
        continue
    else:
        snail[name] = snail.get(name, 0) + 1

bigcount = None
bigname = None
for name,count in snail.items():
    if bigcount is None or count > bigcount:
        bigname = name
        bigcount = count

print(bigname, bigcount)
