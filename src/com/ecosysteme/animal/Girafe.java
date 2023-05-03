package com.ecosysteme.animal;

import com.ecosysteme.Espece;
import com.ecosysteme.Herbivore;

import java.awt.*;

public class Girafe extends Herbivore {
    public Girafe(Color c,int nombre) {
        super(c,nombre);
    }
    public void positionGrille(int cellX,int cellY,Graphics g, Espece espece){
        g.setColor(espece.getCouleur());
        g.fillOval(cellX +20, cellY+30 , espece.getNombre(), espece.getNombre());
    }
}