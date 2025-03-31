package dev.castellon.movies.controller;

import dev.castellon.movies.service.ReviewService;
import dev.castellon.movies.entity.Review;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins="*")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        return new ResponseEntity<List<Review>>(reviewService.allReviews(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteSingleReview(@PathVariable String reviewId) {

        try {

            if (!ObjectId.isValid(reviewId)) {
                return ResponseEntity.badRequest().body("Invalid review ID");
            }

            boolean wasDeleted = reviewService.deleteReview(reviewId);

            if (wasDeleted) {
                return ResponseEntity.ok("Review successfully removed");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Review with ID not found: " + reviewId);
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error processing the request: " + e.getMessage());
        }
    }

}
