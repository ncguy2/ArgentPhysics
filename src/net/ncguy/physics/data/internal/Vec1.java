package net.ncguy.physics.data.internal;

/**
 * Created by Guy on 18/09/2016.
 */
public class Vec1 implements Vec<Vec1> {

    public float x;

    public Vec1(float x) {
        this.x = x;
    }

    public Vec1(Vec1 other) {
        this(other.x);
    }

    public Vec1() {
        this(0);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    @Override
    public Vec1 add(Vec1 vec) {
        this.x += vec.x;
        return this;
    }

    @Override
    public Vec1 sub(Vec1 vec) {
        this.x -= vec.x;
        return this;
    }

    @Override
    public Vec1 mul(Vec1 vec) {
        this.x *= vec.x;
        return this;
    }

    @Override
    public Vec1 add(float f) {
        this.x += f;
        return this;
    }

    @Override
    public Vec1 sub(float f) {
        this.x -= f;
        return this;
    }

    @Override
    public Vec1 scl(float f) {
        this.x *= f;
        return this;
    }

    @Override
    public float dst(Vec1 other) {
        return Math.abs((float) Math.sqrt(this.x * this.x + other.x * other.x));
    }

    @Override
    public Vec1 mid(Vec1 vec) {
        this.x = this.x + (vec.x - this.x) * 0.5f;
        return this;
    }

    @Override
    public Vec1 cpy() {
        return new Vec1(this);
    }
}
