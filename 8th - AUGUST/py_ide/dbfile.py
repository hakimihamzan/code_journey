import sqlite3

connection = sqlite3.connect('datatest_file.db')
connection.row_factory = sqlite3.Row
cursor = connection.cursor()
cursor.execute('''
CREATE TABLE IF NOT EXISTS data (full_string TEXT, page_url TEXT, result TEXT)''')

##cursor.execute('''
##    INSERT INTO data (full_string, page_url, result) Values(?,?,?)''',
##              ('ley','is','handsome'))

full_string = 'try'

cursor.execute("SELECT * FROM data WHERE full_string= ?",
        (full_string, ))
row = cursor.fetchone()
if row is not None:
    print(row.keys())
else:
    print('Full string doesnt exist')

##cursor.execute("select * from data where full_string = 'ley'")
##row = cursor.fetchone()
##for x in row:
##    print(x)


connection.commit()
