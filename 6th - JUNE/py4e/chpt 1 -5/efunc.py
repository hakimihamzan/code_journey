hrs = input("Enter Hours: ")
rte = input("Enter Rate: ")
hoursFloat = float(hrs)
rateFloat = float(rte)



def computepay(x,y):
    if hoursFloat > 40:
        hoursRemain = (hoursFloat-40)
        totalPayment = (40*rateFloat) + (1.5*hoursRemain*rateFloat)
        return totalPayment

    else:
        totalPayment2 = hoursFloat*rateFloat
        return totalPayment2

print("Pay: ", computepay(hoursFloat, rateFloat))
