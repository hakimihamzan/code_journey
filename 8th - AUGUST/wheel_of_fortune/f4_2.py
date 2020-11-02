import json
import random

def spinWheel():
    with open("wheel.json", 'r') as f:
        wheel = json.loads(f.read())
        return random.choice(wheel)

print(spinWheel())


#read json to give out random prize
  
