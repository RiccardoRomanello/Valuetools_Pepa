# PEPA Eclipse Plug-in Update

This repository contains an extended version of [PEPA](https://www.dcs.ed.ac.uk/pepa/).

We implemented 4 main add-ons to the original tool: 
1. _Proportional Lumpability_. We integrate a polynomial-time for computing proportional lumpability,
  enriching the existing set of equivalences and allowing model reduction by
  compressing the CTMC while preserving quantitative properties.
2. _Persistent Stochastic Non-Interference (PSNI)_. Following the
  three equivalent characterizations given in the literature, we provide
  syntactic rules for defining high- and low-level actions and implement the
  verification of PSNI for PEPA models, with applications in areas such as
  smart contract security.
3. _Time Reversibility_. We adapt a DFS-based algorithm
  to check whether the CTMC underlying a PEPA process is reversible. When
  the renaming function $\rho$ is the identity, the algorithm detects standard
  time reversibility.
4. _Causal Reversibility_. Inspired by some previous work from Bernardo, M. and Rossi, S., we extend the
  syntax to support reversible actions. By construction, any process
  reached through such an action can only be reached in that way, ensuring that
  reversible actions can always be undone without loss of behavioural
  information.

## Requirements

PEPA requires the Eclipse IDE and some of its packages. The last supported version of Eclipse is the [2022-09 version for Java Developers](https://www.eclipse.org/downloads/packages/release/2022-09/r/eclipse-ide-java-developers).
 
In order to install the needed packages, execute the Eclipse IDE, click on `Help > Install New Software...`, copy and paste each of the following URLs in the field `Work with:`, press enter, and follow the instructions.

The required Eclipse packages are

- BIRT Chart Framework in the [BIRT package ver. 4.9.0](https://archive.eclipse.org/birt/update-site/4.9.0/)
- ZEST Features in the [GEF package ver. 3.14.0](https://download.eclipse.org/tools/gef/classic/release/3.14.0/)


## Download

1. Clone locally the repository by issuing in a terminal

    ```bash
    git clone https://github.com/RiccardoRomanello/PEPA_Update.git
    ``` 

2. Execute Eclipse and load the project from new directory `PEPA_Update`

## Usage

1. Perform a right click (or a two-fingers click on mac) on the project `uk.ac.ed.inf.pepa`

2. Click on `Run As > Eclipse Application`

3. Follow [these instructions](https://www.dcs.ed.ac.uk/pepa/documentation/#SEC1.1)


