from django.contrib import admin

# Register your models here.
from .models import Question, Choice, Hero, Student, Eventname

admin.site.register(Question)
admin.site.register(Choice)
admin.site.register(Hero)
admin.site.register(Student)
admin.site.register(Eventname)
