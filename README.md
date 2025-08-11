# whomu — What You Ask Is Who You Are
Minimal dark-themed Q&amp;A SNS to share questions you ask AI. Built with Java + Spring Boot.

黒×白×紫のミニマルUIで、「ChatGPTに投げた問い」を共有する**質問ギャラリーSNS**（MVP）。  
**テーマ：**「齟齬のない世界へ」— 人は“何をAIに問うか”で滲み出る。

## Screens
- 一覧（複数投稿、長文は「…もっと見る」）
- ![List View](docs/list.png)
- 詳細（スクショ画像＋♡ふみゅ）
-  ![Detail View](docs/detail.png)
- 投稿フォーム（PH:「チャッピーと何話したの？」）
-  ![Post Form](docs/post.png)

## Features (MVP)
- 投稿（長文OK / 画像アップロード対応）
- 一覧（新着順、長文は省略表示→もっと見る）
- 詳細（スクショ表示、♡ふみゅリアクション）
- ダークテーマ：黒 × 白 × 紫

## Tech
- Java 21 / Spring Boot 3.5
- Thymeleaf
- JSON file storage (`questions.json`)  
  画像は `/uploads/` に保存・配信

## Run (Local)
```bash
./mvnw spring-boot:run
# http://localhost:8080
```






### (English)
# whomu — What You Ask Is Who You Are
A question gallery SNS (MVP) with a black × white × purple minimal UI, showcasing the questions people have asked ChatGPT.
Theme: “Towards a World Without Misunderstandings” — A person’s true self seeps through in what they choose to ask AI.

# Screens
List view: Multiple posts, long texts are truncated with “…see more”

Detail view: Screenshot image + ♡ "whoumu" reaction

Post form: Placeholder — “What did you talk about with Chappy?”


# Features (MVP)
Posting (supports long text / image uploads)

List view (latest first, long text truncated → see more)

Detail view (displays uploaded image, ♡ "Fumu" reaction)

Dark theme: black × white × purple

# Tech Stack
Java 21 / Spring Boot 3.5

Thymeleaf

JSON file storage (questions.json)
Images are stored & served from /uploads/

# Run Locally
```bash
./mvnw spring-boot:run
# http://localhost:8080
```






