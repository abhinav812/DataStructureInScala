package com.abhinav.scala.algorithm.binarytree

case class BinaryNode[K, V] (
                      key: K,
                      value: V,
                      left: Option[BinaryNode[K, V]] = None,
                      right: Option[BinaryNode[K, V]] = None
                      )
