#prompt for file name

fname = input('Enter a name:')

try:
    fhand = open(fname)
except:
    print('Fail to open such file.', fname, 'does not exists')
    quit()
count = 0
for line in fhand:
    if line.startswith('Subject: ') :
        count = count + 1
print('There were', count, 'subject lines in', fname)
