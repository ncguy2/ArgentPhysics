package net.ncguy.physics.data.internal;

/**
 * Created by Guy on 18/09/2016.
 */
public class Vec4 implements Vec<Vec4> {

    public float x;
    public float y;
    public float z;
    public float w;

    public Vec4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vec4(Vec4 other) {
        this(other.x, other.y, other.z, other.w);
    }

    public Vec4() {
        this(0, 0, 0, 0);
    }

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

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    @Override
    public Vec4 add(Vec4 vec) {
        this.x += vec.x;
        this.y += vec.y;
        this.z += vec.z;
        this.w += vec.w;
        return this;
    }

    @Override
    public Vec4 sub(Vec4 vec) {
        this.x -= vec.x;
        this.y -= vec.y;
        this.z -= vec.z;
        this.w -= vec.w;
        return this;
    }

    @Override
    public Vec4 mul(Vec4 vec) {
        this.x *= vec.x;
        this.y *= vec.y;
        this.z *= vec.z;
        this.w *= vec.w;
        return this;
    }

    @Override
    public Vec4 add(float f) {
        this.x += f;
        this.y += f;
        this.z += f;
        this.w += f;
        return this;
    }

    @Override
    public Vec4 sub(float f) {
        this.x -= f;
        this.y -= f;
        this.z -= f;
        this.w -= f;
        return this;
    }

    @Override
    public Vec4 scl(float f) {
        this.x *= f;
        this.y *= f;
        this.z *= f;
        this.w *= f;
        return this;
    }

    @Override
    public float dst(Vec4 other) {
        final float x = Math.abs(this.x - other.x);
        final float y = Math.abs(this.y - other.y);
        final float z = Math.abs(this.z - other.z);
        final float w = Math.abs(this.w - other.w);
        return Math.abs((float)Math.sqrt(x*x + y*y + z*z + w*w));
    }

    @Override
    public Vec4 mid(Vec4 vec) {
        this.x = this.x + (vec.x - this.x) * 0.5f;
        this.y = this.y + (vec.y - this.y) * 0.5f;
        this.z = this.z + (vec.z - this.z) * 0.5f;
        this.w = this.w + (vec.w - this.w) * 0.5f;
        return this;
    }

    @Override
    public Vec4 cpy() {
        return new Vec4(this);
    }
}
