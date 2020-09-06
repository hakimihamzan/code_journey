from django.urls import path
from .views import homePageView, test1, test2

urlpatterns = [
    path('', homePageView, name='home'),
    path('test1/', test1, name='test1'),
    path('test2/', test2, name='test2')


]
