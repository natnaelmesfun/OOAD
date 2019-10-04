from Animals import Animals

class Feline(Animals):
    def __init__(self, name):
        self.name = name

    def hasTails(self):
        print(self.name, " have tail.")

    # def makeNoise():
        # print("Feline making noise")
