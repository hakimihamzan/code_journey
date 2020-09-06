import re

hand = open('mbox-short.txt')
for x in hand:
    x = x.rstrip()
    #if re.search('From:', x):
        #print(x)

#startswith === ^ (caret return 'from')
    #if re.search('^From', x):
        #print(x)

# . means any characters ///  * means zero or more times
    #if re.search('^X.*:', x):
        #print(x)

# \S means non white space /// + means one or more time

# both (* and +) are greedy   ? dont be greedy  () means start extracting
    #if re.search('^X-\S+', x):
        #print(x)

# [^ ] means everything but a space ... if acharacter inside bracket has ^ means
#                                       not space
    y = re.findall('^From .*@([^ ]*)', x)
    print(y)
    type(y
    )

print('done')
