from Cat import Cat
from Lion import Lion
from ZooKeeper import ZooKeeper
from Animals import Animals
from Feline import Feline


class Main:
    if __name__ == '__main__':
        catie = Cat("catie")
        canny = Cat("cannie")
        lune = Lion("Lune")
        larry =Lion("Larry")
        john = ZooKeeper()

        store = [catie, canny, lune, larry]
        
        for i in range(len(store)):
            john.wake(store[i])
            john.rollCall(store[i])
            john.feed(store[i])
            john.exercise(store[i])
            john.shut(store[i])

