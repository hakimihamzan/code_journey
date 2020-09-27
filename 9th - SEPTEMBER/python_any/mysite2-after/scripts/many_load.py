import csv  # https://docs.python.org/3/library/csv.html

# https://django-extensions.readthedocs.io/en/latest/runscript.html

# python3 manage.py runscript many_load

from unesco.models import Site, Category, State, Region, Iso


def run():
    fhand = open('unesco/load.csv')
    reader = csv.reader(fhand)
    next(reader)  # Advance past the header

    Site.objects.all().delete()
    Category.objects.all().delete()
    State.objects.all().delete()
    Region.objects.all().delete()
    Iso.objects.all().delete()


    # Format
# name,description,justification,year,longitude,latitude,area_hectares,category,states,region,iso
    # jane@tsugi.org,I,Python
    # ed@tsugi.org,L,Python

    for row in reader:
        print(row)

        c, created = Category.objects.get_or_create(name=row[7])
        s, created = State.objects.get_or_create(name=row[8])
        r, created = Region.objects.get_or_create(name=row[9])
        i, created = Iso.objects.get_or_create(name=row[10])

        try:
            year=int(row[3])
        except:
            year=None

        try:
            longitude=float(row[4])
        except:
            longitude=None

        try:
            latitude=float(row[5])
        except:
            latitude=None

        if row[6]=="":
            hect=None
        else:
            hect=float(row[6])

        try:
            desc=row[2]
        except:
            desc=None

        try:
            just=row[2]
        except:
            just=None


        site = Site(name=row[0], description=desc, justification=just, year=year,
                    longitude=longitude, latitude=latitude, area_hectares=hect, category=c, states=s, region=r, iso=i )

        site.save()
