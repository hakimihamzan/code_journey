import random
import qrcode

x = random.randint(1000000,9999999)

im = qrcode.make("OTP is"+str(x))
im.show()
