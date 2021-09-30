package com.pluralsight.serialization;

import java.util.List;

public class Movie2 extends Item {

    private Record record;
    private List<String> actors;

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }
}
