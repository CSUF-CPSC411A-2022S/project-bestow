package com.example.testproject

class GivingScore(val score: String)
{

    override current(val curr_score: String, val item: String; val item_rating: Int)
    {
         curr_score = score
         val rating_score: Int = 500
         curr_score += rating_score
    }
}