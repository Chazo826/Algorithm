package thirty_day_leetcoding_challenge

fun main() {

}

class ValidParenthesisString {

    fun checkValidString(s: String): Boolean {
        var leftParenthesis = 0
        var rightParenthesis = 0

        for (c in s) {
            leftParenthesis += if(c == '(') 1 else -1
            rightParenthesis += if(c == ')') -1 else 1
            if(rightParenthesis < 0) break
            leftParenthesis = if(leftParenthesis < 0) 0 else leftParenthesis
        }

        return leftParenthesis == 0
    }
}