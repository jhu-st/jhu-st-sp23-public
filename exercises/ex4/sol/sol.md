## Question 1:

The assertion only checks a small part of the nal state (the rst element in the list). So if a
test causes a fault to infect, and then propagates to another part of the final state, the failure will not be revealed. The test oracle needs to look at the entire list.

## Question 2:

One way to handle this is to have a single class-level instance of type ArrayList. We would then instantiate an Arraylist object in a method annotated with @BeforeAll and assign it to the class-level field; this would only execute once before any tests are run. Then, in a separate method annotated with @AfterEach, empty the arraylist each time a test case is finished. Finally, we can use a method annotated with @BeforeEach to get the arraylist instance into any state we want before each test case is executed e.g. add items to the arraylist object.

## Task 1
For `MethodSource`, it would be something like this:

```java
@MethodSource
public static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(new int[]{13, 14, 65, 456, 31, 83}, 10, 100, 1), 
                Arguments.of(new int[]{8, 14, 65, 456, 31, 83}, 10, 100, 2));
}

@Tag("parameterized")
@ParameterizedTest
@MethodSource("dataProvider")
public void testCountOutsideRange(int[] arr, int r1, int r2, int expected) {
        assertEquals(expected, ArrayUtils.countOutsideRange(arr, r1, r2));
}
```