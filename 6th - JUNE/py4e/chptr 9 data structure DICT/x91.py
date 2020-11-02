name = input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"
handle = open(name)
#count = 0
new = list()
count = dict()
newer = list()
lol = list()

for x in handle:
    if not x.startswith('From: '): continue
    new = x.split()
    newer = new[1]

    #print(newer.split())
    for polo in newer:
        if polo not in count:
            count[polo] = 1
        else:
            count[polo] = count[polo] + 1

    print(count)

    #count[name] = newer.split()
    #print(count)
