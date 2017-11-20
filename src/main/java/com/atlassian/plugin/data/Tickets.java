package com.atlassian.plugin.data;

/**
 * Created by dima_home on 20.11.17.
 */
public class Tickets {

    private Integer id;
    private String name;
    private String description;

    public Tickets() {
    }

    public Tickets(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
