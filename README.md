# Traveling Salesman - Genetic Algorithm

## About

The Traveling Salesman problem is one of the most famous example of NP problems :  
>*_"Given a list of cities and the distances between each pair of cities, what is the shortest possible route that visits
each city exactly once and returns to the origin city?"_*

This problem is part of a class of problems said to be NP-complete. These are problems for which no efficient solution
algorithm has been found. For those problems, finding a 'good enough' solution is the next best thing.

## Genetic Algorithm Outline

A genetic algorithm is a metaheuristic algorithm, which *'may provide a sufficiently good solution to an optimization
problem, especially with incomplete or uncertain information'* (https://www.aiforanyone.org/glossary/metaheuristic).
In other words, metaheuristic algorithms are often used to find a solution deemed 'good enough' for hard to solve
problems, such as NP-complete/hard problems.  

Examples of other metaheuristic algorithms include :
 - Ant colony optimization
 - Particle swarm optimisation

The genetic algorithm is an algorithm inspired by the theory of evolution. The fittest individuals of a population are
selected for reproduction in order to produce new children. After a certain number of generations, we are left with the
fittest individuals.

There are 5 stages to this algorithm:

    1. Initialisation of the population
    2. Fitness function
    3. Selection of the fittest individuals (the parents)
    4. Reproduction
    5. Mutation

