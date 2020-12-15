import datetime
from django.db import models
from django.utils import timezone

class Question(models.Model):
    question_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')

    def __str__(self):
        return self.question_text

    def was_published_recently(self):
        return self.pub_date >= timezone.now() - datetime.timedelta(days=1)


class Choice(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)

    def __str__(self):
        return self.choice_text

class Hero(models.Model):
    name = models.CharField(max_length=60)
    alias = models.CharField(max_length=60)

    def __str__(self):
        return self.name

class Eventname(models.Model):
    # student = models.ForeignKey(Student, on_delete=models.CASCADE)
    event_name = models.CharField(max_length=60)

    def __str__(self):
        return self.event_name



class Student(models.Model):
    name = models.CharField(max_length=60)
    matrix_number = models.CharField(max_length=10)
    program_course = models.CharField(max_length=60)
    class_attended = models.CharField(max_length=60)
    class_lecturer = models.CharField(max_length=60)
    event_name = models.ForeignKey(Eventname, on_delete=models.CASCADE)

    def __str__(self):
        return self.name
