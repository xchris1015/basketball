package io.chris.training.core.domain;

public class JsView {
    public static class Registered_User{} //{} represent as class or implementation
    public static class Player extends Registered_User {}
    public static class Coach extends Player{}
    public static class Admin extends Coach{}
}
