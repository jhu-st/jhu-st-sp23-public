import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;

public class ArrayUtilsPBT {

    // countPositive Property 1: returned count must be less than or
    // equal to the input array length
    @Property
    boolean countLessEqualLength(@ForAll @Size(min = 0, max = 6) Integer[] arr) {
        return ArrayUtils.countPositive(arr) <= arr.length;
    }

    // countPositive Property 2: returned count of an array with all
    // positives must be equal to array's length
    @Property
    boolean countEqualsLengthAllPositives(@ForAll("arrProviderAllPositives") Integer arr[]) {
        return ArrayUtils.countPositive(arr) == arr.length;
    }

    // countPositive Property 3: returned count of an array with all
    // negative and zero elements must be zero
    @Property
    boolean countZeroAllNegZero(@ForAll("arrProviderAllZeroNeg") Integer[] arr) {
        return ArrayUtils.countPositive(arr) == 0;
    }

    @Provide
    Arbitrary<Integer[]> arrProviderAllPositives() {
        Arbitrary<Integer> integerArbitrary = Arbitraries.integers().between(1, 100);
        return integerArbitrary
                .array(Integer[].class).ofMinSize(0).ofMaxSize(6);
    }

    @Provide
    Arbitrary<Integer[]> arrProviderAllZeroNeg() {
        Arbitrary<Integer> integerArbitrary = Arbitraries.integers().between(Integer.MIN_VALUE, 0);
        return integerArbitrary
                .array(Integer[].class).ofMinSize(0).ofMaxSize(6);
    }






    // countOutsideRange Property 1: returned count must always be non negative
    @Property
    boolean countAlwaysNonNeg(@ForAll @Size(min = 0, max = 5) Integer[] arr, @ForAll int r1, @ForAll int r2) {
        Assume.that(r1 <= r2);
        return ArrayUtils.countOutsideRange(arr, r1, r2) >= 0;
    }

    // countOutsideRange Property 2: returned count always less or equal the array length
    @Property
    boolean countAlwaysLessEqualsLength(@ForAll @Size(min = 0, max= 5) Integer[] arr, @ForAll int r1, @ForAll int r2) {
        Assume.that(r1 <= r2);
        return ArrayUtils.countOutsideRange(arr, r1, r2) <= arr.length;
    }

    // countOutsideRange Property 3: returned count must be zero if r1 is min_val and r2 is max_val
    @Property
    boolean countAlwaysNonZeroR1EqualsR2(@ForAll @Size(min = 1, max = 5) Integer[] arr, @ForAll @IntRange (min = Integer.MIN_VALUE, max = Integer.MIN_VALUE) int r1, @ForAll @IntRange(min = Integer.MAX_VALUE, max = Integer.MAX_VALUE) int r2) {
        return ArrayUtils.countOutsideRange(arr, r1, r2) == 0;
    }





    // Task 2
    @Provide
    Arbitrary<Integer> provider1() {
        return Arbitraries.of(3, 5, 7, 13, 17, 23, 41, 101);
    }

    @Provide
    Arbitrary<Integer> provider2() {
        return Arbitraries.integers().filter(aNumber -> aNumber % 2 != 0);
    }

    @Provide
    Arbitrary<Integer> provider3() {
        return Arbitraries.integers().between(0, 100).shrinkTowards(50)
                .withDistribution(RandomDistribution.gaussian());
    }
    @Provide
    Arbitrary<String> provider4() {
        return Arbitraries.strings().numeric().ofMinLength(3).ofMaxLength(10);
    }

    @Provide
    EdgeCases<Double> provider5() {
        return Arbitraries.doubles().edgeCases();
    }

    @Provide
    Arbitrary<String> provider6() {
        return Arbitraries.strings().withCharRange('a', 'z').injectDuplicates(0.5);
    }



}
