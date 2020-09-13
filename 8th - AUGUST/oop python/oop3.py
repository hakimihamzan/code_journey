class Person:
   numberOfPeople = 0

   def __init__(self, name):
       self.name = name

p1 = Person("Tim")
print(p1.numberOfPeople)
Person.numberOfPeople = 2
print(p1.numberOfPeople)
print(Person.numberOfPeople)

p2 = Person("Jill")

Person.numberOfPeople = 8
print(p1.numberOfPeople)
print(p2.numberOfPeople)
---------------------------------

##class Person:
##    numberOfPeople = 0
##
##    def __init__(self, name):
##        self.name = name
##        Person.numberOfPeople += 1
##
##print(Person.numberOfPeople)
##p1 = Person("Tim")
##print(Person.numberOfPeople)
##
##p2 = Person("Jill")
##print(Person.numberOfPeople)
#--------------------------------------------
class Person:
    number_of_people = 0

    def __init__(self, name):
        self.name = name
        Person.add_person()

    @classmethod # decorator
    def number_of_people_(cls):
        return cls.number_of_people

    @classmethod
    def add_person(cls):
        cls.number_of_people += 1


p1 = Person("Tim")
p2 = Person("Jill")
print(Person.number_of_people_())
