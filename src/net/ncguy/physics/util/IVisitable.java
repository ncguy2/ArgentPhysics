package net.ncguy.physics.util;

/**
 * Created by Guy on 18/09/2016.
 */
public interface IVisitable<T> {

    void accept(IVisitor<T> visitor);
    T data();

}
