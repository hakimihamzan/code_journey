# Given a phrase and a list of guessed letters, returns an obscured version
# Example:
LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'


guessed = ['L', 'B', 'E', 'R', 'N', 'P', 'K', 'X', 'Z', 'O']
phrase = "GLACIER NATIONAL PARK"
#returns> "_L___ER N____N_L P_RK"
def obscurePhrase(phrase, guessed):
    rv = ''
    for s in phrase:
        if (s in LETTERS) and (s not in guessed):
            rv = rv+'_'
        else:
            rv = rv+s
    return rv

print(obscurePhrase(phrase, guessed))