![alt text](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*Ma0sNLsyM0rnZQXEldn7SQ.png)  
(image found at : https://medium.com/@AnasBrital98/genetic-algorithm-explained-76dfbc5de85d)


### GA Terms

#### TSP example map to illustrate the definitions

![img_1.png](img_1.png)

#### Definitions

1. <u>A population</u>: This is a list or a group of individuals. Each of these individuals is a potential solution to the
problem at hand.  
TSP Example: Population = { {1,2,4,5,3}, {1,3,5,4,2}, {1,5,2,3,4}, {1,2,3,4,5}, {1,2,3,5,4}, ... }  


2. <u>Chromosomes</u>: An individual from a population is also called a chromosome. It contains parameters (genes) and is a 
potential solution to the problem.  
TSP Example: Route = {1,2,4,5,3}


3. <u>Genes</u>: Each chromosome is made up of parameters also called genes. In the TSP, a gene would be a single city.  
TSP Example: City = 1


5. <u>Fitness function</u>: A fitness function is a particular mathematical function which determines the quality of each
individual. This makes it possible to evaluate each potential solution.

## Creating a Genetic Algorithm to solve TSP

### 1. Creating our City Class (Genes)
Our cities represent the genes of our future route chromosomes. Each of those cities has coordinates which allows us to
place them in a space. Cities will therefore need the following attributes:
- x_coordinate
- y_coordinate

Being able to calculate the distance between two cities will be central to our work on the TSP. The City class will
therefore need a method (getDistance()) which will calculate the distance between two cities using the following
formulea : d=√((x2 – x1)² + (y2 – y1)²).

### 2. Creating our Routes (Chromosomes)
Once we have our cities, we can start to create routes. Each of our routes will have a distance, which in turn is
evaluated by our fitness function. Routes will therefore need the following attributes:
- ArrayList < City > route
- routeDistance
- fitness

##### Evaluating each individual (route) using a fitness function:
Choosing a fitness function is a really important step in creating a GA as it will influence reproduction. 'Survival of
the fittest' implies that individuals with better fitness have a higher chance of reproducing and passing
down their genetics.
Using and playing around with different fitness functions allows us to compare their results and suitability. For this
project, two fitness options were explored and tested.
- Normal distribution
- Hyperbole distribution

The Hyperbole distribution would mean that the greater the distance, the lower the fitness would be. Equally, the
smallest the distance (and therefore the better!), the greater the fitness would be. This is the easiest and most
straight forward option.

The Normal distribution on the other hand would give us a higher fitness value the smallest the distance is, and
inversely a smaller fitness value the greater the distance is. It is however trickier to use and needs to be adapted
to the problem's scope as, without being tweaked, the fitness values quickly plummet to 0, hindering the selection
process and so on. Parameters would therefore need to be tuned depending on the amount of cities and the size of the
distances given to us in a dataset.

Whilst both were experimented with, the Hyperbole function was ultimately the one chosen to head further into this GA.

### 3. Creating our Population
Once both our genes and chromosomes have been created, creating our population is straight forward. A population, as
we have seen, is a collection of a certain number of individuals. Therefore, our population will need to have the
following:
- ArrayList < Route > routes
- populationSize

On top of this, some metrics allowing us to measure and keep an eye on the progress of fitness levels during each
generation could be desirable. To do so, we could add two attributes which would calculate respectively the *Average
Fitness Level*, and the *Highest Fitness Level* of a generation. This would give us an interesting insight as to how our
population is evolving and should (hopefully!) show an increasingly good fitness value over time.

### 4. Selection
Selection is the first step of the reproductive process of our GA. It consists in selecting two individuals (the
parents) which will reproduce to make an offspring (the child). This can be achieved through a few different
options such as Roulette Wheel Selection, and Tournament Selection, among others. Below you can find the descriptions
for both selection methods, however in our case I chose to implement selection using the Tournament Selection.

#### Tournament Selection:
This selection method is quite simple and consist of the following steps:
- select a number k which will be the mating pool size
- randomly select k individuals from our population to add to the mating pool
- the parent will be the fittest individual in the pool

The number k can be experimented with to see how it influences the GA and carefully selected for best results.

![alt text](https://miro.medium.com/v2/resize:fit:720/format:webp/1*J-nD4gOPCVPXF0QoeWIhBA.png)
(image found at : https://medium.com/@AnasBrital98/genetic-algorithm-explained-76dfbc5de85d)

#### Roulette Wheel Selection:
This selection method slightly differs from the previous one. In this one, each individual is part of the pool or rather
roulette. The fitness of an individual determines how big of a wedge it gets (and therefore how probable it is going to
be picked). The better the fitness, the more chance it has of being selected as a parent.

![alt text](https://miro.medium.com/v2/resize:fit:720/format:webp/1*ipy1op0xYjHQ_G1IEqzG2g.png)
(image found at : https://medium.com/@AnasBrital98/genetic-algorithm-explained-76dfbc5de85d)

### 5. Reproduction
Once our parents are chosen in the Selection process, these need to be bred so that a child may be born. To do so, a
variety of crossover methods exist such as '_One Point Crossover_', '_Multi Point Crossover_, '_Uniform Crossover_',
and so on.

The TSP however is a unique problem which states that each city must be visited once and only once. Therefore, using
_Ordered Crossover_ is the best solution for us as it ensures none of the genes are repeated :
- Firstly, a random subset is selected from parent 1 and put into the child.
- Then, we fill what is left with the genes of parent 2, in the order in which they appear, taking care not to duplicate
any gene.

The size and place of the subset taken from parent 1 is random and can change for each reproduction step.

### 6. Mutation
Mutation introduces an element of chance into the evolution of a population. It can sometimes be beneficial, but it
can also be detrimental and later affect the fitness of an individual (and therefore its survival). In any case it helps
contribute to diversity in the population and can introduce new (or reintroduce lost) attributes.

Although there are diverse ways of applying mutation to a problem, we must follow the TSP rules and account for every
city on our route once and only once. A few options present themselves to us:
- _Swap Mutation_ : we select two distinct genes and swap them around.
- _Inversion Mutation_ : we select a random subsection in our child and reverse the order of it.
- _Scramble Mutation_ : we select a random subsection in our child and interchange the values.

In this example we are using Swap Mutation.

Mutation however, does not occur every single time during the reproduction process. In this example we set the
probability of a mutation occurring to 10%. The mutation probability is something that needs to be experimented with to
see how evolution is impacted depending on the value it is given.

##Creating a City Generator in order to test our GA on a variety of problems.

Creating a City generator from scratch gives you more freedom to test and explore the limits of your newly created GA.
Indeed, it allows you to create any desired list of cities and gives you full control over certain parameters such as
the number of cities, the minimum distance between each city as well as the range between which each x and y coordinate
is chosen.

Creating methods capable of writing/reading this list to/from a CSV File allows you to keep a list saved and delve
deeper into the GA to see how certain parameters can affect the outcome of the algorithm.

When creating my own generator, I made certain design choices to smooth over the process which will be highlighted
below. Here are the steps taken by the generator:
- The generator is created by giving it a number of cities to create, minimum and maximum values for x and y coordinates
and a minimum distance to respect between each city.
- The generator then creates a new city which will be the first one on our list.
- Then, for the X remaining cities that have to be added to the list, it will follow this process:
  - Create a new city
  - Check that the minimum distance is respected between the newly created city and the ones already on the list
  - If it does not violate the minimum distance with a city on the list, then add it to the list and repeat the previous
  steps x-1 times.
  - If it violates the minimum distance with a city already on the list, discard it and try z number of times to create
  a compatible one before moving on. If after z number of times we still have not created a city which can be added to
  our list, decrease the cityNumber parameter by 1, move on and repeat the previous steps x-1 times.

##Results


