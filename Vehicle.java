/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class Vehicle {

    private String id;
    private String name;
    double price;
    private int quantity;

    public Vehicle() {
    }

    public Vehicle(String id, String name, double price, int quantity) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setQuantity(quantity);
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        boolean checkValid = true;
        if (id.length() != 7) {
            checkValid = false;
        }
        if (id.isEmpty()) {
            checkValid = false;
        } else {
            if (!(id.startsWith("V")||id.startsWith("v"))) {
                checkValid = false;
            }
            for (int i = 1; i < id.length(); i++) {
                if (!Character.isDigit(id.charAt(i))) {

                    checkValid = false;
                }

            }
        }
        if (checkValid) {
            this.id = id;
        } else {
            this.id = "V000000";
        }
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        boolean checkValid = true;
        if (name.isEmpty()) {
            checkValid = false;
        } else {
            if (name.length() < 5 || name.length() > 50) {
                checkValid = false;
            }
        }
        if (checkValid) {
            this.name = name;
        } else {
            this.name = "new vehicle";
        }

    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        boolean checkValid = true;
        if (price < 1 || price > 1000000) {
            checkValid = false;
        }

        if (checkValid) {
            this.price = price;
        } else {
            this.price = 1;
        }

    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {
        boolean checkValid = true;
        if (quantity < 1 || quantity > 1000) {
            checkValid = false;
        }

        if (checkValid) {
            this.quantity = quantity;
        } else {
            this.quantity = 1;
        }

    }

    public double getSubTotal() {

        return this.getPrice() * this.getQuantity();
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + String.format("%.2f", price) + ", " + quantity + ", " + String.format("%.2f", getSubTotal());
    }

    public String toTitleCase(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) == ' ') {
                result += (s.charAt(i) + " ").toUpperCase();
            } else {
                result += (s.charAt(i) + " ").toLowerCase();
            }
        }
        result = result.trim();
        while (result.indexOf("  ") > -1) {
            result = result.replace("  ", " ");

        }
        return result;
    }

    public String toTitleCase2(String s) {
        String[] array = s.split(" ");
        for (int i = 0; i < array.length; i++) {
            String word = array[i];
            if (!word.isEmpty()) {
                word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            }
            array[i] = word;
        }
        return String.join(" ", array);
    }
}
