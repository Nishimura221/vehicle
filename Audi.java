/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class Audi extends Vehicle {

    private int releasedYear;
    private String color;

    public Audi() {
    }

    public Audi(String id, String name, double price, int quantity, String color, int releasedYear) {
        super(id, name, price, quantity);
        this.setReleasedYear(releasedYear);
        this.setColor(color);
    }

    @Override
    public double getSubTotal() {
        int x = 100;
        if (this.color.equals("Red") || this.releasedYear == 2025) {
            x = 120;

        }
        return super.getPrice() * super.getQuantity() * x/100;

    }

    public void setReleasedYear(int releasedYear) {
        boolean checkValid = true;
        if (releasedYear < 2022 || releasedYear > 2025) {
            checkValid = false;
        }
        if (checkValid) {
            this.releasedYear = releasedYear;
        } else {
            this.releasedYear = 2022;
        }
    }

    public void setColor(String color) {
        boolean checkValid =true;
        if(!(color.equals("Black")||color.equals("White")||color.equals("Red")||color.equals("Gray"))){
         checkValid=false;
        }
        if(checkValid){
         this.color = color;
        }
        else{
         this.color="Black";
        }
    }

    @Override
    public String toString() {
        return super.getId() + ", " + super.getName() + ", " + this.color + ", " + this.releasedYear + ", " + String.format("%.2f", super.getPrice()) + ", " + super.getQuantity()+", "+String.format("%.2f", getSubTotal());
    }

}
