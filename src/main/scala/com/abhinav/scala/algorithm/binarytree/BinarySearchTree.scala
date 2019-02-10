package com.abhinav.scala.algorithm.binarytree

trait BinarySearchTree[K, V] {

  def search(key: K): Option[V]

  def insert(key: K, value: V): BinarySearchTree[K, V]

  def foreachDFS(f: (K, V) => Unit)

  def foreachBFS(f: (K, V) => Unit)

  def mirror(): BinarySearchTree[K, V]

}
