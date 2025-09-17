# Time Reversibility

In the context of Continuous Time Markov Chains (CTMCs), the idea of time reversibility has been deeply investigated. A CTMC is said to be _reversible_ if its
stochastical behaviour is the same even if the time flow is inverted. 

Clearly, from this definition it is not straightforward to see how to algorithmically verify whether a CTMC is reversible or not. 
However, two major breakthrough has been found during the years. 

On the one hand, we have Kolmogorov's theorem, stating that reversibility can be verified by checking the probabilities of loops inside the CTMC. 
In particular, if the product of the probabilities is the same if the loop is read on one way and in the other (inverting the edges order), then the CTMC is reversible. 
Nontheless, finding all the loops in a graph is a potentially untractable problem. 

The second major theorem related to the computation of reversibility is called _global balance equation_ condition. 
It states that reversibility is tighted related to the steady state distribution of a CTMC. 

Adding a renaming function $\rho$ to the equation (states are relabelled according to such function), one can define $\rho$-reversibility. 
In the literature, a DFS-based algorithm to verify $\rho$-reversibility has been introduced in _Efficient Computation of Renaming Functions for $\rho$-reversible Discrete and Continuous Time Markov Chains_ by Sottana et al. 

We implemented that algorithm, assuming $\rho$ to be the identity, to verify the reversibility of LTS induced by PEPA processes. 

A test file has been provided. 
The verification is triggered through the PEPA menu, then 'Markovian Analysis' and finally 'Verify Reversibility...'
