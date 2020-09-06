from django.urls import path
from django.views.generic import TemplateView

from . import views

app_name = 'autos'
urlpatterns = [
    path('', views.MainView.as_view(), name='all'),
    path('lookup/', views.MakeView.as_view(), name='make_list'),
    path('main/create/', views.AutosCreate.as_view(), name='auto_create'),
    path('lookup/create', views.MakeCreate.as_view(), name='make_create'),
    path('main/<int:pk>/update', views.AutosUpdate.as_view(), name='auto_update'),
    path('lookup/<int:pk>/update', views.MakeUpdate.as_view(), name='make_update'),
    path('main/<int:pk>/delete', views.AutosUpdate.as_view(), name='auto_delete'),
    path('lookup/<int:pk>/delete', views.MakeUpdate.as_view(), name='make_delete'),

]
