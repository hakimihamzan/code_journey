#exercise 7.2

fname = input("Enter file name: ")
fh = open(fname)
count = 0
total = 0
for line in fh:
    if not line.startswith("X-DSPAM-Confidence:") :
        continue
    count = count + 1
    lineonly = (((line.rstrip()).replace("X-DSPAM-Confidence:"," ")).lstrip())
    #print(lineonly)
    #repla = lineonly.replace("X-DSPAM-Confidence:"," ")
    #print(repla)
    #num = lineonly.lstrip()
    newe = float(lineonly)
    total = total + newe
    #print(repr(lineonly))

print(total/count)


    #print(ave)


print("Done")
