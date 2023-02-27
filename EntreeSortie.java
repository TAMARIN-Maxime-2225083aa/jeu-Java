import java.util.Scanner;

public class EntreeSortie {
    
    public void titre() // affichage du titre
    {
        System.out.println("\n|====================================|\n"+
                           "|=====| Bienvenue sur Java RPG |=====|\n"+
                           "|====================================|\n\n");
    }

    public int menuPrincipal(Scanner sc) // affichage menu principal + choix utilisateur
    {
        System.out.println();
        System.out.println( "======| Menu Principal |======\n\n"+
                            "-----------------------------\n"+
                            "|-----|   JOUER : 1   |-----|\n"+
                            "|-----| PARAMETRE : 2 |-----|\n"+
                            "|-----|   CREDIT : 3  |-----|\n"+
                            "|-----|  QUITTER : 4  |-----|\n"+
                            "-----------------------------\n\n");
        System.out.print("-> ");
        int choixMenuPrincipal = sc.nextInt();
        System.out.println();
        return choixMenuPrincipal;
    }

    public void entreePourPasser(Scanner sc) { // procedure qui met en place la fonctionnalité appuyer sur entrée pour aller à la suite
        System.out.println("\nAppuyer sur Entree pour continuer");
        sc.nextLine(); // Entree bloquant jusqu'à ce que l'on saute de ligne.
    }

    public void choixIncorrect(Scanner sc) {
        System.out.println( "==| Choix non correct |=="+
                            "\nAppuyer sur Entree pour refaire un choix");
        sc.nextLine(); // Entree bloquant jusqu'à ce que l'on saute de ligne.
    } 

    public String InitalisationPartie(Scanner sc) {

        System.out.println();
        System.out.println("======| Partie |======\n");
        System.out.print("Votre speudo: ");
        String pseudoJoueur = sc.next(); // pseudo du joueur
        return pseudoJoueur;
    }

    public void introduction(String pseudoJoueur, Scanner sc) {
        System.out.println("\n"+
                           "-------------------------------------------------------------------------------------------------------------------\n"+
                           "| Bonjour "+pseudoJoueur+", Bienvenue sur java RPG.                                                                \n"+
                           "| Votre Objectif sera de réunir toutes les armes et artefacts disponible tout en tuant tout les monstres du jeux.  \n"+
                           "|                                                                                                                  \n"+
                           "| bonne chance !                                                                                                   \n"+
                           "-------------------------------------------------------------------------------------------------------------------\n");
        sc.nextLine(); // Entree texte à vide (non prise en compte car celui ci prend la saisi du pseudo du joueur)
        entreePourPasser(sc);
    }
    public char choixDirectionPossible(String directionPossible, Scanner sc) { // possibilité determiné grace au code DGHB
        System.out.println("\nVoici vos possibilités de déplacement:\n");
        if (directionPossible.charAt(0) == 'D') { // .charAt(int indice) permet de récuperer le caractère d'un String
            System.out.println("\t- Droite");
        }
        if (directionPossible.charAt(1) == 'G') {
            System.out.println("\t- Gauche");
        }
        if (directionPossible.charAt(2) == 'H') {
            System.out.println("\t- Haut");
        }
        if (directionPossible.charAt(3) == 'B') {
            System.out.println("\t- Bas");
        }
        char direction = '0'; // code 0 correspond à ne bouge pas
        boolean choixDirectionNonPris = true;
        while (choixDirectionNonPris) 
        {
            System.out.print("\nvotre choix = initiale de la direction (D/G/H/B):\n\n-> ");
            direction = sc.next().charAt(0);
            // première verification si la saisie prend la valeur D,G,H ou B
            if (direction == 'D' || direction == 'G' || direction == 'H' || direction == 'B') {
                // deuxième verification si la saisie correspond à un choix possible
                if (directionPossible.charAt(0) == direction || directionPossible.charAt(1) == direction || directionPossible.charAt(2) == direction || directionPossible.charAt(3) == direction) {
                    choixDirectionNonPris = false;
                    return direction;   
                }
                else {
                    choixIncorrect(sc); // si second teste passe pas
                }
            }
            else {
                choixIncorrect(sc); // si premier teste passe pas
            }
        }
    return direction;
    }

    public int menuEnPartie(Scanner sc) {
        System.out.println();
        System.out.println( "------| MENU EN JEUX |-------\n\n"+
                            "----------------------------|\n"+
                            "|-----< continuer : 1 >-----|\n"+
                            "|-----<  quitter : 2  >-----|\n"+
                            "-----------------------------\n\n");
        System.out.print("-> ");
        int choixMenuEnPartie = sc.nextInt();
        System.out.println();
        return choixMenuEnPartie;
    }

    public void interactionCoffre(Coffre coffre,Scanner sc) {
        System.out.println();
        System.out.println("------------------------------------------------------------\n"+
                           "Vous êtes sur une case coffre, voici son contenu:\n\n");
        System.out.println("arme(s) dans le coffre:\n");
        coffre.armesDansCoffre();
        System.out.println("\nartefact(s) dans le coffre:\n");
        coffre.artefactDansCoffre();
        System.out.println("------------------------------------------------------------");
        sc.nextLine();
        this.entreePourPasser(sc);
    }

    public int menuInteractionCoffre(Scanner sc) {
        System.out.println();
        System.out.println( "------------| MENU COFFRE |------------\n\n"+
                            "--------------------------------------|\n"+
                            "|-----<   prendre arme(s) : 1   >-----|\n"+
                            "|-----< prendre artefact(s) : 2 >-----|\n"+
                            "|-----<   ne rien prendre : 3   >-----|\n"+
                            "---------------------------------------\n\n");
        System.out.print("-> ");
        int choixMenuCoffre = sc.nextInt();
        System.out.println();
        return choixMenuCoffre;
    }

}