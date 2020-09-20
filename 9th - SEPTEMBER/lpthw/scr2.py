import requests

payload = {'username': "kimi", 'password': 'poass'}
r = requests.post('https://httpbin.org/post', data=payload)

r_dict = r.json()
print(r_dict['form'])
print(r.url)
