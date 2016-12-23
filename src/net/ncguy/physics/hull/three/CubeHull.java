package net.ncguy.physics.hull.three;

import net.ncguy.physics.data.internal.Vec3;

import java.util.List;

/**
 * Created by Guy on 18/09/2016.
 */
public class CubeHull extends Basic3DHull {

    Vec3 dimensions;

    public CubeHull(Vec3 dimensions) { this.dimensions = dimensions; }
    public CubeHull(float x, float y, float z) { this(new Vec3(x, y, z)); }
    public CubeHull() { this(1, 1, 1); }

    @Override
    public void getTris(List<Float> floats) {
        Vec3 p000 = new Vec3();
        Vec3 p001 = new Vec3();
        Vec3 p010 = new Vec3();
        Vec3 p011 = new Vec3();
        Vec3 p100 = new Vec3();
        Vec3 p101 = new Vec3();
        Vec3 p110 = new Vec3();
        Vec3 p111 = new Vec3();

        Vec3 origin = transform.getPosition().cpy();

        p000.set(origin).add(new Vec3(-dimensions.x, -dimensions.y, -dimensions.z));
        p001.set(origin).add(new Vec3(-dimensions.x, -dimensions.y,  dimensions.z));
        p010.set(origin).add(new Vec3(-dimensions.x,  dimensions.y, -dimensions.z));
        p011.set(origin).add(new Vec3(-dimensions.x,  dimensions.y,  dimensions.z));
        p100.set(origin).add(new Vec3( dimensions.x, -dimensions.y, -dimensions.z));
        p101.set(origin).add(new Vec3( dimensions.x, -dimensions.y,  dimensions.z));
        p110.set(origin).add(new Vec3( dimensions.x,  dimensions.y, -dimensions.z));
        p111.set(origin).add(new Vec3( dimensions.x,  dimensions.y,  dimensions.z));

    }

    public void faceToTris(List<Float> floats, Vec3 face00, Vec3 face01,  Vec3 face10, Vec3 face11) {
        // Tri 0
        floats.add(face00.x);
        floats.add(face00.y);
        floats.add(face00.z);
        floats.add(face01.x);
        floats.add(face01.y);
        floats.add(face01.z);
        floats.add(face10.x);
        floats.add(face10.y);
        floats.add(face10.z);

        // Tri 1
        floats.add(face11.x);
        floats.add(face11.y);
        floats.add(face11.z);
        floats.add(face01.x);
        floats.add(face01.y);
        floats.add(face01.z);
        floats.add(face10.x);
        floats.add(face10.y);
        floats.add(face10.z);
    }

}
