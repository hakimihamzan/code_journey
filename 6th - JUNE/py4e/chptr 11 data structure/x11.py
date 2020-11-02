import re
fhand = open('regex_sum_681345.txt')
lew = list()
for lin in fhand:
    if re.search('[0-9]+', lin):
        y = re.findall('[0-9]+', lin)
        lew.extend(y)
lew = [int(i) for i in lew]
print(sum(lew))
