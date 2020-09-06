import requests
import json

def get_rhymes(wrd):
    base_url = "https://api.datamuse.com/words"
    param_dict = {}
    param_dict['rel_rhy'] = wrd
    param_dict['max'] = '3'
    page_get = requests.get(base_url, params=param_dict)
    json_ver = page_get.json()
    print(json_ver)
    #to print pretty json from requests::: below
    print(json.dumps(json_ver, indent=4))
    return [di['word'] for di in json_ver]








print(get_rhymes("awesome"))
print(get_rhymes("bad"))
print(get_rhymes("super"))
