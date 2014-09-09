package com.gu.mockless

import org.specs2.mutable.Specification
import Empty.{empty => emptyInstance}
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
      emptyInstance[List[Int]] shouldEqual Nil
    }

    "create a Seq" in {
      emptyInstance[Seq[String]] shouldEqual Nil
    }

    "create a Map" in {
      emptyInstance[Map[Int, String]] shouldEqual Map.empty
    }

    "create an Either" in {
      emptyInstance[Either[Int, String]] shouldEqual Right("")
    }

    "create an Author" in {
      emptyInstance[Author] shouldEqual Author(
        "",
        None,
        ""
      )
    }

    "create a Book" in {
      emptyInstance[Book] shouldEqual Book(
        "",
        0,
        Nil,
        Map.empty
      )
    }
  }
}
