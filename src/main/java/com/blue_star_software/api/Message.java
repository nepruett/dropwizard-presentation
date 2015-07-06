package com.blue_star_software.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Message {
    private long id;

    @Length(min = 3)
    private String content;

    public Message() {
        // Jackson deserialization
    }

    public Message(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}