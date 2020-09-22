#! python3
# add wikipedia bulletspoints to the start
# of each line in the clipboard

import pyperclip
text = pyperclip.paste()
# TODO:
lines = text.split('\n')
for i in range(len(lines)):
    lines[i] = '* ' + lines[i]

text = '\n'.join(lines)
pyperclip.copy(text)
