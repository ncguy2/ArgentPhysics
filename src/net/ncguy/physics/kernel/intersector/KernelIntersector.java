package net.ncguy.physics.kernel.intersector;

import net.ncguy.physics.kernel.CollisionAttributeDescriptor;

/**
 * Abstract definition of the intersectors that should be able to run on a GPU kernel
 * Implementations of this can depend on concrete attribute descriptors (3d intersector to 3d attribute descriptor)
 */
public abstract class KernelIntersector {

    private static final float FLOAT_ROUNDING_ERROR = 0.000001f;
    CollisionAttributeDescriptor descriptor;

    public CollisionAttributeDescriptor getDescriptor() { return descriptor; }
    public void setDescriptor(CollisionAttributeDescriptor descriptor) { this.descriptor = descriptor; }

    public float dot(float[] p1, float[] p2) {
        return p1[0] * p2[0] + p1[1] * p2[1] + p1[2] * p2[2];
    }
    
    public float dot(float p1x, float p1y, float p1z, float p2x, float p2y, float p2z) {
        return p1x * p2x + p1y * p2y + p1z * p2z;
    }

    public float dot(float x, float y, float z) {
        return dot(x, y, z, x, y, z);
    }

    public float crsX(float y1, float z2, float z1, float y2) {
        return y1 * z2 - z1 * y2;
    }
    public float crsY(float z1, float x2, float x1, float z2) {
        return z1 * x2 - x1 * z2;
    }
    public float crsZ(float x1, float y2, float y1, float x2) {
        return x1 * y2 - y1 * x2;
    }

    public abstract boolean intersectRayTriangle(final int gId, float[] points);

    public boolean isZero (float value) {
        return Math.abs(value) <= FLOAT_ROUNDING_ERROR;
    }

}
