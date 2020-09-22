CURREN = 2020
class Person:
    def __init__(self,x,y):
        self.name = x
        self.year_born = y

    def getAge(self):
        return CURREN - self.year_born

    def __str__(self):
        return "{} ({})".format(self.name,self.getAge())
    
class Student(Person):
    def __init__(self,x,y):
        Person.__init__(self,x,y)
        self.knowledge = 0

    def study(self):
        self.knowledge += 1


s1 = Student("Alice",1993)
print(s1)
print("{}'s knowledge is {}".format(s1.name,s1.knowledge))

s1.study()
print("{}'s knowledge is {}".format(s1.name,s1.knowledge))
