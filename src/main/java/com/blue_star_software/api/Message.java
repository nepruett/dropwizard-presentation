package com.blue_star_software.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
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

    @Override
    public int hashCode() {
        return Objects.hashCode(id, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null && o instanceof Message) {
            Message other = (Message)o;
            return Objects.equal(id, other.id) &&
                    Objects.equal(content, other.content);
        }
        return false;
    }
}