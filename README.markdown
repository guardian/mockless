# Mockless

Introduces the `Empty` typeclass, which provides an 'empty' value for a given
type. Also includes *automatic derivation* of `Empty` for case
classes. Writing tests has never been so easy!

## Usage

```scala
import com.gu.mockless.Empty.auto._
import com.gu.mockless.Empty.empty

object Book {
  lazy val empty = empty[Book]
  
  assert(empty == Book(
    "",
    0,
    Nil,
    Map.empty
  )) // true 
}

case class Book(
  title: String,
  yearPublished: Int,
  authors: List[Author],
  references: Map[String, String]
)

```
