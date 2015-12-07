# Petri-Net

Takes the input of places, transitions, input markings for each individual transition, output markings for each individual transition, and the initial marking. 

Calulated values include:
  - Reachable Markings
  - Omega Markings

Error checks include:
  - Incorrect input data
    - Wrong amount of input markings
    - Wrong amount of output markings
  - Negative markings not included in solution set


A Petri net (also known as a place/transition net or P/T net) is one of several mathematical modeling languages for the description of distributed systems. A Petri net is a directed bipartite graph, in which the nodes represent transitions (i.e. events that may occur, signified by bars) and places (i.e. conditions, signified by circles). The directed arcs describe which places are pre- and/or postconditions for which transitions (signified by arrows). (source: https://en.wikipedia.org/wiki/Petri_net)
