# Persistent Stochastic Non-Interference

In this page we placed some examples of PSNI testing in the PEPA Eclipse Plug-in. 
A process compliancy to PSNI is verified by clicking on 'PEPA' in the top bar, 'Markovian Analysis' and then 'Verify PSNI...'. 

We provide the PEPA sources files to replicate the fair/unfair miner example we presented in the paper 'Enhancing the PEPA Eclipse Plug-in'.

The underlying LTS is as follows. 

<p align="center">  
  <img width="700" height="400" alt="Screenshot 2025-09-11 alle 16 52 58" src="https://github.com/user-attachments/assets/14d3fe15-f02c-43da-a136-5e4a18ff0e1a"/>
</p>

We clearly have two blocks. ne block models the 3-fair-miners systems; the other one
describes a system with 2 fair and 1 unfair miners. A malicious environment
tries to replace the fair miner with an unfair one by using the high action h.

Such model can be eventually generalized, with $k$ miners and one is kept unfair. 
The file `PSNI-generator.py` can be invoked to generate a custom pepa source file. The correct line prompt is the following `python PSNI-generator.py k -o file.pepa` in which
* $k$ must be replaced with the number of miners
* file.pepa must be replaced with the name of the output file

The `.pepa` generated file can be then fed to the PEPA Eclipse Plug-in.
