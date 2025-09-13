package com.pixel.nbody;

public class Body {
    private Vector3D position, velocity,acceleration;
    private double mass,radius;
    int bodyID;

      /* getter methods for the fields above */

     /* returns current position of body */
     public Vector3D getPosition(){
        return position;
      }
    /* returns velocity of body */
    public Vector3D getVelocity(){
        return velocity;
      }
    /* returns acceleration of body */
    public Vector3D getAcceleration(){
        return acceleration;
      }
      /* returns mass of body */
    public double getMass(){
       return mass;
      }
    /* return mass of body */
    /*setter methods for this class fields */

    public void setPosition(Vector3D position){
        this.position = position;
      }

    public void setVelocity(Vector3D velocity){
        this.velocity = velocity;
      }
    public void setAcceleration(Vector3D acceleration){
        this.acceleration = acceleration;
      }

}