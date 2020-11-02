import sqlite3
import json

connection = sqlite3.connect('datamuse_file.db')
cursor = connection.cursor()

full_string = 'https://api.datamuse.com/words-rel_rhy-happy'

cursor.execute("SELECT * FROM data WHERE full_string= ?",
        (full_string, ))

row = cursor.fetchone()
py_data = json.loads(row[2])
print(json.dumps(py_data, indent = 4)) #list of dictionaries
for x in py_data:
    print(x['word']s)


connection.commit()
