package com.abhinav.scala.algorithm.binarytree.mutable

import com.abhinav.scala.algorithm.binarytree.{BinaryNode, BinarySearchTree}

import scala.collection.immutable.Queue

class MutableBinarySearchTree[K, V](root: BinaryNode[K, V], ord: Ordering[K]) extends BinarySearchTree[K, V] {

  override def search(key: K): Option[V] = search(key, root)

  override def insert(key: K, value: V): BinarySearchTree[K, V] =
    new MutableBinarySearchTree(insert(key, value, root), ord)

  /*
    search(node, key)

    1. if(node == NULL) return NULL

    2. if(key == node.key) return node.value

    3. if(key > node.key) return search(node.right, key)

    4. else return search(node.left, key)

   */
  private def search(key: K, node: BinaryNode[K, V]): Option[V] = key match {
    case node.key => Some(node.value)
    case k if ord.lt(key, node.key) => node.left.flatMap(n => search(k, n))
    case k if ord.gt(key, node.key) => node.right.flatMap(n => search(k, n))
  }


  /*
    insert(node, key, value)

    1. if(node == NULL) return new Node(key, value)

    2. if(key == node.key) node.value = value

    3. if(key > node.key)
        node.right = insert(node.right, key, value)
    4. else
        node.left = insert(node.left, key, value)
    5. return node
   */
  private def insert(key: K, value: V, node: BinaryNode[K, V]): BinaryNode[K, V] = key match {
    case node.key => node.copy(value = value)
    case k if ord.lt(key, node.key) =>
      val newLeft = node.left.map(n => insert(key, value, n)).orElse(Some(BinaryNode(key, value)))
      node.copy(left = newLeft)
    case k if ord.gt(key, node.key) =>
      val newRight = node.right.map(n => insert(key, value, n)).orElse(Some(BinaryNode(key, value)))
      node.copy(right = newRight)
  }

  /**
    * Depth-First-Search in binary search tree
    */
  override def foreachDFS(f: (K, V) => Unit): Unit = foreachDFS(f, root)

  private def foreachDFS(f: (K, V) => Unit, node: BinaryNode[K, V]): Unit = {
    node.left.foreach(n => foreachDFS(f, n))
    f(node.key, node.value)
    node.right.foreach(n => foreachDFS(f, n))
  }

  /**
    * Breadth-First-Search in binary search tree
    */
  override def foreachBFS(f: (K, V) => Unit): Unit = {
    val sq = Stream.iterate(Queue(root)) { q =>
      val (node, tail ) = q.dequeue
      tail ++ node.left ++ node.right
    }
    sq.takeWhile(_.nonEmpty).foreach(q => f(q.head.key, q.head.value))
  }

  /*
      mirror(node)

      1. if(node == NULL) return NULL

      2. if(node.right == NULL && node.left == NULL) return node

      3.
        leftNode = node.left
        rightNode = node.right

        node.left = mirror(rightNode)
        node.right = mirror(leftNode)
   */

  def mirror(): BinarySearchTree[K, V] = new MutableBinarySearchTree(mirror(root), ord)

  private def mirror(node: BinaryNode[K, V]): BinaryNode[K, V] = {
    node match {
      case n if node.right.isEmpty && node.left.isEmpty => n.copy()
      case _ =>
        val leftNode: Option[BinaryNode[K, V]] = node.right.map(r => mirror(r))
        val rightNode: Option[BinaryNode[K, V]] = node.left.map(l => mirror(l))

        node.copy(left = leftNode, right = rightNode)
    }
  }

}

object MutableBinarySearchTree {
  def apply[K, V](key: K, value: V)(implicit ord: Ordering[K]) =
    new MutableBinarySearchTree[K, V](BinaryNode(key, value), ord)
}
