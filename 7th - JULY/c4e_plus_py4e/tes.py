def stop(lst):
    nn = []
    coun = 0
    while coun < len(lst):
        if lst[coun] != 4:
            nn.append(lst[coun])
        else:
            return nn
        coun = coun + 1
    return nn

l = [4,11,5,6,3,2,56,4]

print(stop(l))