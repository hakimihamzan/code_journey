name = input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"
handle = open(name)

count = 0
enil = list()
this = dict()

for lin in handle:
    if lin.startswith('From '):
        count = count + 1
        pew = lin.split()
        now = pew[5]
        new = now[:2]
        enil.append(new)
#print(enil)
for  x in enil:
    this[x] = this.get(x, 0) + 1

for k,v in sorted(this.items()):
    print(k,v)
