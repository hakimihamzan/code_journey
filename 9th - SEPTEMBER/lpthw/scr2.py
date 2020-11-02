#
# post
import requests

payload = {'title': "yehaa", 'description': 'we win'}
r = requests.post('http://127.0.0.1:8000/apis/v1/', data=payload)

print(r)



#update part
import requests

payload = {'title': "yehaa", 'description': 'we win34'}
r = requests.put('http://127.0.0.1:8000/apis/v1/18', data=payload)

print(r)


#delete
#
import requests

r = requests.delete('http://127.0.0.1:8000/apis/v1/17')
print(r)


#create
