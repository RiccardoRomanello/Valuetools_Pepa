# Proportional Lumpability

Observational equivalence is a key concept in the study of both process algebras and Continuous Time Markov Chains (CTMCs). In particular, the definition of useful
equivalence relations between process states allows for space compression which leads to faster algorithms to compute, for example, steady state distributions. 

In the literature, a set of different observational equivalences have been proposed. Among the many, we can mention ordinary, strong, and exact lumpability. 
However, in some contexts, these relations are too strict and do not allow for aggregation of states than behave the same except for some multiplicative constant. 

Therefore, to cope with this problem, Proportional Lumpability have been introduced. 

Since ordinary, strong, and exact lumpability are already implemented in PEPA Eclipse Plug-in, we further increased the set of relations adding Proportional Lumpabilities as well. 

In this directory you find the example of a proportionally lumpable process. 
The source code has been inspired by [this paper](https://www.mdpi.com/1999-4893/17/4/159) in which authors formalize a blockchain as a set of miners and verifiers. They provide derivation graph of the PEPA process they defined, as well as its proportionally lumped version. 
