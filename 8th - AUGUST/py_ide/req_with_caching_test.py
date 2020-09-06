import requests_with_caching

res = requests_with_caching.get("https://api.datamuse.com/words?rel_rhy=happy", permananent_cache_file="datamuse_cache.txt")
print(res.text[:200])

