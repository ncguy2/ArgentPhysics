package net.ncguy.physics.runtime.argent;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import net.ncguy.argent.entity.WorldEntity;
import net.ncguy.argent.event.StringPacketEvent;
import net.ncguy.physics.data.internal.Vec1;
import net.ncguy.physics.data.internal.Vec2;
import net.ncguy.physics.data.internal.Vec3;
import net.ncguy.physics.data.internal.Vec4;
import net.ncguy.physics.hull.BasicHull;
import net.ncguy.physics.runtime.AbstractRuntime;
import net.ncguy.physics.runtime.DataBridge;

/**
 * Created by Guy on 18/09/2016.
 */
public class ArgentPhysicsRuntime<T extends WorldEntity> extends AbstractRuntime<T> {

    StringPacketEvent toastEvent;

    @Override
    public void init() {
        registerDataBridge(Vec1.class, Float.class, new DataBridge<Vec1, Float>() {
            @Override
            public Float toU(Vec1 vec1) {
                return vec1.x;
            }

            @Override
            public Vec1 toT(Float f) {
                return new Vec1(f);
            }
        });
        registerDataBridge(Vec2.class, Vector2.class, new DataBridge<Vec2, Vector2>() {
            @Override
            public Vector2 toU(Vec2 vec2) {
                return new Vector2(vec2.x, vec2.y);
            }

            @Override
            public Vec2 toT(Vector2 vector2) {
                return new Vec2(vector2.x, vector2.y);
            }
        });
        registerDataBridge(Vec3.class, Vector3.class, new DataBridge<Vec3, Vector3>() {
            @Override
            public Vector3 toU(Vec3 vec3) {
                return new Vector3(vec3.x, vec3.y, vec3.z);
            }

            @Override
            public Vec3 toT(Vector3 vector3) {
                return new Vec3(vector3.x, vector3.y, vector3.z);
            }
        });
        registerDataBridge(Vec4.class, Quaternion.class, new DataBridge<Vec4, Quaternion>() {
            @Override
            public Quaternion toU(Vec4 vec4) {
                return new Quaternion(vec4.x, vec4.y, vec4.z, vec4.w);
            }

            @Override
            public Vec4 toT(Quaternion q) {
                return new Vec4(q.x, q.y, q.z, q.w);
            }
        });
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
    public BasicHull buildHull(T object) {

        return null;
    }
}
