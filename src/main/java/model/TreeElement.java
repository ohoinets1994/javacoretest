package model;

import java.util.Collections;
import java.util.List;

import static data.Constants.TAB;


public class TreeElement {

    private final Node root;

    public TreeElement(Node root) {
        this.root = root;
    }

    public void printTree() {
        System.out.println("ID \t - \t LEVEL \t - \t CHILDREN");
        List<Node> nodes = this.root.getAllNodesWithLevels(this.root);
        Collections.sort(nodes);

        for (Node node : nodes) {
            if (node.getData() != null) {
                System.out.println(node.getData() + TAB + node.getLevel() + TAB + node.getChildren().size());
            }
        }

    }

}