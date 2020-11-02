text = "X-DSPAM-Confidence:    0.8475";
space = text.find(' ')
host = text[space:]
int = float(host.strip())
print(int)
