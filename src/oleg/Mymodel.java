package oleg;


import java.util.ArrayList;

class MyModel {

    private PageInfo pageInfo;
    private ArrayList<Post> posts = new ArrayList<>();
}

class PageInfo {

    private String pageName;
    private String pagePic;
}

class Post {

    private String post_id;

    //@SerializedName("actor_id") // <- example SerializedName
    private String actorId;

    private String picOfPersonWhoPosted;
    private String nameOfPersonWhoPosted;
    private String message;
    private String likesCount;
    private ArrayList<String> comments;
    private String timeOfPost;
}
