fname = input("Enter file name: ")
fh = open(fname)
lst = list()
for line in fh:
    eline = line.rstrip().split()
    #print(eline)
    for x in eline:
        if x in lst:
            print(x)
            continue
        else:
            lst.append(x)
lst.sort()
print(lst)
