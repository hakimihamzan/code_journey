
import csv  # https://docs.python.org/3/library/csv.html

# python3 manage.py shell < many/load.py

#from .models import Person, Course, Membership

fhand = open('load.csv')
reader = csv.reader(fhand)


# Format
# jane@tsugi.org,I,Python
# ed@tsugi.org,L,Python

for row in reader:
    print(row[0])

    


