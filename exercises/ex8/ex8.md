1. Mutation Analysis is assessing the quality of a test suite by calculation of level of mutation coverage, while mutation testing is used to improve the test suite quality by leveraging mutation analysis.

2. This is an interesting problem, but one way yo do so is to start with an initial test suite and then incrementally add more test cases to the suite to improve the mutation score to meet  a certain user-specified threshold

3. 
* Strongly Killing Mutants:
Given a mutant m  M for a program P and a test t, t is said to strongly kill m if and only if the output of t on P is different from the output of t on m

* Weakly Killing Mutants:
Given a mutant m  M that modifies a location l  in a program P,  and a test t, t is said to weakly kill m if and only if the state of the execution of P on t is different from the state of the execution of m  on t immediately after I 
Weakly killing satisfies reachability and infection, but not propagation

4. One that has the same exact behavior as the original program

## Task 1

```java
1 int max(int[] values) {
2   int r, i;
3   r = 0;
4   for(i = 1; i < values.length; i++) {
5       if (values[i] > values[r])
6          r = i;
7   }
8   return values[r];
9 }
```
<br /><br />

* M1
```java
if (values[i] > values[r]) 
* if (values[i] >= values[r])
```
<br />
This is an equivalent mutant!

<br /><br />
* M2
```java
if (values[i] > values[r]) 
* if !(values[i] > values[r])
```
<br />
[1, 2] kills it

<br /><br />
* M3 
```java
if (values[i] > values[r]) 
* if (values[i] < values[r])
```
<br />
[1, 2] kills it

<br />
<br />

* M4
```java
if (values[i] > values[r]) 
* if (-values[i] > values[r])
```
<br />

[1, 2] kills it

<br />
<br />

* M5
```java
if (values[i] > values[r]) 
* if (values[i] == values[r])
```
<br />

[1, 2] kills it



