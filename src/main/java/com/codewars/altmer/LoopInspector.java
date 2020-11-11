package com.codewars.altmer;

import java.util.HashSet;
import java.util.Set;

public class LoopInspector {
  public int loopSize(Node node) {
    if (node.getNext() == node) return 1;

    Set<Node> nodes = new HashSet<>();
    Node loopStart = node;
    boolean isAbsent;
    do {
      isAbsent = nodes.add(loopStart);
      loopStart = loopStart.getNext();
    } while (isAbsent);

    int tailSize = 0;
    Node tailNode = node;
    while (tailNode != loopStart) {
      tailNode = tailNode.getNext();
      tailSize++;
    }

    return nodes.size() - tailSize + 1;
  }
}

class Node {
  public Node getNext() {
    return new Node();
  }
}
