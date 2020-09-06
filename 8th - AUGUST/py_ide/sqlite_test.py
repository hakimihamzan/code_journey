import sqlite3
conn = sqlite3.connect('sqlite_test.db')
cursor = conn.cursor()

#cursor.execute('CREATE TABLE data (id INTEGER PRIMARY KEY, result TEXT)')

cursor.execute('INSERT INTO data Values(?,?)', (1,'Donald'))

conn.commit()
