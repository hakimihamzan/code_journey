from urllib.request import urlopen
from bs4 import BeautifulSoup
import ssl
import re

ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

url = input('Enter - ')
html = urlopen(url, context=ctx).read()
soup = BeautifulSoup(html, "html.parser")

tags = soup("span")
lew = list()
for elin in tags:
    x = elin
    for each in x:
        y = re.findall('[0-9]+', each)
        lew.extend(y)
lew = [int(i) for i in lew]
print(sum(lew))
