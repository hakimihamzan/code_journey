class Cat:
   def __init__(self,name,age):
       self.name = name
       self.age = age

   def speak(self):
       print("Meow")
##
##
##class Dog:
##    def __init__(self,name,age):
##        self.name = name
##        self.age = age
##
##    def speak(self):
##        print("Bark")
#---------------------------------------
##class Pet:
##    def __init__(self,name,age):
##        self.name = name
##        self.age = age
##
##    def show(self):
##        #print("I am {} and I am {} years old".format(self.name, self.age))
##        print(f"I am {self.name} and I am {self.age} years old")
##
##    def speak(self):
##        print("zzzzzzzzzzzz")
##
##class Cat(Pet):
##    def speak(self):
##        print("Meow")
##
##
##class Dog(Pet):
##    def speak(self):
##        print("Bark")
##
##class Fish(Pet):
##    pass
##
##
##p = Pet("Tim",19)
##p.show()
##
##c = Cat("Bill",34)
##c.speak()
##
##d = Dog("Jill",25)
##d.speak()
##
##f = Fish("Bub",10)
##f.speak()

#------------------------------------------
class Pet: #parent class
    def __init__(self,name,age):
        self.name = name
        self.age = age

    def show(self):
        #print("I am {} and I am {} years old".format(self.name, self.age))
        print(f"I am {self.name} and I am {self.age} years old")

    def speak(self):
        print("zzzzzzzzzzzz")

class Cat(Pet):
    def speak(self):
        print("Meow")


class Dog(Pet):
    def __init__(self,name,age,color):
        super().__init__(name,age) # super stands for class that we inherited
        self.color = color


    def speak(self):
        print("Bark")

    def show(self):
        #print("I am {} and I am {} years old".format(self.name, self.age))
        print(f"I am {self.name} and I am {self.age} years old. I am {self.color}")

class Fish(Pet):
    pass


p = Pet("Tim",19)
p.show()

c = Cat("Bill",34)
c.speak()

d = Dog("Jill",25,"brown")
d.show()

f = Fish("Bub",10)
f.speak()
