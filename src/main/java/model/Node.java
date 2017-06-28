package model;

import java.util.*;

public class Node implements Comparable<Node> {

    private Integer data;

    private Node root;

    private Node left;

    private Node right;

    private int level;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Node> getChildren() {
        List<Node> children = new ArrayList<>();
        if (this.left != null) {
            children.add(this.left);
        }
        if (this.right != null) {
            children.add(this.right);
        }
        return children;
    }

    public List<Node> getAllNodes(Node node) {
        List<Node> nodes = new ArrayList<>();
        if (node != null) {
            nodes.add(node);
            for (int i = 0; i < nodes.size(); ++i) {
                Node n = nodes.get(i);
                List<Node> children = n.getChildren();
                if (children != null) {
                    for (Node child : children) {
                        if (!nodes.contains(child)) {
                            nodes.add(child);
                        }
                    }
                }
            }
        }
        return nodes;
    }

    public List<Node> getAllNodesWithLevels(Node node) {
        List<Node> nodes = new ArrayList<>();
        int deepCounter = 0;
        if (node != null) {
            nodes.add(node);
            for (int i = 0; i < nodes.size(); ++i) {
                Node currentNode = nodes.get(i);
                if (i > 0 && i < nodes.size() - 1) {
                    Node nextNode = nodes.get(i + 1);
                    if (currentNode.getRoot().equals(nextNode.getRoot())) {
                        deepCounter++;
                    }
                } else if (i != 0) {
                    deepCounter++;
                }
                List<Node> children = currentNode.getChildren();
                if (children != null && !children.isEmpty()) {
                    for (Node child : children) {
                        if (!nodes.contains(child)) {
                            child.setLevel(deepCounter);
                            nodes.add(child);
                        }
                    }
                }
            }
        }
        return nodes;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.getData() == null ? 0 : this.getData(),
                node.getData() == null ? 0 : node.getData());
    }

}