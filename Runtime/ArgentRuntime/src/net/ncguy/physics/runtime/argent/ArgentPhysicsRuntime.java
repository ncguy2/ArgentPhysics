package net.ncguy.physics.runtime.argent;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import net.ncguy.argent.entity.WorldEntity;
import net.ncguy.argent.entity.components.physics.PhysicsComponent;
import net.ncguy.argent.event.StringPacketEvent;
import net.ncguy.argent.world.GameWorld;
import net.ncguy.physics.data.internal.Vec1;
import net.ncguy.physics.data.internal.Vec2;
import net.ncguy.physics.data.internal.Vec3;
import net.ncguy.physics.data.internal.Vec4;
import net.ncguy.physics.hull.BasicHull;
import net.ncguy.physics.runtime.AbstractRuntime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guy on 18/09/2016.
 */
public class ArgentPhysicsRuntime<S extends WorldEntity, W extends GameWorld<S>> extends AbstractRuntime<S, W> {

    StringPacketEvent toastEvent;

    @Override
    public void init() {
        registerDataBridge(Vec1.class, Float.class, v -> v.x, Vec1::new);
        registerDataBridge(Vec2.class, Vector2.class, v -> new Vector2(v.x, v.y), v -> new Vec2(v.x, v.y));
        registerDataBridge(Vec3.class, Vector3.class, v -> new Vector3(v.x, v.y, v.z), v -> new Vec3(v.x, v.y, v.z));
        registerDataBridge(Vec4.class, Quaternion.class, v -> new Quaternion(v.x, v.y, v.z, v.w), q -> new Vec4(q.x, q.y, q.z, q.w));
    }

    @Override
    public void dispose() {
        removeDataBridge(Vec1.class, Float.class);
        removeDataBridge(Vec2.class, Vector2.class);
        removeDataBridge(Vec3.class, Vector3.class);
        removeDataBridge(Vec4.class, Quaternion.class);
    }

    @Override
    public void display(String text) {
        super.display("[Toast] "+text);
        toastEvent.key("toast|info").payload(text).fire();
    }

    @Override
    public BasicHull buildHull(S object) {
        if(!object.has(PhysicsComponent.class)) return null;
        PhysicsComponent comp = object.get(PhysicsComponent.class);
        BasicHull hull;
        if(comp.composite) {

        }else{

        }
        return null;
    }

    @Override
    public float[] compileToPrimitives(W world) {
        final List<Float> floats = new ArrayList<>();
        world.instances().stream()
                .filter(c -> c.has(PhysicsComponent.class))
                .forEach(o -> compileToPrimitives(o, floats));
        float[] out = new float[floats.size()];
        for (int i = 0; i < floats.size(); i++)
            out[i] = floats.get(i);
        return out;
    }

    @Override
    public void compileToPrimitives(S obj, List<Float> floats) {
        PhysicsComponent component = obj.get(PhysicsComponent.class);
        component.data.toTris(floats);
    }

}
