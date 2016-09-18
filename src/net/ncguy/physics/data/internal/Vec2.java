package net.ncguy.physics.data.internal;

/**
 * Created by Guy on 18/09/2016.
 */
public class Vec2 implements Vec<Vec2> {

    public float x;
    public float y;

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vec2(Vec2 other) {
        this(other.x, other.y);
    }

    public Vec2() { this(0, 0); }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public Vec2 add(Vec2 vec) {
        this.x += vec.x;
        this.x += vec.x;
        return this;
    }

    @Override
    public Vec2 sub(Vec2 vec) {
        this.x -= vec.x;
        this.y -= vec.y;
        return this;
    }

    @Override
    public Vec2 mul(Vec2 vec) {
        this.x *= vec.x;
        this.y *= vec.y;
        return this;
    }

    @Override
    public Vec2 add(float f) {
        this.x += f;
        this.y += f;
        return this;
    }

    @Override
    public Vec2 sub(float f) {
        this.x -= f;
        this.y -= f;
        return this;
    }

    @Override
    public Vec2 scl(float f) {
        this.x *= f;
        this.y *= f;
        return this;
    }

    @Override
    public float dst(Vec2 other) {
        final float x = Math.abs(this.x - other.x);
        final float y = Math.abs(this.y - other.y);
        return Math.abs((float)Math.sqrt(x * x + y * y));
    }

    @Override
    public Vec2 mid(Vec2 vec) {
        this.x = this.x + (vec.x - this.x) * 0.5f;
        this.y = this.y + (vec.y - this.y) * 0.5f;
        return this;
    }

    @Override
    public Vec2 cpy() {
        return new Vec2(this);
    }
}
