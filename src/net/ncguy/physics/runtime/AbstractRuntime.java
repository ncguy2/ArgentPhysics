package net.ncguy.physics.runtime;

import net.ncguy.physics.PhysicsCore;
import net.ncguy.physics.hull.BasicHull;

/**
 * Created by Guy on 18/09/2016.
 */
public abstract class AbstractRuntime<T> {

    public <T, U> void registerDataBridge(Class<T> t, Class<U> u, DataBridge<T, U> bridge) { PhysicsCore.registerDataBridge(t, u, bridge); }
    public void removeDataBridge(Class<?> t, Class<?> u) { PhysicsCore.removeDataBridge(t, u); }
    public void removeDataBridge(DataBridge bridge) { PhysicsCore.removeDataBridge(bridge); }

    public abstract void init();
    public abstract void dispose();

    public void log(String text) {
        System.out.println(text);
    }
    public void display(String text) {
        System.out.println(text);
    }

    public abstract BasicHull buildHull(T object);

}
