from django.shortcuts import get_object_or_404, render

from .models import Question, Student
from rest_framework import viewsets
from .serializers import HeroSerializer, StudentSerializer


class StudentViewSet(viewsets.ModelViewSet):
    queryset = Student.objects.all().order_by('name')
    serializer_class = StudentSerializer


def allindex(request):
    return render(request, 'pollapp/allindex.html')

def pollindex(request):
    latest_question_list = Question.objects.order_by('-pub_date')[:5]
    context = {'latest_question_list': latest_question_list}
    return render(request, 'pollapp/index.html', context)

def polldetail(request, question_id):

    question = get_object_or_404(Question, pk=question_id)
    return render(request, 'pollapp/detail.html', {'question': question})

def results(request, question_id):
    response = "You're looking at the results of question %s."
    return HttpResponse(response % question_id)

def vote(request, question_id):
    return HttpResponse("You're voting on question %s." % question_id)

def studentlist(request):
    student = Student.objects.all()
    context = {'student': student}
    return render(request, 'pollapp/student_list.html', context)

def studentlistdetail(request, question_id):
    student = Question.objects.all()
    context = {'student': student}
    return render(request, 'pollapp/studentlist.html', context)
