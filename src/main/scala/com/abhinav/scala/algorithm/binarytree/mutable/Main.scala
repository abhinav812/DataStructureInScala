package com.abhinav.scala.algorithm.binarytree.mutable

import com.abhinav.scala.algorithm.binarytree.BinarySearchTree

object Main extends App {
  val tree: BinarySearchTree[Int, String] = MutableBinarySearchTree(10, "Ten")
    .insert(5, "Five")
    .insert(15, "Fifteen")
    .insert(25, "TwentyFive")
    .insert(2, "Two")
    .insert(8, "Eight")
    .insert(6, "Six")
    .insert(11, "Eleven")
    .insert(18, "Eighteen")

  println(tree.search(10))
  println(tree.search(5))
  println(tree.search(15))
  println(tree.search(25))
  println(tree.search(9))

  tree.foreachDFS((k, v) => print(s"$k $v |"))
  println()
  tree.foreachBFS((k, v) => print(s"$k $v |"))
  println()


  val mirror: BinarySearchTree[Int, String] = tree.mirror()
  mirror.foreachDFS((k, v) => print(s"$k $v |"))
  println()

  val orig: BinarySearchTree[Int, String] = mirror.mirror()
  orig.foreachDFS((k, v) => print(s"$k $v |"))
  println()
}
