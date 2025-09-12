package com.pixel.nbody;
/* math util library */
public class Vector3D {
    double x;
    double y;
    double z;
    /* constructor */
    Vector3D(double x,double y ,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    /* mutable ops  - in place modification */
    public void Add(Vector3D Other){
        this.x += Other.x;
        this.y += Other.y;
        this.z += Other.z;
    }

    public void Subtract(Vector3D Other){
        this.x -= Other.x;
        this.y -= Other.y;
        this.z -= Other.z;
    }
    /* multiply by scalar k */
    public void Scale(double k){
        this.x *= k;
        this.y *= k;
        this.z *= k;
    }
    /* dot product */
    public double Dot(Vector3D Other){
        if (Other == null){
            throw new IllegalArgumentException("Vector Cant be Null");
        }
        return ((this.x * Other.x) + (this.y * Other.y) + (this.z * Other.z));
    }
    /* cross product */
    public Vector3D Cross(Vector3D Other){
        if (Other == null){
            throw new IllegalArgumentException("Vector cant be Null");
        }
        double CrossX = (this.y * Other.z) - (this.z * Other.y);
        double CrossY = (this.z * Other.x) - (this.x * Other.z);
        double CrossZ = (this.x * Other.y) - (this.y * Other.x);
        return new Vector3D(CrossX,CrossY,CrossZ);
    }
    /* magnitude of vector */
    public double Magnitude(){
        return Math.sqrt(this.x * this.x +
                         this.y * this.y +
                         this.z * this.z );
    }
    /* normalize the vector */
    public Vector3D Normalize(){
        double len = Magnitude();
        double NormalX = this.x / len;
        double NormalY = this.y / len;
        double NormalZ = this.z / len;
        return new Vector3D(NormalX,NormalY,NormalZ);
    }
    /* distance between two vectors */
    public double Distance(Vector3D Other){
        if (Other == null){
            throw new IllegalArgumentException("Vector cant be Null");
        }
        double DistanceX = Math.pow((this.x - Other.x),2);
        double DistanceY = Math.pow((this.y - Other.y),2);
        double DistanceZ = Math.pow((this.z - Other.z),2);
        return Math.sqrt(DistanceX + DistanceY + DistanceZ);
    }
}
