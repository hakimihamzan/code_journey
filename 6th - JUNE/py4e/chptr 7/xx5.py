#exercise 7.2

fname = input("Enter file name: ")
fh = open(fname)
count = 0
total = 0
for line in fh:
    if not line.startswith("X-DSPAM-Confidence:") :
        continue
    count = count + 1
    #use next two line to find total of sum number
    floax = float(line[20:-1].strip())
    total = total + floax

aver = total/count
print("Average spam confidence:", aver)


print("Done")
