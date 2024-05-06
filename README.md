# Word Ladder Solver

## Description

Word ladder (also known as Doublets, word-links, change-the-word puzzles, paragrams, laddergrams, or word golf) is a word game that is well known to all circles. Word ladder was discovered by Lewis Carroll, a writer and mathematician, in 1877. In this game, players are given two words called a start word and an end word. To win the game, players must find a chain of words that can connect the start word and end word. The number of letters at the start word and end word is always the same. Each adjacent word in the word chain can only differ by one letter. In this game, the optimal solution is expected, namely the solution that minimizes the number of words included in the word chain.

## Requirements

- java version "22.0.1" 2024-04-16
- Java(TM) SE Runtime Environment (build 22.0.1+8-16)
- Python 3.10.12

## Compilation

It's best to compile the program using any java supported IDE. Mainstream java IDE like IntelliJ IDEA, netbeans, or VS code with java extensions can auto compile the program.

## Usage
Choose the algorithm then input the source, then input the destination. 

```bash
Choose the algorithm:
    1. A* search (optimal and complete)
    2. Uniform cost search (optimal and complete)
    3. Greedy best-first search first variant (not optimal but complete)
    4. Greedy best-first search second vairant (not optimal and not complete)
Note:   
Optimal: Always finds the best solution.
Complete: Always finds a solution if there are any.

Algorithm choice: 1
Starting word: purple
Ending word: yellow
[purple, purply, purely, surely, sorely, sorels, morels, motels, botels, betels, bevels, levels, levees, levies, bevies, belies, belles, belled, balled, ballet, ballot, ballon, billon, billow, bellow, yellow]
Number of nodes in the path: 26
Total nodes visited: 5005
Time taken: 50 ms
Memory used: 61372 KB
```


## Credits

The dictionary is from [here](https://github.com/dwyl/english-words) and [here](https://docs.oracle.com/javase/tutorial/collections/interfaces/examples/dictionary.txt).

## Author

Name: Azmi M. B.
NIM: 13522109