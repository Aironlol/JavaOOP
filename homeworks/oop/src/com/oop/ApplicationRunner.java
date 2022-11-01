package com.oop;

import java.io.PrintWriter;
import java.util.*;

public class ApplicationRunner {

    public static void main(String[] args) {
        try {
            var initialCollection = PrincessStorage.getAllPrincess();
            if (!initialCollection.isEmpty()) {
                System.out.println("Start typing commands:");
            } else {
                return;
            }
            PrincessesCollections princessesCollections = new PrincessesCollections(initialCollection);
            consolePrincessCollectionController consolePrincessCollectionController = new consolePrincessCollectionController(princessesCollections, new Scanner(System.in), new PrintWriter(System.out));
            consolePrincessCollectionController.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
