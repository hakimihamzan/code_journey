from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.
def index(request):
    return render(request, "hello/index.html")

def index2(request):
    return render(request, "hello/index2.html")

def brian(request):
    return HttpResponse('Hello, brian')

def david(request):
    return HttpResponse('Hello, David')

def greet(request, name):
    return HttpResponse(f"<h1>Hello, {name.capitalize()}</h1>")

def greet2(request, name3):
    return render(request, "hello/greet.html", {
        "name3": name3.capitalize()
    })
