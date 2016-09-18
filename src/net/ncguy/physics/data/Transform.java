package net.ncguy.physics.data;

import net.ncguy.physics.data.internal.Vec;

/**
 * Created by Guy on 18/09/2016.
 */
public abstract class Transform<T extends Vec, U extends Vec> {

    public Bounds<T> bounds;
    public T position;
    public U rotation;
    public T scale;

    public Transform(Bounds<T> bounds, T position, U rotation, T scale) {
        this.bounds = bounds;
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }

    public Bounds<T> getBounds() {
        return bounds;
    }

    public void setBounds(Bounds<T> bounds) {
        this.bounds = bounds;
    }

    public T getPosition() {
        return position;
    }

    public void setPosition(T position) {
        this.position = position;
    }

    public U getRotation() {
        return rotation;
    }

    public void setRotation(U rotation) {
        this.rotation = rotation;
    }

    public T getScale() {
        return scale;
    }

    public void setScale(T scale) {
        this.scale = scale;
    }
}
