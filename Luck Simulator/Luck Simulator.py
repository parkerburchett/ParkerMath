# this is ment to simulate the relative importance of luck in highly competive spaces

import random
import numpy as np


class Person():

    def __init__(self, competence, luck):
        self.competence =competence
        self.luck = luck

    def get_score(self):
        return int(.05*self.luck +.95*self.competence)

def get_score(a_person):
        return int(.05*a_person.luck +.95*a_person.competence)

competence_scores = np.random.normal(loc=50, scale=10, size=10000)

luck_scores = np.random.randint(0,100,100000)

# this is bad syntax but it does not matter. It works and it is just to prove a concept
persons_score_tuple =[]
persons = []

for i in range(10000):
    a_person = Person(competence_scores[i],luck_scores[i])
    score = a_person.get_score()
    persons.append(a_person)
    persons_score_tuple.append((a_person,score))


persons.sort(key=get_score, reverse=True)


for i in persons[:10]:
    luck = i.luck
    comp = int(i.competence)
    score = i.get_score()
    print('Competence {} Luck {} Weighted Score {}'.format(comp,luck,score))



print('fin')


