package com.android.phonehelper;

class ResultItem {
    private String content;
    private int video;
    private String keywords;
    private int image;

    ResultItem(String keywords, String content, int video, int image) {
        this.image = image;
        this.keywords = keywords;
        this.content = content;
        this.video = video;
    }

    String getContent() {
        return content;
    }

    int getVideo() {
        return video;
    }

    String getKeywords() {
        return keywords;
    }

    int getImage() {
        return image;
    }
}
