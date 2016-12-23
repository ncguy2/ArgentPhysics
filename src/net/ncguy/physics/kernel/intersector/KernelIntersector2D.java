package net.ncguy.physics.kernel.intersector;

/**
 * Created by Guy on 01/10/2016.
 */
public class KernelIntersector2D extends KernelIntersector {

    @Override
    public boolean intersectRayTriangle(int gId, float[] points) {
        return false;
    }


    public boolean isPointInTriangle(int gId, float[] points) {
        return false;
    }
}
