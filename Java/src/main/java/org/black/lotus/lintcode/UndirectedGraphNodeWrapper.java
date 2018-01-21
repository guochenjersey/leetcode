package org.black.lotus.lintcode;

class UndirectedGraphNodeWrapper {

  private UndirectedGraphNode undirectedGraphNode;

  public UndirectedGraphNodeWrapper(UndirectedGraphNode undirectedGraphNode) {
    this.undirectedGraphNode = undirectedGraphNode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UndirectedGraphNodeWrapper that = (UndirectedGraphNodeWrapper) o;

    return this.undirectedGraphNode.label == that.undirectedGraphNode.label
        && this.undirectedGraphNode.neighbors.equals(that.undirectedGraphNode.neighbors);

  }

  @Override
  public int hashCode() {
    return this.undirectedGraphNode.label;
  }
}
