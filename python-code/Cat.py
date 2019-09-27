import random

class Cat:
    def __init__(self,name):
        self.name = name

def makeNoise():
    x = random.random()
    if(x <= 0.5):
        makeNoise1()
    else: 
        makeNoise2()

def makeNoise1(self):
    print("My type is", self.getClass(), " ", self.name, "Me_yao")

def makeNoise2(self):
    print("My type is", self.getClass(), " ", self.name, "Hello")
