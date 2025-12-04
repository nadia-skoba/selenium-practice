public class Post {
    public String title;
    public String body;
    public int userld;
    public Integer id;

    public Post() {
    }

    public Post(String title, String body, int userld) {
        this.body = body;
        this.title = title;
        this.userld = userld;
    }
}