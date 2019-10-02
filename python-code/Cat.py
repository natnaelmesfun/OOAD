import random
from Feline import Feline 
from Animals import *

class Cat(Feline):
    def __init__(self,name):
        self.name = name
        self.sound = hissNoise()
        

    # def makeNoise(self):
    #     x = random.random()
    #     if(x <= 0.5):
    #         self.makeNoise1()
    #     else: 
    #         self.makeNoise2()

    def makeNoise1(self):
        print("My type is", self.__class__.__name__, " ", self.name, "Me_yao")

    def makeNoise2(self):
        print("My type is", self.__class__.__name__, " ", self.name, "Hello")
