# Causal Reversibility

In this subdirectory we provide some examples regarding causal reversibility in the PEPA eclipse plug-in. 

As described in the paper 'Enhancing the PEPA Eclipse Plug-in', we took inspiration from the work presented by Bernardo, M. and Rossi, S. in FoSSaCS23. 
In process algebras, the notion of causal reversibility boils down to the capability of undoing every action that has been performed. 

In PEPA syntax, whenever a label is activated, the new state has no memory of the way in which it has been reached. This clearly does not allow causal reversibility. 

To cope with this limitation we adopted two modifications: 
- We enriched PEPA syntax to define a set of reversible actions
- We added a compile time verification that ensures that each process reached via a reversible action, is not reachable by any other action

If the compilation process mentioned above is successfull, the underlying LTS is modified to comply with the reversible nature of the actions. 

An example is provided with the following image: 
<p align="center">
  <img width="570" height="161" alt="Screenshot 2025-09-12 alle 10 01 28" src="https://github.com/user-attachments/assets/ab944ccc-5338-4564-b442-870e3cb36d2c"/>
</p>

The green edge is the one added at compile time and it can be distinguished thanks to the dagger symbol. 

In this directory you can find two different PEPA files. The one that contains _wrong_ in the file name actually contains a mistake that is detected at compile time. In particular, a process reached via a reversible action, is reached with some other actions as well. The wrong usage of reversible actions is verified and highlighted to the user. 
The file that _does not_ contain the _wrong_ word is actually a correct example of causal reversibility.
