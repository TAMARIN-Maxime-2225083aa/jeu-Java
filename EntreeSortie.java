import java.util.Scanner;

public class EntreeSortie {
    
    public void titre() // affichage du titre
    {
        System.out.println();
        System.out.println("|====================================|");
        System.out.println("|=====| Bienvenue sur Java RPG |=====|");
        System.out.println("|====================================|");
        System.out.println();
    }

    public int menuPrincipal(Scanner sc) // affichage menu principal + choix utilisateur
    {
        System.out.println();
        System.out.println("======| Menu Principal |======");
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("|-----|   JOUER : 1   |-----|");
        System.out.println("|-----| PARAMETRE : 2 |-----|");
        System.out.println("|-----|   CREDIT : 3  |-----|");
        System.out.println("|-----|  QUITTER : 4  |-----|");
        System.out.println("-----------------------------");
        System.out.println();
        System.out.print("-> ");
        int choixMenuPrincipal = sc.nextInt();
        System.out.println();
        return choixMenuPrincipal;
        
    }

    public void InitalisationPartie(Scanner sc) {

        System.out.println();
        System.out.println("======| Partie |======");
        System.out.println();
        System.out.print("Votre speudo: ");
        String pseudoJoueur = sc.next();
        System.out.println();
        System.out.println(pseudoJoueur);
        
    }
}