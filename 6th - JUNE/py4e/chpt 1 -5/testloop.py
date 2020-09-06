n = 10
while n > 0:
    print(n)
    n -= 1
print("blastoff")
print(n)
print(' ')


tot = 0
for i in [5,1,3,4,2,9,0,0,9,1]:
    tot += 1
print(tot)

while True:
    lol = input('Enter something: ')
    if lol[0] == '#':
        continue
    if lol == 'done':
        break
    print(lol)
print('Done!')
