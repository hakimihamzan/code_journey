import requests

base_url = "https://tastedive.com/api/similar"
param = {}
param['q'] = 'Black panther'
param['limit'] = '5'

page = requests.get(base_url, params=param)
print(page.url)
print(page.text)
 
