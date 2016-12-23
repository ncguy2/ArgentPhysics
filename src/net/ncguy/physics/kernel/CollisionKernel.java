package net.ncguy.physics.kernel;

import com.amd.aparapi.Kernel;
import com.amd.aparapi.Range;

/**
 * Created by Guy on 01/10/2016.
 */
public class CollisionKernel extends Kernel {

    private final Range range;
    CollisionAttributeDescriptor descriptor;
    float[] values;

    public CollisionKernel(CollisionAttributeDescriptor descriptor, float[] values) {
        this.descriptor = descriptor;
        this.values = values;

        final String executionMode = System.getProperty("com.amd.aparapi.executionMode");
        if ((executionMode != null) && executionMode.equals("JTP")) {
            range = Range.create(values.length, 4);
        } else {
            range = Range.create(values.length);
        }
    }

    @Override
    public void run() {
        final int gid = getGlobalId();
        intersects(gid);
    }

    public void intersects(final int workGroup) {
        descriptor.intersector.intersectRayTriangle(workGroup, values);
    }

    public static CollisionKernel new2D(float... values) {
        return new CollisionKernel(new CollisionAttr2DDescriptor(), values);
    }

    public static CollisionKernel new3D(float... values) {
        return new CollisionKernel(new CollisionAttr3DDescriptor(), values);
    }

    public void execute() {
        execute(range);
    }
}
