fname = input("Enter file name: ")
if len(fname) < 1 :
    fname = "mbox-short.txt"

fh = open(fname)
count = 0
for x in fh:
    if not x.startswith("From:"): continue
    new = list()
    new = x.split()
    print(new[1])
    #y = x.rsplit()
    #print(y[1])
    count = count+ 1

print("There were", count, "lines in the file with From as the first word")
