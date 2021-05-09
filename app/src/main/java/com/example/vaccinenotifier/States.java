package com.example.vaccinenotifier;

public class States {

    private String state_name;
    private int state_id;

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public int getState_id() {
        return state_id;
    }

    @Override
    public String toString() {
        return "States{" +
                "state_name='" + state_name + '\'' +
                ", state_id=" + state_id +
                '}';
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }
}
