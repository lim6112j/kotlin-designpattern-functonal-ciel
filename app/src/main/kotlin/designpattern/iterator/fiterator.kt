package designpattern.iterator
import arrow.core.Option
import arrow.core.None
import arrow.core.Some
import arrow.core.Either
import arrow.core.Either.*
// type
data class FFriend(val name: String, val age: Int)
class FFriends(val friends: List<FFriend>)
// pure function
fun hasMore(friends: FFriends, idx: Int): Boolean = friends.friends.size > idx
typealias State = Int
fun next(pair: Pair<FFriends, State>): Either<String, Pair<FFriend,State>> {
  if(hasMore(pair.first, pair.second)) {
    val currentFriend = pair.first.friends[pair.second]
    if (currentFriend.age <0) {return Left("age can not be below zero")} else {
      return Right (currentFriend to (pair.second+1))
    }
  }
  return Left("no value") 
}

