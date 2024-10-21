# Refactoring Exercise
This repository was created for the GOOD laboratory. It contains some hands-on refactoring exercises.

## Overview
There are 3 exercises in this repository, each in it's own package: `student`, `optional` and `switchstatement`. Each package has source code and tests. 

The purpose of this exercise is to refactor the code in `src/main/java`, while making use of the tests in `src/test/java`. 
During the refactoring process, you should run your tests to make sure you have not broken anything.

## Exercise 1 `student`
Use IntelliJ refactorings to extract the functionality of a long method into multiple methods. Rename the methods and veriables so that the code is easy to understand.

## Exercise 2 `optional`
Refactor the code in the [PojectService]() to use Optional.

Start by modifying the [`findProject`](https://github.com/MarioRivis/good-refactoring/blob/9525e846f02636c7de9e0d5402058ba797bda202/src/main/java/org/loose/good/refactoring/optional/service/ProjectService.java#L51) 
to return an `Optional<Prjoject>` and modify the code of the remaining methods to use the Optional API.

## Exercise 3 `switchstatement`
This exercise intends to show that switch statements are rigid and requires you to refactor the FoodOrder class to use `inheritance` instead of having a `DeliveryType` enum and being forced to do Runtime type checks.
You can either use an abstract class or an interface to solve this issue.

## Results
After you have finished implementing the exercise, you can check your results against the solutions we have provided on the `refactored` branch. 
> Attention: There is not just one solution to the problem! As you probably already know, 
  programming is a creative craft and we encourage you to get creative. However, be careful to make your code easy to understand!


### Happy Coding!
