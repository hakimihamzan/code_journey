fname = input("Enter file name: ")
fh = open(fname)
lst = list(fh)
one = lst[0].strip().split()
two = lst[1].strip().split()
tree = lst[2].strip().split()
four = lst[3].strip().split()
#one.sort()
pew = one+two+tree+four
for element in word:
    if element in lst:
        print(element)
        continue
    else:
        lst.append(element)
lst.sort()


print(lst)
