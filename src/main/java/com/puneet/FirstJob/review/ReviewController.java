package com.puneet.FirstJob.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
        boolean isReviewSaved = reviewService.addReview(companyId,review);
        if(isReviewSaved) {
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review Not Added ", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        return new  ResponseEntity<>(reviewService.getReview(companyId,reviewId), HttpStatus.OK);
    }
    @DeleteMapping("reviews/{reviewId}")
    public ResponseEntity<String>  deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReview(companyId,reviewId);
        if(isReviewDeleted) {
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review Not Deleted ", HttpStatus.NOT_FOUND);
        }
    }
}