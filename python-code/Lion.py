#!/usr/bin/env python
# coding: utf-8

# In[1]:


from Feline import Feline

class Lion(Feline):
    
#     Creates constructor that takes in String name

    def __init__(self, name):
        self.name = name
        
#     overrides the makeNoise() method from the Feline class

    def makeNoise(self):
        print(self.__class__.__name__, self.name, " growling")