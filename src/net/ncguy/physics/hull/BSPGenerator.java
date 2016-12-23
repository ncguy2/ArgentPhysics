package net.ncguy.physics.hull;

import java.util.ArrayList;
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

    public static HullBlock generateBlock(List<BasicHull> hulls) {
        List<HullBlock> children = new ArrayList<>();
        while(hulls.size() > 0) {
            HullBlock block = new HullBlock();
            generateBlock(hulls.remove(0), hulls, block);
            children.add(block);
        }
        while(children.size() > 1) {
            HullBlock next = new HullBlock();
            mergeBlocks(children.remove(0), children, next);
            children.add(next);
        }
        return children.get(0);
    }

    public static void generateBlock(BasicHull hull, List<BasicHull> hulls, HullBlock block) {
        if(hulls.size() == 0) {
            block.setLeftChild(new HullBlock(hull));
            block.setRightChild(new HullBlock());
            return;
        }
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
        hulls.remove(closest);
        block.setRightChild(new HullBlock(closest));
    }

    public static void mergeBlocks(HullBlock block, List<HullBlock> blocks, HullBlock parent) {
        if(blocks.size() == 0) {
            parent.setLeftChild(new HullBlock());
            parent.setRightChild(new HullBlock());
            return;
        }
        HullBlock closest = null;
        float closestDistance = -1;
        for(int i = 0; i < blocks.size(); i++) {
            HullBlock next = blocks.get(i);
            if(closest == null) {
                closest = next;
                closestDistance = block.getPosition().dst(closest.getPosition());
                continue;
            }
            float nextDistance = block.getPosition().dst(next.getPosition());
            if(nextDistance < closestDistance) {
                closest = next;
                closestDistance = nextDistance;
            }
        }
        parent.setLeftChild(block);
        blocks.remove(closest);
        parent.setRightChild(closest);
    }

}
