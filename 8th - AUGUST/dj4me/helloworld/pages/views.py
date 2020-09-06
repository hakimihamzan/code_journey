from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.
def homePageView(request):
    return HttpResponse('Hello, World!')

def test1(request):
    return HttpResponse('test1 succeed!')

def test2(request):
    return HttpResponse('fehee')
