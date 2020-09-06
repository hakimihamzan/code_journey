import urllib.request, urllib.parse, urllib.error
import ssl
import xml.etree.ElementTree as ET

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

while True:
    address = input('Enter location:')
    if len(address) < 1: break

    print('Retrieving', address)
    uh = urllib.request.urlopen(address, context=ctx)

    data = uh.read().decode()
    print('Retrieved', len(data), 'characters')

    tree = ET.fromstring(data)
    lst = tree.findall('comments/comment')
    print('User count:', len(lst))

    lewlst = list()

    for meh in lst:
        x = meh.find('count').text
        #print(x)
        lewlst.append(x)
    lewlst = [int(i) for i in lewlst]
    print('Sum:', sum(lewlst))

    print('done')
