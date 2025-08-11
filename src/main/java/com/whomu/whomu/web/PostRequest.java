package com.whomu.whomu.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PostRequest {
    @Size(max = 40, message = "名前は40文字までです")
    private String author;

    @NotBlank(message = "問いは必須です")
    @Size(max = 2000, message = "問いは2000文字までです")
    private String content;

    @Size(max = 200, message = "パスは200文字までです")
    private String imagePath;

    // getter/setter
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}
