package net.ncguy.physics.kernel.intersector;

import net.ncguy.physics.kernel.CollisionAttr3DDescriptor;
import net.ncguy.physics.kernel.CollisionAttributeDescriptor;

/**
 * Created by Guy on 01/10/2016.
 */
public class KernelIntersector3D extends KernelIntersector {

    float v0x, v0y, v0z;
    float v1x, v1y, v1z;
    float v2x, v2y, v2z;

    @Override
    public boolean intersectRayTriangle(int gId, float[] points) {
        float edge1x, edge1y, edge1z;
        float edge2x, edge2y, edge2z;
        
        float rayOrgX, rayOrgY, rayOrgZ;
        float rayDirX, rayDirY, rayDirZ;

        rayOrgX = descriptor.getFloatAt(CollisionAttributeDescriptor.RAY_ORIGIN_X, points);
        rayOrgY = descriptor.getFloatAt(CollisionAttributeDescriptor.RAY_ORIGIN_Y, points);
        rayOrgZ = descriptor.getFloatAt(CollisionAttributeDescriptor.RAY_ORIGIN_Z, points);
        rayDirX = descriptor.getFloatAt(CollisionAttributeDescriptor.RAY_DIRECTION_X, points);
        rayDirY = descriptor.getFloatAt(CollisionAttributeDescriptor.RAY_DIRECTION_Y, points);
        rayDirZ = descriptor.getFloatAt(CollisionAttributeDescriptor.RAY_DIRECTION_Z, points);

        float t1x, t1y, t1z;
        float t2x, t2y, t2z;
        float t3x, t3y, t3z;

        t1x = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_A_X, gId, points);
        t1y = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_A_Y, gId, points);
        t1z = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_A_Z, gId, points);
        t2x = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_B_X, gId, points);
        t2y = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_B_Y, gId, points);
        t2z = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_B_Z, gId, points);
        t3x = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_C_X, gId, points);
        t3y = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_C_Y, gId, points);
        t3z = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_C_Z, gId, points);

        edge1x = t2x - t1x;
        edge1y = t2y - t1y;
        edge1z = t2z - t1z;

        edge2x = t3x - t1x;
        edge2y = t3y - t1y;
        edge2z = t3z - t1z;
        
        float pvecx, pvecy, pvecz;
        pvecx = crsX(rayDirY, edge2z, rayDirZ, edge2y);
        pvecy = crsY(rayDirZ, edge2x, rayDirX, edge2z);
        pvecz = crsZ(rayDirX, edge2y, rayDirY, edge2x);

        float det = dot(edge1x, edge1y, edge1z, pvecx, pvecy, pvecz);
        if(isZero(det)) {
            return isPointInTriangle(gId, rayOrgX, rayOrgY, rayOrgZ, points);
        }
        det = 1.0f / det;


        float tvecx = rayOrgX - t1x;
        float tvecy = rayOrgY - t1y;
        float tvecz = rayOrgZ - t1z;

        float u = dot(tvecx, tvecy, tvecz, pvecx, pvecy, pvecz) * det;
        if(u < 0.0f || u > 1.0f) return false;

        float qvecx = crsX(tvecy, edge1z, tvecz, edge1y);
        float qvecy = crsY(tvecz, edge1x, tvecx, edge1z);
        float qvecz = crsZ(tvecx, edge1y, tvecy, edge1x);

        float v = dot(rayDirX, rayDirY, rayDirZ, qvecx, qvecy, qvecz) * det;
        if(v < 0.0f || u + v > 1.0f) return false;
        float t = dot(edge2x, edge2y, edge2z, qvecx, qvecy, qvecz) * det;
        if(t < 0) return false;

        return true;
    }

    public boolean isPointInTriangle(int gId, float px, float py, float pz, float[] points) {
        float t1x, t1y, t1z;
        float t2x, t2y, t2z;
        float t3x, t3y, t3z;

        t1x = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_A_X, gId, points);
        t1y = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_A_Y, gId, points);
        t1z = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_A_Z, gId, points);
        t2x = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_B_X, gId, points);
        t2y = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_B_Y, gId, points);
        t2z = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_B_Z, gId, points);
        t3x = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_C_X, gId, points);
        t3y = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_C_Y, gId, points);
        t3z = descriptor.getFloatAt(CollisionAttr3DDescriptor.TRI_C_Z, gId, points);

        v0x = t1x - px;
        v0y = t1y - py;
        v0z = t1z - pz;

        v1x = t2x - px;
        v1y = t2y - py;
        v1z = t2z - pz;

        v2x = t3x - px;
        v2y = t3y - py;
        v2z = t3z - pz;

        float ab = dot(v0x, v0y, v0z, v1x, v1y, v1z);
        float ac = dot(v0x, v0y, v0z, v2x, v2y, v2z);
        float bc = dot(v1x, v1y, v1z, v2x, v2y, v2z);
        float cc = dot(v2x, v2y, v2z, v2x, v2y, v2z);

        if(bc * ac - cc * ab < 0) return false;
        float bb = dot(v1x, v1y, v1z);
        if(ab * bc - ac * bb < 0) return false;

        return true;
    }
}
