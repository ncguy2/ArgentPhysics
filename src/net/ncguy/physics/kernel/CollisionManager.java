package net.ncguy.physics.kernel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guy on 01/10/2016.
 */
public class CollisionManager {

    private static CollisionAttr3DDescriptor desc3D = new CollisionAttr3DDescriptor();
    private static CollisionAttr2DDescriptor desc2D = new CollisionAttr2DDescriptor();

    private static CollisionManager instance;
    public static CollisionManager instance() {
        if (instance == null)
            instance = new CollisionManager();
        return instance;
    }

    private Thread tickerThread;
    private boolean keepAlive = true;
    private long sleepRate;
    private List<Runnable> tasks;

    private CollisionManager() {
        tasks = new ArrayList<>();
        tickerThread = new Thread(this::process, "Collision Manager");
        tickerThread.start();
    }

    public void updatesPerSecond(int updates) {
        sleepRate = 1000 / Math.max(1, Math.min(updates, 1000));
    }

    public void kill() {
        if(tickerThread.isAlive())
            keepAlive = false;
        instance = null;
    }

    public void post2DCollisionKernelTask(float[] values) {
        postCollisionKernelTask(desc2D, values);
    }

    public void post3DCollisionKernelTask(float[] values) {
        postCollisionKernelTask(desc3D, values);
    }

    public void postCollisionKernelTask(CollisionAttributeDescriptor descriptor, float[] values) {
        postTask(new CollisionKernel(descriptor, values)::execute);
    }

    public void postTask(Runnable task) {
        tasks.add(task);
    }

    private void process() {
        while(keepAlive) {
            try {
                Thread.sleep(sleepRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!tasks.isEmpty())
                tasks.remove(0).run();
        }
    }

}
