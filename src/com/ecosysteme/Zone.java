package com.ecosysteme;


import java.awt.*;
import java.util.LinkedList;


public class Zone {
    private final float temperature;
    private float fourchette;
    public LinkedList<Espece> lEspeces;
    private TypeCase typeCase;
    private Color c;
    private EspeceFactory especeFactory;


    Zone(float temperature, float fourchette) {
        this.temperature = temperature;
        this.fourchette = fourchette;
        lEspeces = new LinkedList<Espece>();
    }

    public Color getCouleur() {
        return c;
    }

    public void setCouleur(Color c) {
        this.c = c;
    }

    public void setTypeCase(TypeCase typeCase) {
        this.typeCase = typeCase;
    }

    public void addEspece(EspeceDisponible especeDisponible,int nombre) {
        Espece espece = EspeceFactory.getInstance(especeDisponible,1);

        for (Espece e :lEspeces){
            if (e.getClass().equals(espece.getClass())){
                throw new RuntimeException("Création d'une nouvelle fois de l'instance de "+ especeDisponible+" dans une même zone");
            }
        }
        lEspeces.add(EspeceFactory.getInstance(especeDisponible,nombre));
    }
    public void ajouterDeplacementEspece(Espece espece){
        for (Espece e:lEspeces) {
            if (e.getClass().equals(espece.getClass())){
                e.setNombre(e.getNombre()+1);
                return;
            }
        }
        addEspece(Espece.getEspeceDisponible(espece),1);
    }

    public float getFourchette() {
        return fourchette;
    }

    public void setFourchette(float fourchette) {
        if (fourchette<0)
            throw new RuntimeException("Valeur de la fourchette négative");
        this.fourchette = fourchette;
    }
}