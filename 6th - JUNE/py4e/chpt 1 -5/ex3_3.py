score = input("Enter Score: ")
scr = float(score)

try:
    if scr >= 1.01:
        print("Number out of range!")

except:
    quit()


if scr >= 0.9 and scr <= 1.0:
        print("A")
elif scr >= 0.8 and scr <= 0.89:
        print("B")
elif scr >= 0.7 and scr <= 0.79:
        print("q")
elif scr >= 0.6 and scr <= 0.69:
        print("D")
elif scr < 0.6:
        print("F")
