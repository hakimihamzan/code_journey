class WOFPlayer:
    def __init__(self,name):
        self.name = name
        self.prizeMoney = 0
        self.prizes = []

    def addMoney(self,amt):
        self.prizeMoney = self.prizeMoney + amt

    def goBankrupt(self):
        self.prizeMoney = 0

    def addPrize(self, prize):
        self.prizes.append(prize)

    def __str__(self):
        return "{} (${})".format(self.name,self.prizeMoney)


class WOFHumanPlayer(WOFPlayer):
    def getMove(category, obscuredPhrase, guessed):
        print("""
        {} has ${}

        Category: {}
        Phrase:   {}
        Guessed:  {}""".format(self.name,self.prizeMoney, category, obscuredPhrase, ', '.join(sorted(guessed))))

        guess = input("Guess a letter, phrase, or type 'exit' or 'pass': ")
        return guess


class WOFComputerPlayer(WOFPlayer):
    SORTED_FREQUENCIES = 'ZQXJKVBPYGFWMUCLDRHSNIOATE'
    
    def __init__(self,name, difficulty):
        WOFPlayer.__init__(self, name)
        self.difficulty = difficulty
