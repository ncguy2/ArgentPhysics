package net.ncguy.physics.kernel;

import com.amd.aparapi.Kernel;
import net.ncguy.physics.kernel.intersector.KernelIntersector;

/**
 * Created by Guy on 01/10/2016.
 */
public abstract class CollisionAttributeDescriptor {

    public final KernelIntersector intersector;

    // Global values
    public static final int RAY_ORIGIN_X = 0;
    public static final int RAY_ORIGIN_Y = 1;
    public static final int RAY_ORIGIN_Z = 2;
    public static final int RAY_DIRECTION_X = 3;
    public static final int RAY_DIRECTION_Y = 4;
    public static final int RAY_DIRECTION_Z = 5;
    public static final int RAY_LENGTH = 6;

    public CollisionAttributeDescriptor(KernelIntersector intersector) {
        this.intersector = intersector;
        this.intersector.setDescriptor(this);
    }

    /**
     * Gets the float at the specified index for the specified entity
     * @param index Local index of desired value
     * @param workGroupId Global id of work group, attainable from a GPU kernel instance through {@link Kernel#getGlobalId}
     * @param values The float array containing all data for every relevant entity
     * @return the value of the entity at index
     */
    public float getFloatAt(int index, int workGroupId, float[] values) {
        int offset = stride() * workGroupId;
        offset += globalStride();
        int i = offset + index;
        return getFloatAt(i, values);
    }

    public float getFloatAt(int i, float[] values) {
        if(values.length >= i) return 0;
        if(i < 0) return 0;
        return values[i];
    }

    public float[] getRay(float[] values) {
        float[] out = new float[globalStride()];
        for(int i = 0; i < out.length; i++)
            out[i] = values[i];
        return out;
    }

    public float[] getEntity(int workGroupId, float[] values) {
        int offset = stride() * workGroupId;
        offset += globalStride();
        float[] out = new float[stride()];
        for(int i = 0; i < out.length; i++)
            out[i] = getFloatAt(i + offset, values);
        return out;
    }

    /**
     * Defines the stride distance of values that should be available for every relevant entity
     * @return The length of the global stride
     */
    public int globalStride() {
        return 7;
    }

    /**
     * Defines the stride distance between each entity in the "values" float array
     * @return The length of the stride
     */
    public abstract int stride();

}
