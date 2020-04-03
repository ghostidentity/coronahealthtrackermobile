package me.mtagab.ncov.model;

public class Tasks {

    public Tasks(String taskname) {
        this.taskname = taskname;
    }

    private int taskid;

    public int getTaskid() {
        return taskid;
    }

    public String getTaskname() {
        return taskname;
    }


    private String taskname;
}
