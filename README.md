# Game of Life

An implementation of the famous [game of life by Conway](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).

## Description

Conway's Game of Life implements a simulation of life in its simplest form. The game is based on a two-dimensional grid.
A single cell can take on one of two possible states (alive or dead). To determine the state of a cell the three following basic rules are used:

```
    1. Any live cell with two or three neighbors survives.
    2. Any dead cell with three live neighbors becomes a live cell.
    3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.
```

In each time step of the simulation for every cell the above stated rules get checked an the state of the cells is changed accordingly. 

## Additional Information

This program was created as part of [Helsinki University's MOOC on Object Oriented Programming in Java](https://moocfi.github.io/courses/2013/programming-part-2/). (Exercise 43, Week 11)
