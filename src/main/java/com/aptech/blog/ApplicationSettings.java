package com.aptech.blog;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ApplicationSettings {
    private final TopicList topicList;
    private final NewsItems newsItems;
    public static final String topic = "topic";
    public static final String newsItem = "newsItem";
    public static final String all = "all";

    public ApplicationSettings() {
        topicList = new TopicList();
        newsItems = new NewsItems();
    }

    public List<NewsItem> getNewsForTopic(int type) {
        if(type==0){
            return  getNewsItems().getNewsItems();
        }
        var itemStream = getNewsItems().getNewsItems().stream().filter(t -> (t.topic() == type || t.topic() == 0));
        var items = itemStream.collect(Collectors.toList());
        return items;

    }

    public List<NewsItem> setUpData(String type, String detail) {
        if (type.equals(topic)) {
            var topic = getTopicList().getTopics().stream().filter(t -> t.title().equalsIgnoreCase(detail))
                    .findFirst().orElseGet(() -> new Topic(0, all, ""));
            return getNewsForTopic(topic.id());

        } else {
            return getNewsForTopic(0);
        }
    }
}
