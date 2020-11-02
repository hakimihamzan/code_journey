import urllib.request, urllib.parse, urllib.error
import json


while True:

    address = input('Enter url:')
    if len(address) < 1: break

    print('Retrieving', address)
    url = urllib.request.urlopen(address)

    data = url.read().decode()

    info = json.loads(data)
    lewlst = list()

    for elin in info["comments"]:
        #print(elin["count"])
        lewlst.append(elin["count"])
    lewlst = [int(i) for i in lewlst]

    print('Retrieved', len(data), 'characters')

    print('Count:', len(info["comments"]))
    print("Sum: ", sum(lewlst))
