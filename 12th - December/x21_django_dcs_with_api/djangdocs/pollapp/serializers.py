from rest_framework import serializers
from .models import Hero, Student

class HeroSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Hero
        fields = ('id', 'name', 'alias')

class StudentSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Student
        fields = ('id', 'name', 'matrix_number', 'program_course', 'class_attended', 'class_lecturer')
