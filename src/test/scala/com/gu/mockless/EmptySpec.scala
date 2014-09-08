package com.gu.mockless

import org.specs2.mutable.Specification
import Empty.empty
import Empty.auto._

case class Author(
  firstName: String,
  middleName: Option[String],
  lastName: String
)

case class Book(
  title: String,
  yearPublished: Int,
  authors: List[Author],
  references: Map[String, String]
)

class EmptySpec extends Specification {
  "Empty" should {
    "create a List" in {
      empty[List[Int]] shouldEqual Nil
    }

    "create a Seq" in {
      empty[Seq[String]] shouldEqual Nil
    }

    "create a Map" in {
      empty[Map[Int, String]] shouldEqual Map.empty
    }

    "create an Either" in {
      empty[Either[Int, String]] shouldEqual Right("")
    }

    "create an Author" in {
      empty[Author] shouldEqual Author(
        "",
        None,
        ""
      )
    }

    "create a Book" in {
      empty[Book] shouldEqual Book(
        "",
        0,
        Nil,
        Map.empty
      )
    }
  }
}
