package com.pixel.nbody;
import java.util.ArrayList;
import java.util.List;
public class Rk4Integrator {
    public static void step (Simulation sim){
        double dt = sim.getTimeStep();
        List<Body> bodies = sim.getBodies();
        int num = bodies.size();
        /* store initial parameters of each body */
        List<Vector3D> initialPositions = new ArrayList<>();
        List<Vector3D> initialVelocities = new ArrayList<>();
        for (Body b : bodies){
            initialPositions.add(b.getPosition().copy());
            initialVelocities.add(b.getVelocity().copy());
        }
        /* k1 values for bodies  at t*/
        List<Vector3D> k1vel = new ArrayList<>();
        List<Vector3D> k1acc = new ArrayList<>();
        for  (int i = 0 ; i < num ;++i){
            Body b = bodies.get(i);
            Vector3D netForce = sim.totalNetForce(b);
            k1vel.add(b.getVelocity());
            k1acc.add(netForce/b.getMass());
        }
    }
}