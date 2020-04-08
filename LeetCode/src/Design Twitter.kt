
fun main() {
    Twitter().postTweet(1, 3)
}

private class Twitter() {

    data class Feed(
        val userId: Int,
        val tweetId: Int
    )

    /** Initialize your data structure here. */
    private val followMap = HashMap<Int, Set<Int>>()

    private val feeds = mutableListOf<Feed>()

    /** Compose a new tweet. */
    fun postTweet(userId: Int, tweetId: Int) {
        feeds.add(Feed(userId, tweetId))
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    fun getNewsFeed(userId: Int): List<Int> {
        return feeds.filter { followMap[userId]?.contains(it.userId) == true || it.userId == userId }.let {
            if(it.size > 10) it.takeLast(10)
            else it
        }.map { it.tweetId }.reversed()
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    fun follow(followerId: Int, followeeId: Int) {
        val follow = followMap[followerId] ?: mutableSetOf()
        followMap[followerId] = follow.plus(followeeId)
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    fun unfollow(followerId: Int, followeeId: Int) {
        val follow = followMap[followerId]
        follow?.minus(followeeId)?.let {
            followMap[followerId] = it
        }
    }

}