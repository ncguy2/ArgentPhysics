package net.ncguy.physics.data.internal;

/**
 * Created by Guy on 18/09/2016.
 */
public class Triplet<T, U, V> {

    public T t;
    public U u;
    public V v;

    public Triplet(T t, U u, V v) {
        this.t = t;
        this.u = u;
        this.v = v;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
