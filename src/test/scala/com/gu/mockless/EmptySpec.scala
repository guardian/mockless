package com.gu.mockless

import org.specs2.mutable.Specification
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
      Empty.instance[List[Int]] shouldEqual Nil
    }

    "create a Seq" in {
      Empty.instance[Seq[String]] shouldEqual Nil
    }

    "create a Map" in {
      Empty.instance[Map[Int, String]] shouldEqual Map.empty
    }

    "create an Either" in {
      Empty.instance[Either[Int, String]] shouldEqual Right("")
    }

    "create an Author" in {
      Empty.instance[Author] shouldEqual Author(
        "",
        None,
        ""
      )
    }

    "create a Book" in {
      Empty.instance[Book] shouldEqual Book(
        "",
        0,
        Nil,
        Map.empty
      )
    }
  }
}
