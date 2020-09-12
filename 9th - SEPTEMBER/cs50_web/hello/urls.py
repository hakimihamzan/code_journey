from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('1', views.index2, name='index2'),
    path('greet/<str:name3>', views.greet2, name='greet2'),
    path('<str:name>', views.greet, name='greet'),
    path('brian', views.brian, name='brian'),
    path('david', views.david, name='david'),

]
