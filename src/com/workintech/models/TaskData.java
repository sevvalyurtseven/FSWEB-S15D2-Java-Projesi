package com.workintech.models;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String assignee){
        if(assignee.equalsIgnoreCase("ann")){
            return this.getAnnsTasks();
        }
        if (assignee.equalsIgnoreCase("bob")) {
            return this.getBobsTasks();
        }
        if(assignee.equalsIgnoreCase("carol")){
            return this.getCarolsTasks();
        }
        if(assignee.equalsIgnoreCase("all")){
            return this.getUnion(bobsTasks, annsTasks, carolsTasks);
        }
        return new HashSet<>();
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public void setAnnsTasks(Set<Task> annsTasks) {
        this.annsTasks = annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public void setBobsTasks(Set<Task> bobsTasks) {
        this.bobsTasks = bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public void setCarolsTasks(Set<Task> carolsTasks) {
        this.carolsTasks = carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public void setUnassignedTasks(Set<Task> unassignedTasks) {
        this.unassignedTasks = unassignedTasks;
    }


    @Override
    public String toString() {
        return "TaskData{" +
                "annsTasks=" + annsTasks +
                ", bobsTasks=" + bobsTasks +
                ", carolsTasks=" + carolsTasks +
                ", unassignedTasks=" + unassignedTasks +
                '}';
    }
}
