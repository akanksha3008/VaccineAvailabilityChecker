package com.example.vaccinenotifier;

import java.util.List;

public class AllStates {
    public List<States> getStateList() {
        return StateList;
    }

    public void setStateList(List<States> stateList) {
        StateList = stateList;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i=0;i<getStateList().size();i++)
        {
            str +=this.StateList.get(i).toString()+"\n";
        }
        return str;
    }

    private List<States> StateList;
}
