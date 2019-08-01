package com.android.phonehelper;

public class ResultItem {
    private String content;
    private String video;

    public ResultItem(String content, String video) {
        this.content = content;
        this.video = video;
    }

    public String getContent() {
        return content;
    }

    public String getVideo() {
        return video;
    }
}
