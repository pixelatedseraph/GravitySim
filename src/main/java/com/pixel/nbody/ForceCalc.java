package com.pixel.nbody;

public class ForceCalc {
    /* gravitational constant for calculating force */
    public static final double G = 6.67430e-11;

    /* method for calculating force */
    public static Vector3D gravitationalForce(Body a , Body b){
            double distance = a.distanceBtw(b);
            if (distance < 1e-10){ /* in a case where singularity occurs */
                return new Vector3D(0,0,0);
            }
            double gForceMag = ( G * a.getMass() *  b.getMass() / (distance * distance) );
            Vector3D normalizedVec = b.getPosition().imutSub(a.getPosition()).normalize();
            return  normalizedVec.imutScale(gForceMag);
    }
}
