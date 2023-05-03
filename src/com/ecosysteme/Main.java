package com.ecosysteme;



public class Main {
    public static void main(String[] args) {
        int nbCasesL = 5, nbCasesH = 6;
        // On crée un terrain "Logique" objet ChampGraphique de 50 cases de large, et 60 de haut de 20 pixels de côté
        Terrain terrain = new Terrain(nbCasesL, nbCasesH, 170);
        
        int i, j;

        for (i = 0; i < nbCasesL; i++)
            for (j = 0; j < nbCasesH; j++) {
                if (i < j) terrain.colorieFond(i, j, TypeCase.foret);
                else terrain.colorieFond(i, j, TypeCase.plaine);
            }

        terrain.redessine();

        //Puis, pause de 2s
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (i = 0; i < nbCasesL; i++)
            for (j = 0; j < nbCasesH; j++) {

                // Place les différentes espèces au hasard selon des probabilités

                terrain.addEspece(i, j);

                //Puis, pause de 2s
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                terrain.redessine();
            }

        for (i = 0; i < nbCasesL; i++)
            for (j = 0; j < nbCasesH; j++) {

                // Place les différentes espèces au hasard selon des probabilités

                terrain.besoinEspece(i, j);

                //Puis, pause de 2s
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                terrain.redessine();


            }


    }
}
