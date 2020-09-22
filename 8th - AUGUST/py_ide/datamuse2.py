import requests
import json

kval_pairs = {'rel_rhy': 'piece'}
page = requests.get("https://api.datamuse.com/words", params=kval_pairs)
print(page.text[:200])
print(page.url)
