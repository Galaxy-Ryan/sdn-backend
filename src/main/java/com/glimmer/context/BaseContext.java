package com.glimmer.context;

public class BaseContext {

    public static ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();

    public static void setCurrentId(Integer id) {
        threadLocal1.set(id);
    }

    public static Integer getCurrentId() {
        return threadLocal1.get();
    }

    public static void removeCurrentId() {
        threadLocal1.remove();
    }
}
