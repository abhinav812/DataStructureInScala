package com.abhinav.scala.algorithm.binarytree.immutable

object BinarySearchTree {

  /*
    insert(node, key, value)

    1. if(node == NULL) return new Node(key, value)

    2. if(key == node.key) return new Node(key, value, node.left, node.right)

    3. if(key > node.key)
        right = insert(node.right, key, value)
        return new Node(node.key, node.value, node.left, right)
    4. else
        left = insert(node.left, key, value)
        return new Node(key, value, left, node.right)
   */

}
