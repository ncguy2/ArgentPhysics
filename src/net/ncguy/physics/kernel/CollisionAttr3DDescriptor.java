package net.ncguy.physics.kernel;

import net.ncguy.physics.kernel.intersector.KernelIntersector3D;

/**
 * Created by Guy on 01/10/2016.
 */
public class CollisionAttr3DDescriptor extends CollisionAttributeDescriptor {

    public static final int TRI_A_X = 0;
    public static final int TRI_A_Y = 1;
    public static final int TRI_A_Z = 2;
    public static final int TRI_B_X = 3;
    public static final int TRI_B_Y = 4;
    public static final int TRI_B_Z = 5;
    public static final int TRI_C_X = 6;
    public static final int TRI_C_Y = 7;
    public static final int TRI_C_Z = 8;

    public static final int INTERSECT = 9;
    public static final int INTERSECT_X = 10;
    public static final int INTERSECT_Y = 11;
    public static final int INTERSECT_Z = 12;

    public CollisionAttr3DDescriptor() {
        super(new KernelIntersector3D());
    }

    @Override
    public int stride() {
        return 9;
    }
}
