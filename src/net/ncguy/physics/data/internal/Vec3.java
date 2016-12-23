package net.ncguy.physics.data.internal;

/**
 * Created by Guy on 18/09/2016.
 */
public class Vec3 implements Vec<Vec3> {

    public float x;
    public float y;
    public float z;

    public Vec3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3(Vec3 other) {
        this(other.x, other.y, other.z);
    }

    public Vec3() {
        this(0, 0, 0);
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

    @Override
    public Vec3 set(Vec3 vec) {
        this.x = vec.x;
        this.y = vec.y;
        this.z = vec.z;
        return this;
    }

    @Override
    public Vec3 add(Vec3 vec) {
        this.x += vec.x;
        this.y += vec.y;
        this.z += vec.z;
        return this;
    }

    @Override
    public Vec3 sub(Vec3 vec) {
        this.x -= vec.x;
        this.y -= vec.y;
        this.z -= vec.z;
        return this;
    }

    @Override
    public Vec3 mul(Vec3 vec) {
        this.x *= vec.x;
        this.y *= vec.y;
        this.z *= vec.z;
        return this;
    }

    @Override
    public Vec3 add(float f) {
        this.x += f;
        this.y += f;
        this.z += f;
        return this;
    }

    @Override
    public Vec3 sub(float f) {
        this.x -= f;
        this.y -= f;
        this.z -= f;
        return this;
    }

    @Override
    public Vec3 scl(float f) {
        this.x *= f;
        this.y *= f;
        this.z *= f;
        return this;
    }

    @Override
    public float dst(Vec3 other) {
        final float x = Math.abs(this.x - other.x);
        final float y = Math.abs(this.y - other.y);
        final float z = Math.abs(this.z - other.z);
        return Math.abs((float)Math.sqrt(x * x + y * y + z * z));
    }

    @Override
    public Vec3 mid(Vec3 vec) {
        this.x = this.x + (vec.x - this.x) * 0.5f;
        this.y = this.y + (vec.y - this.y) * 0.5f;
        this.z = this.z + (vec.z - this.z) * 0.5f;
        return this;
    }

    @Override
    public Vec3 cpy() {
        return new Vec3(this);
    }
}