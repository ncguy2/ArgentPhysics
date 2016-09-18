package net.ncguy.physics.hull;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Guy on 18/09/2016.
 */
public class BSPGenerator {

    public static HullBlock generateTree(int depth, List<BasicHull> hulls) {
        List<BasicHull> snapshot = hulls.stream().collect(Collectors.toList());
        HullBlock block = new HullBlock();
        while(!snapshot.isEmpty()) {
            BasicHull hull = snapshot.remove(0);
            generateBlock(hull, snapshot, block);
        }
        return block;
    }

    public static HullBlock generateBlock(BasicHull hull, List<BasicHull> hulls) {
        HullBlock block = new HullBlock();
        generateBlock(hull, hulls, block);
        return block;
    }

    public static void generateBlock(BasicHull hull, List<BasicHull> hulls, HullBlock block) {
        BasicHull closest = null;
        float closestDistance = -1;
        for(int i = 0; i < hulls.size(); i++) {
            BasicHull next = hulls.get(i);
            if(closest == null) {
                closest = next;
                closestDistance = hull.transform.position.dst(closest.transform.position);
                continue;
            }
            float nextDistance = hull.transform.position.dst(next.transform.position);
            if(nextDistance < closestDistance) {
                closest = next;
                closestDistance = nextDistance;
            }
        }
        block.setLeftChild(new HullBlock(hull));
        block.setRightChild(new HullBlock(closest));
    }

}
