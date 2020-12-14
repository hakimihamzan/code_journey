from django.shortcuts import render
import random
import qrcode

otp = 0

# Create your views here.
def openLoginPage(request):
    return render(request, "login.html")

def validateUser(request):
    username = request.POST.get("t1")
    password = request.POST.get("t2")

    if username == "kimi" and password == "mejan":
        #create qr
        randomNum = random.randint(1000000,9999999)
        global otp
        otp = randomNum
        qrpic = qrcode.make("OTP :"+str(randomNum))
        qrpic.save(r"assets/qrcode.jpg")
        return render(request, "qrcode_page.html")

    else:
        return render(request, "login.html", {"message":"Invalid User"})

def validateOtp(request):
    user_otp = request.POST.get("otp")
    if user_otp == str(otp):
        #open welcome
        return render(request, "welcome.html")
    else:
        return render(request, "login.html", {"message":"Invalid OTP"})

    return None
