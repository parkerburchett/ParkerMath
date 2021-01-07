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

sample_size =100000

competence_scores = np.random.normal(loc=50, scale=10, size=sample_size)

luck_scores = np.random.randint(0,100,sample_size)



# this is bad syntax but it does not matter. It works and it is just to prove a concept
persons_score_tuple =[]
persons = []

for i in range(sample_size):
    a_person = Person(competence_scores[i],luck_scores[i])
    score = a_person.get_score()
    persons.append(a_person)
    persons_score_tuple.append((a_person,score))


persons.sort(key=get_score, reverse=True)
lucky_10 = []
comp_10 =[]
num_better_50_percent_luck = 0
num_better_90_percent_luck =0
print('When you have {} people trying to get into 10 slots:'.format(sample_size))
for i in persons[:10]:
    luck = i.luck
    if luck >=50:
        num_better_50_percent_luck +=1
    if luck >=90:
        num_better_90_percent_luck +=1
    comp = int(i.competence)
    score = i.get_score()
    lucky_10.append(luck)
    comp_10.append(comp)
    #print('Competence {} Luck {} Weighted Score {}'.format(comp,luck,score))

avg_std_above_mean = round((np.average(comp_10)-50) /10, 2) # this is a simplified formula for standard deviation.
print('You need to have an average competence score of {} Standard deviations above the mean.'.format(avg_std_above_mean))
print('And be more lucky that {}% of your peers'.format(np.average(lucky_10)))
print('Amoung those 10\n{} had better than 50% luck \n{} had better than 90% luck'.format(num_better_50_percent_luck
                                                                                            ,num_better_90_percent_luck))
print('fin')


