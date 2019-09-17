package com.vote.model;
import lombok.*;


// model for request body 
@Data
public  class BodyVote {
    private Long prepleid;
    private Long[] competitor;
    private Long votetype;
}