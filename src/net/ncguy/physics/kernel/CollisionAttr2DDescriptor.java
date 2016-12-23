package net.ncguy.physics.kernel;

import net.ncguy.physics.kernel.intersector.KernelIntersector2D;

/**
 * Created by Guy on 01/10/2016.
 */
public class CollisionAttr2DDescriptor extends CollisionAttributeDescriptor {

    public static final int TRI_A_X = 0;
    public static final int TRI_A_Y = 1;
    public static final int TRI_B_X = 2;
    public static final int TRI_B_Y = 3;
    public static final int TRI_C_X = 4;
    public static final int TRI_C_Y = 5;

    public CollisionAttr2DDescriptor() {
        super(new KernelIntersector2D());
    }

    @Override
    public int stride() {
        return 6;
    }
}
