# Traveling Salesman - Genetic Algorithm

## About

The Traveling Salesman problem is one of the most famous example of NP problems :
"Given a list of cities and the distances between each pair of cities,
what is the shortest possible route that visits each city exactly once and returns to the origin city?"

This problem is part of a class of problems said to be NP-complete. These are problems for which no efficient solution
algorithm has been found. For those problems, finding a 'good enough' solution is the next best thing.

## Genetic Algorithm Outline

A genetic algorithm is a metaheuristic algorithm, which 'may provide a sufficiently good solution to an optimization
problem, especially with incomplete or uncertain information' (https://www.aiforanyone.org/glossary/metaheuristic).
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

1. A population: This is a list or a group of individuals. Each of these individuals are a potential solution to the
problem at hand.
TSP Example: Population = { {1,2,4,5,3}, {1,3,5,4,2}, {1,5,2,3,4}, {1,2,3,4,5}, {1,2,3,5,4}, ... }

2. Chromosomes: An individual from a population is also called a chromosome. It contains parameters (genes) and is a 
potential solution to the problem.
TSP Example: Route = {1,2,4,5,3}

3. Genes: Each chromosome is made up of parameters also called genes. In the TSP, a gene would be a single city such as
TSP Example: City = 1

4. Fitness function: A fitness function is a particular mathematical function which determines the quality of each
individual. This makes it possible to evaluate each potential solution.

## Creating a Genetic Algorithm to solve TSP

###1. Creating our City Class (Genes)
Our cities represent the genes of our future route chromosomes. Each of those cities has coordinates which allows us to
place them in a space. Cities will therefore need the following attributes:
- x_coordinate
- y_coordinate

Being able to calculate the distance between two cities will be central to our work on the TSP. The City class will
therefore need a method (getDistance()) which will calculate the distance between two cities using the following
formulea : d=√((x2 – x1)² + (y2 – y1)²).

###3. Creating our Routes (Chromosomes)
Once we have our cities, we can start to create routes. Each of our routes will have a distance, which in turns is
evaluated by our fitness function. Route will therefore need the following attributes:
- ArrayList < City > route
- routeDistance
- fitness



