package de.uni.koeln.se.state;

import java.sql.SQLOutput;

public class Elevator{
    public static int c_floor=5;
    int d_floor;

    private Elv_States State = new Elv_States();

    public Elevator (int dest_floor){
        this.d_floor=dest_floor;
        System.out.println("destination floor is: "+ d_floor);
        arrive_atFloor();
    }

    private void arrive_atFloor(){
        State.current_state = State.idle;

        if(c_floor == d_floor){
            exit();
        }else if(c_floor < d_floor){
            go_up();
        }else{
            go_down();
        }
    }

    private void exit(){
        System.out.println("arrived at floor: " + c_floor);
    }

    private void go_up(){
        State.current_state = State.moving_up;
        c_floor++;
        System.out.println("current floor is: "+ c_floor);
        System.out.println("");
        if(c_floor >= d_floor){
            arrive_atFloor();
        }else{
            go_up();
        }
    }

    private void go_down(){
        State.current_state = State.moving_down;
        c_floor--;
        System.out.println("current floor is: "+ c_floor);
        if(c_floor <= d_floor){
            arrive_atFloor();
        }else{
            go_down();
        }
    }
}
