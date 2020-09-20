import requests, time
r = requests.post('http://pretty-printed-request-bin.herokuapp.com/1k35scn1', json={"ts":time.time(), 'hello': 'kimi'})
print(r.status_code)
print(r.content)
