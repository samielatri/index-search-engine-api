/* package */
package com.indexing.util.datastructure;

/* On-Demand Imports */

/* Specific Imports */
import java.util.Objects;

/**
 * Created bu PacLab
 * User: PacLab
 * Date: 2021
 *
 * Generic Class that represents Pair data structure,
 * it has two generic types T1 and T2, first is the type
 * of first pair, second is the type of the second pair.
 */

public class Pair<T1,T2>  {
    /* Data members */

    private T1 firstValue;  // first value of pair
    private T2 secondValue; // second value of pair

    /* Constructors */

    /**
     * Pair constructor that initialize a Pair object
     * form passed firstValue and secondValue
     * @param firstValue T1 first value of pair
     * @param secondValue T2 second value of pair
     */
    public Pair(T1 firstValue, T2 secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    /* Methods */

    /**
     * @param firstValue T1
     */
    public void setFirstValue(T1 firstValue) {
        this.firstValue = firstValue;
    }

    /**
     * @param secondValue T2
     */
    public void setSecondValue(T2 secondValue) {
        this.secondValue = secondValue;
    }

    /**
     * @return T1
     */
    public T1 getFirstValue() {
        return firstValue;
    }

    /**
     * @return T2
     */
    public T2 getSecondValue() {
        return secondValue;
    }

    /**
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return firstValue.equals(pair.firstValue) && secondValue.equals(pair.secondValue);
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstValue, secondValue);
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "(" + firstValue + ", " + secondValue + ")";
    }
}
