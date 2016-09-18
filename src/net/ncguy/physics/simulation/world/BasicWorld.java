package net.ncguy.physics.simulation.world;

import net.ncguy.physics.data.internal.Ray;
import net.ncguy.physics.data.internal.Vec;
import net.ncguy.physics.hull.BasicHull;

import java.util.Set;

/**
 * Created by Guy on 18/09/2016.
 */
public abstract class BasicWorld<T extends BasicHull, U extends Ray> {


    public Set<T> hulls;

    public T rayTrace(U ray) {
        Vec start = ray.origin;
        return null;
    }

}
