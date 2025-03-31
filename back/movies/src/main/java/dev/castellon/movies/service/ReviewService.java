package dev.castellon.movies.service;

import dev.castellon.movies.entity.Movie;
import dev.castellon.movies.entity.Review;
import dev.castellon.movies.repository.ReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    public List<Review> allReviews(){
        return reviewRepository.findAll();
    }

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.save(new Review(reviewBody));


        //mongoTemplate.update(Movie.class)
        //         .matching(Criteria.where("imdbId").is(imdbId))
        //        .apply(new Update().push("reviewIds").value(review))
        //        .first();

        // 2. Agregar referencia a la película correspondiente
        mongoTemplate.updateFirst(
                Query.query(Criteria.where("imdbId").is(imdbId)),
                new Update().push("reviewIds", review),
                Movie.class
        );

        return review;
    }
    public boolean deleteReview(String reviewId) {

        if (!ObjectId.isValid(reviewId)) {
            return false;
        }

        ObjectId objectId = new ObjectId(reviewId);

        // 1. Eliminar la review de las películas que la referencian
        mongoTemplate.updateMulti(
                Query.query(Criteria.where("reviewIds._id").is(objectId)),
                new Update().pull("reviewIds", Query.query(Criteria.where("_id").is(objectId))),
                Movie.class
        );

        // 2. Eliminar la review de la colección de reviews
        if (reviewRepository.existsById(objectId)) {
            reviewRepository.deleteById(objectId);
            return true;
        }
        return false;
    }

}

