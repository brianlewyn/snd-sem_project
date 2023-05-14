package controller;

public interface SubjectController{
    String consult(String name);
    boolean remove(String name);
    boolean contains(String name);
    String type();
}