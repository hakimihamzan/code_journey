import requests

base_url = "https://tastedive.com/api/similar"
para = {'q':'bridesmaid', 'type':'movies', 'limit':'5'}
page = requests.get(base_url,params=para)
print(page.text)
