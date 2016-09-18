package net.ncguy.physics.util;

/**
 * Created by Guy on 18/09/2016.
 */
public interface IVisitor<T> {

    IVisitor<T> visit(IVisitable<T> visitable);
    void visitData(IVisitable<T> visitable, T data);

}
