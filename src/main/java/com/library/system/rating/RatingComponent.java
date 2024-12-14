package com.library.system.rating;

import java.util.ArrayList;
import java.util.List;

public abstract class RatingComponent {
    public void add(RatingComponent ratingComponent) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    public void remove(RatingComponent ratingComponent) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    public abstract String getDetails();
}

class BookRating extends RatingComponent {
    private String review;
    private int rating;

    public BookRating(String review, int rating) {
        this.review = review;
        this.rating = rating;
    }

    @Override
    public String getDetails() {
        return "Rating: " + rating + ", Review: " + review;
    }
}

class RatingGroup extends RatingComponent {
    private List<RatingComponent> ratings = new ArrayList<>();

    @Override
    public void add(RatingComponent ratingComponent) {
        ratings.add(ratingComponent);
    }

    @Override
    public void remove(RatingComponent ratingComponent) {
        ratings.remove(ratingComponent);
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        for (RatingComponent rating : ratings) {
            details.append(rating.getDetails()).append("\n");
        }
        return details.toString();
    }
}
