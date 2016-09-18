package net.ncguy.physics.runtime;

/**
 * Created by Guy on 18/09/2016.
 */
public abstract class DataBridge<T, U> {

    public abstract U toU(T t);
    public abstract T toT(U u);

    public U aToB(T a) { return toU(a); }
    public T bToA(U b) { return toT(b); }

}
