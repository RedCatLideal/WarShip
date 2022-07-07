package ru.dadynsky.warship.model;

import java.util.ArrayList;

public class Ship {
    int height;
    int x;
    int y;
    int[][] pole;

    public Ship(int height,int[][] pole){
        this.pole = pole;
        this.height = height;
    }



    public void fat(ArrayList<Location> locations){
        for (Location loc:locations){
            int yy = loc.y - 1;
            int xx = loc.x - 1;
            for(int m = 0;m < 3;m++){

                for(int n = 0;n < 3;n++){
                    if (validator(xx,yy) == true){
                        pole[xx][yy] = 5;
                    }
                    xx++;
                }
                yy++;
                xx = xx-3;
            }
        }
    }

    public void putter(){
        x = (int) (Math.random() * 9);
        y = (int) (Math.random() * 9);
        int fun = (int)(Math.random() * 4);
        switch (fun){
            case 1: if (right() == false) putter(); break;
            case 2: if (left() == false) putter(); break;
            case 3: if (down() == false) putter(); break;
            default: if (up() == false) putter(); break;
        }
    }

    public boolean validator(int x,int y){
        if (x<0) return false;
        if (y<0) return false;
        if (x>9) return false;
        if (y>9) return false;
        if (pole[x][y] != 0) return false;

        return true;
    }

    public void setPole(int[][] pole) {
        this.pole = pole;
    }

    public boolean right() {
        ArrayList<Location> locations = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            if (validator(x,y) == false) {
                return false;
            }else{
                Location location = new Location();
                location.x = x;
                location.y = y;
                locations.add(location);
            }
            x = x + 1;
        }
        for (Location loc:locations){
            pole[loc.x][loc.y] = height;
        }
        fat(locations);
        return true;
    }

    public boolean left() {
        ArrayList<Location> locations = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            if (validator(x,y) == false) {
                return false;
            }else{
                Location location = new Location();
                location.x = x;
                location.y = y;
                locations.add(location);
            }
            x = x - 1;
        }
        for (Location loc:locations){
            pole[loc.x][loc.y] = height;
        }
        fat(locations);
        return true;
    }

    public boolean down() {
        ArrayList<Location> locations = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            if (validator(x,y) == false) {
                return false;
            }else{
                Location location = new Location();
                location.x = x;
                location.y = y;
                locations.add(location);
            }
            y = y + 1;
        }
        for (Location loc:locations){
            pole[loc.x][loc.y] = height;
        }
        fat(locations);
        return true;
    }

    public boolean up() {
        ArrayList<Location> locations = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            if (validator(x,y) == false) {
                return false;
            }else{
                Location location = new Location();
                location.x = x;
                location.y = y;
                locations.add(location);
            }
            y = y - 1;
        }
        for (Location loc:locations){
            pole[loc.x][loc.y] = height;
        }
        fat(locations);
        return true;
    }
}
