# whomu — What You Ask Is Who You Are
Minimal dark-themed Q&amp;A SNS to share questions you ask AI. Built with Java + Spring Boot.

黒×白×紫のミニマルUIで、「ChatGPTに投げた問い」を共有する**質問ギャラリーSNS**（MVP）。  
**テーマ：**「齟齬のない世界へ」— 人は“何をAIに問うか”で滲み出る。

## Screens
（画像を `docs/` に置いて、ここに貼る）
- 一覧（複数投稿、長文は「…もっと見る」）
- 詳細（スクショ画像＋♡ふみゅ）
- 投稿フォーム（PH:「チャッピーと何話したの？」）

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

