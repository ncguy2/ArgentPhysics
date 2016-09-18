package net.ncguy.physics;

import net.ncguy.physics.data.internal.Triplet;
import net.ncguy.physics.runtime.AbstractRuntime;
import net.ncguy.physics.runtime.DataBridge;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Guy on 18/09/2016.
 */
public class PhysicsCore {

    private PhysicsCore() {}

    public static AbstractRuntime activeRuntime;

    public static void loadRuntime(AbstractRuntime rt) {
        if(activeRuntime != null) {
            activeRuntime.dispose();
            activeRuntime = null;
        }
        activeRuntime = rt;
        activeRuntime.init();
    }

    static {
        dataBridgeSet = new LinkedHashSet<>();
        activeRuntime = new AbstractRuntime() {
            @Override public void init() {}
            @Override public void dispose() {}
        };
    }

    public static Set<Triplet<Class, Class, DataBridge>> dataBridgeSet;

    public static <T, U> void registerDataBridge(Class<T> t, Class<U> u, DataBridge<T, U> bridge) {
        dataBridgeSet.add(new Triplet<>(t, u, bridge));
    }

    public static void removeDataBridge(Class<?> t, Class<?> u) {
        for(Triplet<Class, Class, DataBridge> triplet : dataBridgeSet) {
            if(triplet.getT().equals(t) && triplet.getU().equals(u)) {
                dataBridgeSet.remove(triplet);
                return;
            }
            if(triplet.getT().equals(u) && triplet.getU().equals(t)) {
                dataBridgeSet.remove(triplet);
                return;
            }
        }
    }
    public static void removeDataBridge(DataBridge bridge) {
        for(Triplet<Class, Class, DataBridge> triplet : dataBridgeSet) {
            if(triplet.getV().equals(bridge)) {
                dataBridgeSet.remove(triplet);
                return;
            }
        }
    }

    public static <T, U> U convert(T obj, Class<U> target) {
        for (Triplet<Class, Class, DataBridge> triplet : dataBridgeSet) {
            if(triplet.getT().equals(target)) return (U) triplet.getV().toT(obj);
            if(triplet.getU().equals(target)) return (U) triplet.getV().toU(obj);
        }
        return null;
    }

}
