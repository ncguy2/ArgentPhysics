package net.ncguy.physics.hull;

import net.ncguy.physics.data.Transform;
import net.ncguy.physics.data.internal.Vec;

import java.util.List;

/**
 * Created by Guy on 18/09/2016.
 */
public abstract class BasicHull<T extends Vec, U extends Vec> {

    public Transform<T, U> transform;

    public abstract void getTris(List<Float> floats);

}
