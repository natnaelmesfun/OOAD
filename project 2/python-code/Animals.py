#!/usr/bin/env python
# coding: utf-8

# In[5]:

#  Strategy pattern is applied

import abc
class makeNoise():
    def Noise(self): pass

class hissNoise(makeNoise):
    def Noise(self):
        return "hiss"

class growlNoise(makeNoise):
    def Noise(self):
        return "growl"

# sound variable is used to get the noise sound of different animals
class Animals:

    sound = None
    
    def __init__(self, name):
        self.name = name


    def makeNoise(self):
        print("My type is ", self.__class__.__name__, self.name, self.sound.Noise())

    def sleep(self):
        print("My type is ", self.__class__.__name__, self.name, " Going to sleep")
        
    def eat(self):
        print("My type is ", self.__class__.__name__, self.name, " Eating my meal")

    def roam(self):
        print("My type is ", self.__class__.__name__, self.name, " Moving around")

    def wakingUp(self):
        print("My type is ",  self.__class__.__name__, self.name, "good morning")

