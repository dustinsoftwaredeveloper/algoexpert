// one for loop, one pointer
// O(n) time, O(1) space

object Solution {
    def isSubsequence(s: String, t:String): Boolean = {
        var sPointer: Int = 0
        for(i <- t) {
            if(sPointer == s.length) return true
            if(i == s(sPointer)) sPointer += 1
        }
        return sPointer == s.length
    }
}