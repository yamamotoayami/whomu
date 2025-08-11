package com.whomu.whomu.repo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whomu.whomu.model.Question;

import java.io.File;
import java.util.*;

public class QuestionStore {
    private final File file = new File("questions.json");
    private final ObjectMapper om = new ObjectMapper();
    private final List<Question> data = new ArrayList<>();

    public QuestionStore() {
        try {
            if (file.exists()) {
                data.addAll(om.readValue(file, new TypeReference<List<Question>>(){}));
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public synchronized List<Question> all() {
        return data.stream()
                .sorted(Comparator.comparing(Question::getCreatedAt).reversed())
                .toList();
    }

    public synchronized Question find(String id) {
        return data.stream().filter(q -> q.getId().equals(id)).findFirst().orElse(null);
    }

    public synchronized void add(Question q) {
        data.add(q);
        save();
    }

    private void save() {
        try { om.writerWithDefaultPrettyPrinter().writeValue(file, data); }
        catch (Exception e) { e.printStackTrace(); }
    }
    public synchronized void incFumu(String id) {
        for (var q : data) {
            if (q.getId().equals(id)) {
                q.setFumu(q.getFumu() + 1);
                save();
                return;
            }
        }
    }

}
