package com.abhinav.scala.algorithm.binarytree.mutable

object BinarySearchTree {

  /*
    search(node, key)

    1. if(node == NULL) return NULL

    2. if(key == node.key) return node.value

    3. if(key > node.key) return search(node.right, key)

    4. else return search(node.left, key)

   */

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

  /*
    delete(node, key)

    1. if(node == NULL) return NULL

    2. if(key == node.key)
      2.1 if(node.left == NULL and node.right == NULL) // node has no children
            return NULL
      2.2 if(node.left == NULL) // only right child is present
            return node.right
      2.3 if(node.left == NULL) // only left child is present
            return node.left



    3. if(key > node.key)
        delete(node.right, key, value)
    4. else
        delete(node.left, key, value)

   */

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

}
