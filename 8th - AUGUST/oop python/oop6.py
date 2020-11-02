class Book:
    def __init__(self,title,author):
        self.author = author
        self.title = title

    def __str__(self):
        return '"{}" by {}'.format(self.title,self.author)

class PaperBook(Book):
    def __init__(self,author,title,numPages):
        Book.__init__(self,author,title)
        self.numPages = numPages

    def __str__(self):
        return '"{}" by {} ({} pages)'.format(self.title,self.author,self.numPages)



class Ebook(Book):
    def __init__(self,author,title,fileSize):
        Book.__init__(self,author,title)
        self.fileSize = fileSize

    def __str__(self):
        return '"{}" by {} ({} mb)'.format(self.title,self.author,self.fileSize)

b1 = Book("Fluent Python", "Hakimi Hamzan")
print(b1)

pb1 = PaperBook("Cracking Life", "Hakimi Hamzan", 450)
print(pb1)

pb2 = PaperBook("Good Guy", "Hakimi Hamzan", 350)
print(pb2)

eb1 = Ebook("Nerve Wrecking", "Hakimi Hamzan", 3)
print(eb1)

eb2 = Ebook("Speechless", "Hakimi Hamzan", 2)
print(eb2)


class Library:
    def __init__(self):
        self.library = []

    def addBook(self, book):
        self.library.append(book)

    def totalBook(self):
        return len(self.library)

newLibrary = Library()
newLibrary.addBook(b1)
newLibrary.addBook(pb1)
newLibrary.addBook(pb2)
newLibrary.addBook(eb1)
newLibrary.addBook(eb2)

print("Total number of books currently stored is {}".format(newLibrary.totalBook()))
