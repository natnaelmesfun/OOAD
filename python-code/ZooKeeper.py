#!/usr/bin/env python
# coding: utf-8

# In[3]:


class ZooKeeper:
#     Zoo keeper performs his duty through different methods listed below.
#     Each method takes it animal object as a parameter so it can ask corresponding move for animals to behave
#     when Zoo Keeper executes certain action.


    def wake(animal):
        print("wake animals")
        animal.wakingUp()

    def rollCall(animal):
        print("Calling animals")
        animal.makeNoise()

    def feed(animal):
        print("feed animals")
        animal.eat()

    def exercise(animal):
        print("exercise animals")
        animal.roam()

    def shut(animal):
        print("Shut the zoo")
        animal.sleep()

