package net.ncguy.physics.data.internal;

/**
 * Created by Guy on 18/09/2016.
 */
public class Ray<T extends Vec, U extends Vec> {

    public T origin;
    public U direction;
    public float distance;
    public float stepScale = 0.1f;

    public Ray(T origin, U direction) {
        this.origin = origin;
        this.direction = direction;
    }

    public static class Ray2D extends Ray<Vec2, Vec1> {
        public Ray2D(Vec2 origin, Vec1 direction) {
            super(origin, direction);
        }
    }

    public static class Ray3D extends Ray<Vec3, Vec3> {
        public Ray3D(Vec3 origin, Vec3 direction) {
            super(origin, direction);
        }
    }

}
