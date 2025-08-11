package com.whomu.whomu.web;

import com.whomu.whomu.model.Question;
import com.whomu.whomu.repo.QuestionStore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestionController {
    private final QuestionStore store = new QuestionStore();

    // 一覧（トップ）
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("questions", store.all());
        return "index";
    }

    // 投稿フォーム
    // 投稿フォーム表示
    @GetMapping("/submit")
    public String submit(org.springframework.ui.Model model) {
        if (!model.containsAttribute("form")) model.addAttribute("form", new PostRequest());
        return "submit";
    }

    // 投稿処理
    @PostMapping("/submit")
    public String doSubmit(@jakarta.validation.Valid @ModelAttribute("form") PostRequest form,
                           org.springframework.validation.BindingResult br,
                           @RequestParam(value="image", required=false) org.springframework.web.multipart.MultipartFile image) {
        if (br.hasErrors()) return "submit";

        String url = null;
        try {
            if (image != null && !image.isEmpty()) {
                java.nio.file.Path dir = java.nio.file.Paths.get("uploads").toAbsolutePath().normalize();
                java.nio.file.Files.createDirectories(dir);
                // 拡張子保持してユニーク名に
                String ext = org.springframework.util.StringUtils.getFilenameExtension(image.getOriginalFilename());
                String filename = java.util.UUID.randomUUID().toString() + (ext != null ? "." + ext : "");
                java.nio.file.Path dest = dir.resolve(filename);
                image.transferTo(dest.toFile());
                url = "/uploads/" + filename; // ← これを画像URLとして保存
            }
        } catch (Exception e) { e.printStackTrace(); }

        store.add(com.whomu.whomu.model.Question.of(form.getAuthor(), form.getContent(), url));
        return "redirect:/";
    }



    // 詳細
    @GetMapping("/q/{id}")
    public String detail(@PathVariable String id, Model model) {
        var q = store.find(id);
        if (q == null) return "redirect:/";
        model.addAttribute("q", q);
        return "detail";
    }

    @PostMapping("/q/{id}/fumu")
    public String fumu(@PathVariable String id) {
        store.incFumu(id);
        return "redirect:/q/" + id;
    }

}
