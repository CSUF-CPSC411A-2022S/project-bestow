package com.example.testproject

class GivingScore(var currScore: Int, var rating: Int, var numofItems: Int, var new_item: Int)
{

    fun check()
    {
        var tempor = 0
        if (new_item == 1)
        {
            numofItems++
            when(numofItems)
            {
                0 -> tempor + 0
                in 1..5 -> tempor + 50
                in 6..10 -> tempor + 100
                in 11..15 -> tempor + 150
                in 16..20 -> tempor + 200
                in 21..25 -> tempor + 250
                in 26..30 -> tempor + 300
                in 31..40 -> tempor + 350
                in 41..50 -> tempor + 400
                in 51..60 -> tempor + 450
                else -> tempor + 500

            }
        }
       when(rating) {
          0 -> tempor + 0
          1 -> tempor + 200
          2 -> tempor + 400
          3 -> tempor + 600
          4 -> tempor + 800
          5 -> tempor + 1000
        }
        currScore += tempor
    }
}