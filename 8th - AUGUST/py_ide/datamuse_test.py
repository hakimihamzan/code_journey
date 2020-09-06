import requests
import json
import sqlite3

#create database to store aapi data
conn = sqlite3.connect('api_test.db')
cursor = conn.cursor()
cursor.execute('''
CREATE TABLE IF NOT EXISTS data (py_queries TEXT, result TEXT)''')



page = requests.get("https://api.datamuse.com/words?rel_rhy=funny")
py_queries = page.url
cursor.execute('''
INSERT INTO data (py_queries, result) Values(?,?)''',
               (memoryview(py_queries.encode()), memoryview(page.text.encode()) ) )

print(type(page))
print(' ')
print(page.text[:150])
print(' ')
print(page.url)

json_ver = page.json()
print(json_ver[5])

print(json.dumps(json_ver, indent=4))
 

conn.commit()
