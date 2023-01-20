package com.aptech.blog;

import lombok.Getter;


import java.util.ArrayList;
import java.util.List;

@Getter
public class TopicList {
    private final List<Topic> topics = new ArrayList<>();

    public TopicList() {
        topics.add(new Topic(1, "Servlets", "servlets"));
        topics.add(new Topic(2, "JSP", "jsp"));
        topics.add(new Topic(3, "Securiry", "security"));
    }
}
