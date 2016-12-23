package net.ncguy.physics.runtime;

import net.ncguy.physics.PhysicsCore;
import net.ncguy.physics.hull.BasicHull;

import java.util.List;
import java.util.function.Function;

/**
 * Created by Guy on 18/09/2016.
 */
public abstract class AbstractRuntime<S, W> {

    public <T, U> void registerDataBridge(Class<T> t, Class<U> u, DataBridge<T, U> bridge) { PhysicsCore.registerDataBridge(t, u, bridge); }
    public <T, U> void registerDataBridge(Class<T> t, Class<U> u, Function<T, U> toU, Function<U, T> toT) { registerDataBridge(t, u, new LambdaDataBridge<>(toU, toT)); }

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

    public abstract BasicHull buildHull(S object);

    public abstract float[] compileToPrimitives(W world);
    public abstract void compileToPrimitives(S obj, List<Float> floats);

}
