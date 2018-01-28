package br.com.example.springmongodbapi.entity;

public class Review {

    private String userName;
    private int rating;
    private boolean approved;

    public Review() {

    }

    public Review(String userName, int rating, boolean approved) {
        super();
        this.userName = userName;
        this.rating = rating;
        this.approved = approved;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "Review{" +
                "userName='" + userName + '\'' +
                ", rating=" + rating +
                ", approved=" + approved +
                '}';
    }
}
