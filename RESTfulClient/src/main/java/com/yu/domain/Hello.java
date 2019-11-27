package com.yu.domain;


/*
    通过这个实体类获取昨天SpringBoot_hello项目的响应
 */
public class Hello {

    private long id;
    private String content;

    public Hello() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
