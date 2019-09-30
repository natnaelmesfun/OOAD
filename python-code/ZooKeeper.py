#!/usr/bin/env python
# coding: utf-8

# In[3]:

from Animals import Animals

class ZooKeeper:
#     Zoo keeper performs his duty through different methods listed below.
#     Each method takes it animal object as a parameter so it can ask corresponding move for animals to behave
#     when Zoo Keeper executes certain action.


    def wake(self, Animals):
        print("wake animals")
        Animals.wakingUp()

    def rollCall(self, Animals):
        print("Calling animals")
        Animals.makeNoise()

    def feed(self, Animals):
        print("feed animals")
        Animals.eat()

    def exercise(self, Animals):
        print("exercise animals")
        Animals.roam()

    def shut(self, Animals):
        print("Shut the zoo")
        Animals.sleep()

