package com.whomu.whomu.model;

import java.time.Instant;
import java.util.UUID;

public class Question {
    private String id;
    private String author;      // 任意
    private String content;     // 長文OK
    private String imagePath;   // スクショ（任意）
    private Instant createdAt;

    public Question() {}

    public static Question of(String author, String content, String imagePath) {
        Question q = new Question();
        q.id = UUID.randomUUID().toString();
        q.author = (author == null || author.isBlank()) ? "匿名" : author;
        q.content = content;
        q.imagePath = (imagePath == null || imagePath.isBlank()) ? null : imagePath;
        q.createdAt = Instant.now();
        return q;
    }

    // getter / setter
    public String getId() { return id; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }
    public String getImagePath() { return imagePath; }
    public Instant getCreatedAt() { return createdAt; }
    public void setId(String id) { this.id = id; }
    public void setAuthor(String author) { this.author = author; }
    public void setContent(String content) { this.content = content; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    private int fumu;  // ふみゅ数

    public int getFumu() { return fumu; }
    public void setFumu(int fumu) { this.fumu = fumu; }

}
