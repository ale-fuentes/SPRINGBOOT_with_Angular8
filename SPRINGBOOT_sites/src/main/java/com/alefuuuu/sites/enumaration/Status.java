package com.alefuuuu.sites.enumaration;

/**
 * @author Ale Fuentes (https://github.com/ale-fuentes)
 * @version 1.0
 * @since 25/05/2022
 */
public enum Status {
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");
    private final String status;

    Status(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
