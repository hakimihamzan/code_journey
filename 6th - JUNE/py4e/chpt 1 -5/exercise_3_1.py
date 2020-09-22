hrs = input("Enter Hours: ")
rate = input("Enter Rate: ")


try:
    hoursFloat = float(hrs)
    rateFloat = float(rate)

except:
    print("Error. Please enter numeric input")
    quit()

if hoursFloat > 40 :
    hoursRemain = hoursFloat - 40
    totalPayment = (40 * rateFloat) + (1.5 * rateFloat * hoursRemain)
    print(totalPayment)

else :
    totalPayment2 = hoursFloat * rateFloat
    print(totalPayment2)
