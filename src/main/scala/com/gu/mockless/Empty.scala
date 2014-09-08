package com.gu.mockless

import shapeless._

trait Empty[A] {
  def empty: A
}

object Empty extends ProductTypeClassCompanion[Empty] {
  def empty[A](implicit M: Empty[A]) = M.empty

  implicit val emptyInt = new Empty[Int] {
    override def empty: Int = 0
  }

  implicit val emptyString = new Empty[String] {
    override def empty: String = ""
  }

  implicit def emptyOption[A] = new Empty[Option[A]] {
    override def empty: Option[A] = None
  }

  implicit def emptyList[A] = new Empty[List[A]] {
    override def empty: List[A] = Nil
  }

  implicit def emptySeq[A] = new Empty[Seq[A]] {
    override def empty: Seq[A] = Nil
  }

  implicit def emptyMap[A, B] = new Empty[Map[A, B]] {
    override def empty: Map[A, B] = Map.empty
  }

  implicit def emptyEither[A, B](implicit M: Empty[B]) = new Empty[Either[A, B]] {
    override def empty: Either[A, B] = Right(M.empty)
  }

  implicit val emptyInstance: ProductTypeClass[Empty] = new ProductTypeClass[Empty] {
    override def emptyProduct: Empty[HNil] = new Empty[HNil] {
      override def empty: HNil = HNil
    }

    override def product[H, T <: HList](CHead: Empty[H], CTail: Empty[T]): Empty[H :: T] = new Empty[H :: T] {
      override def empty: H :: T = CHead.empty :: CTail.empty
    }

    override def project[F, G](instance: => Empty[G], to: (F) => G, from: (G) => F): Empty[F] = new Empty[F] {
      override def empty: F = from(instance.empty)
    }
  }
}

