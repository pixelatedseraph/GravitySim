package com.pixel.nbody;
/* math util library */
import java.util.Objects;
public class Vector3D {
    public double x;
    public double y;
    public double z;
    /* constructor */
    Vector3D(double x,double y ,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true; /* check if objects are same */
        if (!(o instanceof Vector3D)) return false; /* if not , return false */
        Vector3D v = (Vector3D)o;
        return Double.compare(v.x,x) == 0 && Double.compare(v.y,y) == 0 && Double.compare(v.z,z) ==0 ;
    }
    @Override
    public int hashCode(){
        return Objects.hash(x,y,z);
    }
    /* fuzzy equals - returns true if absolute difference is lower compared to epsilon */
    public boolean equalsEpsilon(Vector3D v , double eps){
        return Math.abs(v.x -x) < eps && Math.abs(v.y -y) < eps && Math.abs(v.z - z) < eps;
    }
    @Override
    public String toString(){
        return "( " + x + " i " + y + " j "+ z + " k " + " )";
    }
    /* mutable ops  - in place modification */
    public void add(Vector3D Other){
        this.x += Other.x;
        this.y += Other.y;
        this.z += Other.z;
    }

    public void subtract(Vector3D Other){
        this.x -= Other.x;
        this.y -= Other.y;
        this.z -= Other.z;
    }
    /* multiply by scalar k */
    public void scale(double k){
        this.x *= k;
        this.y *= k;
        this.z *= k;
    }
    /* dot product */
    public double dot(Vector3D Other){
        if (Other == null){
            throw new IllegalArgumentException("Vector Cant be Null");
        }
        return ((this.x * Other.x) + (this.y * Other.y) + (this.z * Other.z));
    }
    /* cross product */
    public Vector3D cross(Vector3D Other){
        if (Other == null){
            throw new IllegalArgumentException("Vector cant be Null");
        }
        double CrossX = (this.y * Other.z) - (this.z * Other.y);
        double CrossY = (this.z * Other.x) - (this.x * Other.z);
        double CrossZ = (this.x * Other.y) - (this.y * Other.x);
        return new Vector3D(CrossX,CrossY,CrossZ);
    }
    /* magnitude of vector */
    public double magnitude(){
        return Math.sqrt(x * x +
                         y * y +
                         z * z );
    }
    /* normalize the vector (immutable) */
    public Vector3D normalize(){
        double len = magnitude();
        if (len == 0) {
            throw new IllegalArgumentException("Divide by 0");
        }
        double NormalX = x / len;
        double NormalY = y / len;
        double NormalZ = z / len;
        return new Vector3D(NormalX,NormalY,NormalZ);
    }
    /* distance between two vectors */
    public double distance(Vector3D Other){
        if (Other == null){
            throw new IllegalArgumentException("Vector cant be Null");
        }
        double DistanceX = Math.pow((this.x - Other.x),2);
        double DistanceY = Math.pow((this.y - Other.y),2);
        double DistanceZ = Math.pow((this.z - Other.z),2);
        return Math.sqrt(DistanceX + DistanceY + DistanceZ);
    }
    /* zero method - a static method which returns NUll vector [0,0,0] */
    public static Vector3D zeroVec(){
        return new Vector3D(0,0,0);
    }
    /* duplicate a vector */
    public Vector3D copy(){
        return new Vector3D(x,y,z);
    }
    /* An API to make vectors readable */
    /* Negate - an op to flip sign */
    public void negate(){
        x = -x;
        y = -y;
        z = -z;
    }
    /* angle between two vectors */
    public double angleBetween(Vector3D Other){
        if (Other == null){
            throw new IllegalArgumentException("Vector cant be null");
        }
        double dotProduct = (this.x * Other.x) + (this.y * Other.y) + (this.z * Other.z);
        double MagA = Math.sqrt ( ( (this.x) * (this.x) )+   ( (this.y) * (this.y) )+  ( (this.z) * (this.z) ) );
        double MagB = Math.sqrt ( ( (Other.x) * (Other.x) )+   ( (Other.y) * (Other.y) )+  ( (Other.z) * (Other.z) ) );
        return Math.acos(dotProduct / (MagA * MagB));
    }
    /* scalar  projection of vector on another vector */
    public double scalarProject(Vector3D Other){
        double dotProduct = (this.x * Other.x) + (this.y * Other.y) + (this.z * Other.z);
        double MagOther = Math.sqrt( ( (Other.x) * (Other.x) )+   ( (Other.y) * (Other.y) )+  ( (Other.z) * (Other.z) ) );
        return dotProduct / MagOther ;
    }
    /* vector projection of a vector on another vector */
    public Vector3D vectorProject(Vector3D Other) {
        double dotProduct = (this.x * Other.x) + (this.y * Other.y) + (this.z * Other.z);
        double MagOtherSquare = ( (Other.x) * (Other.x) )+ ( (Other.y) * (Other.y) )+ ( (Other.z) * (Other.z) );
        double k = dotProduct / MagOtherSquare;
        return new Vector3D( k * Other.x , k * Other.y,k * Other.z );
    }
    /* absolute value of vector values*/
    public Vector3D abs(){
        return new Vector3D(  Math.abs(x),Math.abs(y),Math.abs(z));
    }

    /* now let's write immutable ops - generally slower and memory hungry */

    /* immutable addition of two vectors */
    public Vector3D imutAdd(Vector3D Other){
        return new Vector3D(this.x+ Other.x , this.y+Other.y , this.z + Other.z);
    }
    /* subtract two vectors */
    public Vector3D imutSub(Vector3D Other){
        return new Vector3D(this.x - Other.x , this.y - Other.y , this.z - Other.z);
    }

    /* time for some static helper methods */

    /* static method for adding two vectors */
    public static Vector3D statAdd(Vector3D a, Vector3D b){
        return new Vector3D(a.x + b.x, a.y + b.y,a.z + b.z);
    }
    /* subtract two vectors */
    public static Vector3D statSub(Vector3D a, Vector3D b){
        return new Vector3D(a.x - b.x, a.y - b.y,a.z - b.z);
    }
    /* support normalization in place */
    public void normalizeInPlace(){
        double len = magnitude();
        if (len == 0) {
            throw new IllegalArgumentException("Divide by 0");
        }
        x = x / len;
        y = y / len;
        z = z / len;
    }
}
