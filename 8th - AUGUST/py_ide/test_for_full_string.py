param = {'rel_rhy':'cash'}
#print(param)
##for x in param:
##    string = x + "-" + param[x]
##    print(string)

lst = [x+'-'+param[x] for x in param]
print(lst[0])


base_url = "https://api.datamuse.com/words"

print(base_url+"-"+lst[0])
