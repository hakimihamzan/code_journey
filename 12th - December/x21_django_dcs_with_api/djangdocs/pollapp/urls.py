from django.urls import include, path
from rest_framework import routers


from . import views


router = routers.DefaultRouter()
router.register(r'students', views.StudentViewSet)


app_name = 'pollapp'
urlpatterns = [
    # ex: /polls/
    path('polls/', views.pollindex, name='pollindex'),
    # ex: /polls/5/
    path('polls/<int:question_id>', views.polldetail, name='polldetail'),
    # ex: /polls/5/results/
    path('polls/<int:question_id>/results/', views.results, name='results'),
    # ex: /polls/5/vote/
    path('polls/<int:question_id>/vote/', views.vote, name='vote'),

    path('', views.allindex, name='allindex'),

    path('student/', views.studentlist, name="student"),

    path('api', include(router.urls)),
    path('api-auth/', include('rest_framework.urls', namespace='rest_framework')),
]
