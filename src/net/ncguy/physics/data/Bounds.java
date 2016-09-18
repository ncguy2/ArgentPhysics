package net.ncguy.physics.data;

/**
 * Created by Guy on 18/09/2016.
 */
public class Bounds<T> {

    public T min;
    public T max;

    public Bounds(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }
}
