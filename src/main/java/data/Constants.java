package data;

import model.Node;
import model.TreeElement;

public interface Constants {

    String TAB = "\t - \t\t";

    static TreeElement getTreeElement() {
        Node rootNode = new Node();
        Node firstNode = new Node();
        Node secondNode = new Node();
        Node thirdNode = new Node();
        Node fourthNode = new Node();
        Node fifthNode = new Node();
        Node sixthNode = new Node();
        Node seventhNode = new Node();

        seventhNode.setData(7);
        seventhNode.setRoot(sixthNode);

        sixthNode.setData(6);
        sixthNode.setRoot(fifthNode);
        sixthNode.setLeft(seventhNode);

        fifthNode.setData(5);
        fifthNode.setRoot(fourthNode);

        fourthNode.setData(4);
        fourthNode.setLeft(fifthNode);
        fourthNode.setRoot(rootNode);

        thirdNode.setData(3);
        thirdNode.setRoot(firstNode);

        secondNode.setData(2);
        secondNode.setRoot(firstNode);
        secondNode.setLeft(sixthNode);

        firstNode.setData(1);
        firstNode.setLeft(secondNode);
        firstNode.setRight(thirdNode);
        firstNode.setRoot(rootNode);

        rootNode.setLeft(firstNode);
        rootNode.setRight(fourthNode);

        return new TreeElement(rootNode);
    }

}