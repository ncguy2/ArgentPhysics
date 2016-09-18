package net.ncguy.physics.hull;

import net.ncguy.physics.data.internal.Vec;
import net.ncguy.physics.util.IVisitable;
import net.ncguy.physics.util.IVisitor;

/**
 * Created by Guy on 18/09/2016.
 */
public class HullBlock<T extends Vec, U extends Vec> implements IVisitable<String> {

    public BasicHull<T, U> hull;
    public HullBlock<T, U> leftChild;
    public HullBlock<T, U> rightChild;

    public HullBlock() {
    }

    public HullBlock(BasicHull<T, U> hull) {
        this.hull = hull;
    }

    public HullBlock(BasicHull<T, U> hull, HullBlock<T, U> leftChild, HullBlock<T, U> rightChild) {
        this.hull = hull;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BasicHull getHull() {
        return hull;
    }

    public void setHull(BasicHull<T, U> hull) {
        this.hull = hull;
    }

    public HullBlock getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(HullBlock<T, U> leftChild) {
        this.leftChild = leftChild;
    }

    public HullBlock getRightChild() {
        return rightChild;
    }

    public void setRightChild(HullBlock<T, U> rightChild) {
        this.rightChild = rightChild;
    }

    public T getPosition() {
        if(hull != null)
            return hull.transform.getPosition();
        if(leftChild != null && rightChild != null) {
            Vec<T> l = leftChild.getPosition();
            return l.mid(rightChild.getPosition());
        }else{
            if(leftChild != null)
                return leftChild.getPosition();
            if(rightChild != null)
                return rightChild.getPosition();
        }
        return null;
    }

    // Visitor

    @Override
    public void accept(IVisitor<String> visitor) {
        visitor.visitData(this, data());

        if(leftChild != null)  leftChild.accept(visitor.visit(leftChild));
        if(rightChild != null) rightChild.accept(visitor.visit(rightChild));
    }

    @Override
    public String data() {
        return String.format("%s: [%s, %s]", hull != null ? hull.toString() : "Null", leftChild != null ? leftChild.toString() : "Null", rightChild != null ? rightChild.toString() : "Null");
    }

}
