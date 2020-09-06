while True:
    print("Enter your age:")
    age = input()
    if age.isdecimal():
        break
    print('Please enter a number for your age')

while True:
    print('Select a new password (letters and numbers only):')
    pw = input()
    if pw.isalnum():
        break
    print("Password only have letters and numbers")
