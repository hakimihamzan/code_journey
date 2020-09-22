import requests
import json
import sqlite3


def get_api_data(base_url, param):

    #database connection/create table
    connection = sqlite3.connect('datamuse_file.db')
    cursor = connection.cursor()
    cursor.execute('''
    CREATE TABLE IF NOT EXISTS data (full_string TEXT, page_url TEXT, result TEXT)''')
    #check if get_request already in database
    string_1 = [x+'-'+param[x] for x in param]
    full_string = base_url + '-' + string_1[0]

    cursor.execute("SELECT * FROM data WHERE full_string= ?",
        (full_string, ))
    
    row = cursor.fetchone()
    if row is not None:
        print("Info found in database")
    else:
        print('Adding data to database\n')

        page = requests.get(base_url, params = param)
        print("------printing up to 300 characters-----")
        print(page.text[:300])
        print()
        print("Full URL")
        print(page.url)
        print()
        print("Identifier")
        print(full_string)
        
        
        cursor.execute('''
        INSERT INTO data (full_string, page_url, result) Values(?,?,?)''',
        (full_string,page.url,page.text))



    connection.commit()

param = {'rel_rhy':'death'}    
get_api_data("https://api.datamuse.com/words", param)
