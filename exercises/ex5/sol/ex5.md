## 1
Yes, it does as path coverage test requirements set includes every single execution path. This obviously includes all branches too, hence PC subsumes BC.

## 2

Consider the following method:

```java
 /**
* This method decides how many elements in an array are NOT within [r1, r2].
* @param arr the array
* @param r1 the lower bound
* @param r2 the upper bound
* @return the count
*/
public static int countOutsideRange(int arr[], int r1, int r2) {
    int count = 0;
    for (int i = 0; i < arr.length; ++i) {
        if (arr[i] <= r1 || arr[i] >= r2) {
            count++;
        }
    }
    return count;
}
```

The following two test cases for a _Minimal_ but NOT _Minimum_ test set the achieves branch coverage:

```java
// The following two test cases achieve BC
@Test
public void testCountOutsideRangeOutside {
    assertEquals(1, CountOutsideRange.countOutsideRange(new int[]{1}, 3, 6));
}

@Test
public void testCountOutsideRangeBothWithin() {
    assertEquals(0, CountOutsideRange.countOutsideRange(new int[]{5}, 3, 6));
}
```

The reason the above test set is minimal is that if you take any single test case out of the test set, then it will not achieve BC any longer. It is not _minimum_ though since we can actually create a test set with only one test case to achieve BC as follows:

```java
// The following test case achieve BC
@Test
public void testCountOutsideRangeBothWithinAndOutside() {
    assertEquals(1, CountOutsideRange.countOutsideRange(new int[]{5, 1}, 3, 6));
}
```

## 3

Consider the following method:

```java
/**
* This method decides how many elements in an array are NOT within [r1, r2].
* @param arr the array
* @param r1 the lower bound
* @param r2 the upper bound
* @return the count
*/
public static int countOutsideRange(int arr[], int r1, int r2) {
    int count = 0;
    for (int i = 0; i < arr.length; ++i) {
        if (arr[i] <= r1 || arr[i] >= r2) {
            count++;
        }
    }
    return count;
}
```

The following test case achieves SC and reveals a fault as it expects `0`, but receives `1`:

```java
// The following two test case achieves SC
@Test
public void testCountOutside() {
    assertEquals(0, CountOutsideRange.countOutsideRange(new int[]{6}, 3, 6));
}
```

The following test case achieves BC and does NOT reveal any fault:

```java
// The following test case achieves BC
@Test
public void testCountOutsideRangeBothWithinAndOutside() {
    assertEquals(1, CountOutsideRange.countOutsideRange(new int[]{5, 1}, 3, 6));
}
```


## 4

Consider the `countOutsideRange` method in previous parts. 

The following test case achieves SC and reveals a fault as it expects `0`, but receives `1`:

```java
// The following test case achieves SC
@Test
public void testCountOutside() {
    assertEquals(0, CountOutsideRange.countOutsideRange(new int[]{6}, 3, 6));
}
```

The following test case achieves SC and does NOT reveal a fault:

```java
// The following test case achieves SC
@Test
public void testCountOutside() {
    assertEquals(1, CountOutsideRange.countOutsideRange(new int[]{7}, 3, 6));
}
```

## 5

Consider `sum` method:

```java
public int sum(int a, int b) {
    return a - b;
}
```

The following test case achieves PC and does NOT reveal a fault:

```java
// The following test case achieves SC, BC, and PC
@Test
public void testCountOutside() {
    assertEquals(0, sum(0, 0));
}
```

## 6

a. a total of 27 combinations

b. Pair-wise Coverage


(P, N, Z)

(P, Z, P)

(P, P, N)

(Z, P, P)

(Z, Z, Z)

(Z, N, N)

(N, P, P)

(N, Z, Z)

(N, N, N)

(P, N, P)

(P, Z, N)

(P, P, Z)

c.

(P, P, P) <-- base test

(P, P, N)

(P, P, Z)

(P, N, P)

(P, Z, P)

(N, P, P)

(Z, P, P)

