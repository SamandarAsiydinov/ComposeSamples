package com.example.jetpackcomposeviews.flip

enum class FlipCard(val angle: Float) {
    Forward(0f) {
        override val next: FlipCard get() = Previous
    },
    Previous(180f) {
        override val next: FlipCard get() = Forward
    };

    abstract val next: FlipCard
}