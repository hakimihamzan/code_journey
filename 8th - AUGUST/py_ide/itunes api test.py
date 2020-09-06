import requests
import json

param = {'term':'Ann Arbor','entity':'podcast'}
page = requests.get("https://itunes.apple.com/search", params=param)

py_data = json.loads(page.text)
print(len(py_data))

print(page.url)
print(page.text[0:500])
