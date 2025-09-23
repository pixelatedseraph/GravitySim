package com.pixel.nbody;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<Body> bodies;
    private double timeStep;
    private double currentTime;
    /* constructor for this class */
    public Simulation(double dt){
        bodies = new ArrayList<>();
        timeStep = dt;
        currentTime = 0.0;
    }
    /* method to add bodies */
    public void addBody(Body b){
        bodies.add(b);
    }
    /* calculate net force on a body */
    public Vector3D totalNetForce (Body target){
        Vector3D netForce = Vector3D.zeroVec() ;
        for (Body body : bodies){
            if (body!=target){
                netForce = netForce.imutAdd(ForceCalc.gravitationalForce(body,target) );
            }
        }
        return netForce;
    }
    public List<Body> getBodies() {
        return bodies;
    }
    public double getTimeStep() {
        return timeStep;
    }

}
