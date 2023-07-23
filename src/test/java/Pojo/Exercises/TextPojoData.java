package Pojo.Exercises;

public class TextPojoData {


        private String title;
        private String author;
        private String genre;
        private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextPojoData{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
