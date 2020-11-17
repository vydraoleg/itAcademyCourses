package oleg;


import java.util.ArrayList;

class MyModel {

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    private PageInfo pageInfo;
    private ArrayList<Post> posts = new ArrayList<>();
}

class PageInfo {

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPagePic() {
        return pagePic;
    }

    public void setPagePic(String pagePic) {
        this.pagePic = pagePic;
    }

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

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getPicOfPersonWhoPosted() {
        return picOfPersonWhoPosted;
    }

    public void setPicOfPersonWhoPosted(String picOfPersonWhoPosted) {
        this.picOfPersonWhoPosted = picOfPersonWhoPosted;
    }

    public String getNameOfPersonWhoPosted() {
        return nameOfPersonWhoPosted;
    }

    public void setNameOfPersonWhoPosted(String nameOfPersonWhoPosted) {
        this.nameOfPersonWhoPosted = nameOfPersonWhoPosted;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(String likesCount) {
        this.likesCount = likesCount;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public String getTimeOfPost() {
        return timeOfPost;
    }

    public void setTimeOfPost(String timeOfPost) {
        this.timeOfPost = timeOfPost;
    }
}
