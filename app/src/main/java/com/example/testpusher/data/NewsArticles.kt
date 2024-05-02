package com.example.testpusher.data

import com.example.testpusher.R

/**
 * Created By Pradeep Rai on 4/26/2024.
 */
data class NewsArticle(
    val id: Int,
    val title: String,
    val summary: String,
    val imageUrl: Int
)
fun getSampleNewsArticles() = listOf(
    NewsArticle(1, "Technology Update", "A product description is copy that informs potential customers about the product’s benefits to convince them to buy. Great product descriptions give compelling reasons to consider making a purchase based on the needs of target customers.", R.drawable.image_one),
    NewsArticle(2, "Breaking News", "The “compelling reasons” are the main feature of strong product descriptions. There’s a common misconception that product descriptions need to describe the product. Their main job is actually to persuade customers to buy, which is more likely to happen when they focus on benefits, not features",  R.drawable.image_two),
    NewsArticle(3, "Technology Update", "The most common way to research customers is with a buyer persona: a representation of your ideal customer. It contains info like demographics, interests, needs, and goals.",  R.drawable.image_three),
    NewsArticle(4, "Breaking News", "The buyer persona here is not just any person looking for snacks. This description is tailored for people who are looking for better-for-you, healthy products.Customers in that segment would be interested in knowing the ingredients and the nutritional information. That’s why we can find all of this info in the description",  R.drawable.image_four)
)