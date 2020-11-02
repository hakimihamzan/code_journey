fruit = 'banana'
index = 0

while index < len(fruit):
    letter = fruit[index]
    print(index, letter)
    index += 1


fruit = 'banana'
for letter in fruit:
    print(letter)


s = 'Monty Python'
print(s[:2])
print(s[8:])
print(s[:])
