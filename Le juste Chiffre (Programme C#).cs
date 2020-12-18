using System;

namespace Le_Juste_Chiffre
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("JEU DE LA COMPANY GD : LE JUSTE CHIFFRE");//Phrase de présentation du jeu
            Console.WriteLine("Mode de jeu : 1- PROPIRETAIRE PC PC, 2- INVITE");
            int cass = Int32.Parse(Console.ReadLine());
            Console.Clear();
            switch (cass)
            {
                case 1:
                    Console.WriteLine("Salut, "+System.Environment.UserName);
                    break;
                default:
                    Console.ForegroundColor = ConsoleColor.Blue;
                    Console.Write("Veuillez saisir votre petit prénom : ");//demande le prénom à l'utilisateur
                    string saisiee = Console.ReadLine();
                    Console.WriteLine("Selem, " + saisiee);
                    break;
            }
            int i = 1;//Initialisation du compteur d'échecs
            int chiffre = new Random().Next(0, 100);//Séléction du chiffre par l'ordinateur
            Console.Write("Veillez saisir votre proposition de chiffre : ");
            string saisie = Console.ReadLine();//1ère proposition de nombre
            int nombre = Convert.ToInt32(saisie); // Conversion pour la vérification initiale du bon nombre
            while (nombre < 0)
            {
                Console.ForegroundColor = ConsoleColor.DarkGray;//Couleur pour l'erreur
                Console.WriteLine("ERREUR : CHIFFRE IMPOSSIBLE (car vous avez saisi un nombre négatif !!!)");
                Console.Write("Veillez saisir une proposition de chiffre correcte (>=0) : ");
                saisie = Console.ReadLine();//Nouvelle saisi du joueur
                nombre = Convert.ToInt32(saisie);//Conversion pour le fonctionnement normal du programme
            }
            while (chiffre != nombre)//Cas combinaison actuellement en échecs...
            {
                Console.ForegroundColor = ConsoleColor.DarkRed;
                Console.WriteLine("Chiffre malheureusement incorect,");
                if (chiffre > nombre){
                    Console.WriteLine("Le chiffre recherché est plus grand !!!");
                }
                else
                {
                    Console.WriteLine("Le chiffre recherché est plus petit !!!");
                }
                Console.Write("Veillez saisir votre nouvelle proposition de chiffre : ");
                saisie = Console.ReadLine();//Nouvelle saisi du joueur
                nombre = Convert.ToInt32(saisie);//Conversion pour le fonctionnement normal du programme
                while (nombre < 0)
                {
                    Console.ForegroundColor = ConsoleColor.DarkGray;//Couleur pour l'erreur
                    Console.WriteLine("ERREUR : CHIFFRE IMPOSSIBLE (car vous avez saisi un nombre négatif !!!)");
                    Console.Write("Veillez saisir une proposition de chiffre correcte (>=0) : ");
                    saisie = Console.ReadLine();//Nouvelle saisi du joueur
                    nombre = Convert.ToInt32(saisie);//Conversion pour le fonctionnement normal du programme
                }
                i++;//Incrémentation à + 1 du compteur
            }
            Console.Clear();
            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.WriteLine("Le chiffre trouvé était : "+chiffre);
            if (i < 2){//Cas où la combinaison à été trouvé en 1 seul coup !!!
                Console.WriteLine("Il vous a fallu exactement " + i + " tentative pour parvenir à la solution !!!");
                Console.WriteLine("En conséquence, voici TOUTES MES FELICAATIONS");
            }
            else {//Tous les cas où la combinaison à été trouvé en plusieurs coups
                Console.WriteLine("Il vous a fallu exactement " + i + " tentatives pour parvenir à la solution !!!");
            }
            Console.WriteLine(" ");
            Console.WriteLine("Fin du jeu conçu par G.DUMILLLIER, merci d'avoir joué avec nous, à une prochaine fois !!!");
            Console.WriteLine("Version 1.33 du jeu C# en date du 13/01/2020 à 10h16");
            //Fin du programme après la phrase de remerciment (ci-dessus)
        }
    }
}
