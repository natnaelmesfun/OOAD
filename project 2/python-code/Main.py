from Cat import Cat
from Lion import Lion
from ZooKeeper import ZooKeeper
from zooAnouncer import zooAnouncer
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

        shelly = zooAnouncer()
        shelly.subscribe(john)
        
        
        john.wake(store)
        john.rollCall(store)
        john.feed(store)
        john.exercise(store)
        john.shut(store)


        shelly.unsubscribe(john)

#  Got Help from TA Manjunaht
