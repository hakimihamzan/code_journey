x = 1
print(type(x))

def hello():
   print("hello")

print(type(hello))
------------------
string = "hello"
print(string.upper())
-----------------------------
class Dog:

   def __init__(self):
       pass

   def bark(self):
       print("bark")

   def add_one(self,x):
       return x + 1

d = Dog()
d.bark()
print(d.add_one(5))
print(type(d))
------------------------------
class Dog:

   def __init__(self, name):
       self.name = name

   def bark(self):
       print("bark")

   def add_one(self,x):
       return x + 1

d = Dog("Tim")
print(d.name)
d2 = Dog("mark")
print(d2.name)
-----------------------

class Dog:

   def __init__(self, name, age):
       self.name = name
       self.age = age

   def get_name(self):
       return self.name

   def get_age(self):
       return self.age

   def set_age(self, age):
       self.age = age



d = Dog("Tim",34)
print(d.get_age())
d.set_age(24)
print(d.get_age())
#-------------------------------

class Student:
    def __init__(self,n,a,g):
        self.name = n
        self.age = a
        self.grade = g

    def get_grade(self):
        return self.grade

class Course:
    def __init__(self,n,m):
        self.name = n
        self.max_students = m
        self.students = []

    def add_student(self, student):
        if len(self.students) < self.max_students:
            self.students.append(student)
            return True
        return False

    def get_average_grade(self):
        value = 0
        for student in self.students:
            value += student.get_grade()

        return value / len(self.students)

s1 = Student("Tim",19,100)
s2 = Student("Bill",20,100)
s3 = Student("Kimi",27,100)

course = Course("Science",2)
course.add_student(s1)
course.add_student(s2)
print(course.add_student(s3))
print(course.get_average_grade())
