package designpattern.iterator
import arrow.core.Option
import arrow.core.None
import arrow.core.Some
// type
data class FFriend(val name: String, val age: Int)
class FFriends(val friends: List<FFriend>)
// pure function
fun hasMore(friends: FFriends, idx: Int): Boolean = friends.friends.size > idx
typealias State = Int
fun next(pair: Pair<FFriends, State>): Option<Pair<FFriend,State>> {
  if(hasMore(pair.first, pair.second)) {
    val currentFriend = pair.first.friends[pair.second]
    return Some (currentFriend to (pair.second+1))
  }
  return None
}

