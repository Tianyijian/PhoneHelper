package com.android.phonehelper;

public class ResultItem {
    private String content;
    private int video;
    private String keywords;

    public ResultItem(String keywords, String content, int video) {
        this.keywords = keywords;
        this.content = content;
        this.video = video;
    }

    public String getContent() {
        return content;
    }

    public int getVideo() {
        return video;
    }

    public String getKeywords() {
        return keywords;
    }
}
