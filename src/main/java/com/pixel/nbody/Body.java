package com.pixel.nbody;

public class Body {
    private Vector3D position, velocity ,acceleration;
    private final double mass;
    private final double radius;
    private final int bodyID;
        /* basic constructor */
        Body(double mass,double radius, int bodyID){
            this.mass = mass;
            this.radius = radius;
            this.bodyID = bodyID;
            this.acceleration  = new Vector3D(0,0,0);
        }
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
    public double getRadius(){
        return radius;
    }
      public int getBodyID(){
        return bodyID;
      }

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
        /* method to update position and velocity - this will be called by RK4 integrator */
        public void updatePosAndVel(Vector3D npos , Vector3D nvel){
            setPosition(npos);
            setVelocity(nvel);
        }
        /*method to calculate distance between to bodies */
        public double distanceBtw(Body Other){
            return this.position.distance(Other.position);
        }
        /* kinetic energy */
        public double KineticEnergy(){
            return ( 0.5 * mass * velocity.magnitude() );
        }

}