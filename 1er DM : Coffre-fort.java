import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Chrono {
	
	public static void main(String[] args) {
		Timer timer = new Timer("Printer");
		MyTask t = new MyTask();
		timer.schedule(t, 0, 1000);

	System.out.println("Bip, individu louche repéré, déclanchement de l'alarme dans 5 minutes !!!");
        System.out.println("	ETAPE 1- Choix de la difficulté : (taper un chiffre allant de 0 à 5)");
        System.out.println("    - MODE LIBRE : TAPER 0");
        System.out.println("    - MODE DEBUTANT : TAPER 1");
        System.out.println("    - MODE AMATEUR : TAPER 2");
        System.out.println("    - MODE SEMI-PRO : TAPER 3");
        System.out.println("    - MODE PRO : TAPER 4");
        System.out.println("    - MODE CHAMPION : TAPER 5");
        System.out.println("    - MODE ADMIN : TAPER UN CHIFFRE NEGATIF");
	Scanner keyb = new Scanner (System.in);
	int d = keyb.nextInt();
	int essais=0;
	while (d>6){
		System.out.println ("! Difficulté inexistante, veiillez resaisir une difficulté valide.");
		d = keyb.nextInt();
	}
	if (d<=-1){
		System.out.println("Vous jourez en mode TEST = aucune limite de propositions.");
		essais=9999999;
	}
	if (d==0){
		System.out.println("Vous jourez en PERSONALISE, veillez choisir la limite de propositions à appliquer.");
		essais = keyb.nextInt();
		System.out.println("Vous avez mis une limite de " +essais+" essais.");
	}
	if (d==1){
		System.out.println("Vous jourez en mode DEBUTANT = limite de propositions à 200.");
		essais=200;
	}
	if (d==2){
		System.out.println("Vous jourez en mode AMATEUR = limite de propositions à 150.");
		essais=150;
	}
	if (d==3){
		System.out.println("Vous jourez en mode SEMI-PRO = limite de propositions à 75.");
		essais=75;
	}
	if (d==4){
		System.out.println("Vous jourez en mode PRO = limite de propositions à 50.");
		essais=50;
	}
	if (d==5){
		System.out.println("Vous jourez en mode CHAMPION (niveau déconseillé) = limite de propositions à 30.");
		essais=30;
	}
	if (d==6){
		System.out.println("Vous jourez en mode LEGENDE (niveau déconseillé) = limite de propositions à 20.");
		essais=20;
	}
	System.out.println("	ETAPE 2- A vous de jouez !!!");
        int n = keyb.nextInt();
	System.out.println("Votre proposition est : "+n);
	Random random = new Random();
	int nb;
        essais--;
	nb = random.nextInt(101);
	int compteur = 1;
        if (nb!=n){
            System.out.println("Ce chiffre est incorrect.");
        }
	while (nb!=n){
		n = keyb.nextInt();
		System.out.println("Votre proposition est : "+n);
		compteur++;
		essais--;
		if (nb<n){
			System.out.println("Votre chiffre est trop grand !!!");
		}
                if (nb>n){
			System.out.println("Votre chiffre est trop petit !!!");
		}
	}
	System.out.println("			1er nombre trouvé : "+nb);
    int code_1 = nb;
	nb = random.nextInt(101);
	n = keyb.nextInt();
	System.out.println("Votre proposition est : "+n);
        if (nb!=n){
            System.out.println("Ce chiffre est incorrect.");
        }
	while (nb!=n){
		n = keyb.nextInt();
		System.out.println("Votre proposition est : "+n);
		compteur++;
		essais--;
		if (nb<n){
			System.out.println("Votre chiffre est trop grand !!!");
		}
                if (nb>n){
			System.out.println("Votre chiffre est trop petit !!!");
		}
	}
	System.out.println("			2ème nombre trouvé : "+nb);
    int code_2 = nb;
	nb = random.nextInt(101);
	n = keyb.nextInt();
	System.out.println("Votre proposition est : "+n);
        if (nb!=n){
            System.out.println("Ce chiffre est incorrect.");
        }
	while (nb!=n){
		n = keyb.nextInt();
		System.out.println("Votre proposition est : "+n);
		compteur++;
		essais--;
		if (nb<n){
			System.out.println("Votre chiffre est trop grand !!!");
		}
                if (nb>n){
			System.out.println("Votre chiffre est trop petit !!!");
		}
	}
	System.out.println("			3ème nombre trouvé : "+nb);
    int code_3 = nb;
    System.out.println("La solution a été trouvé au bout de : "+compteur+" tentavives !!!");
    if (essais>0){
    	System.out.println("Le code était : "+code_1+"-"+code_2+"-"+code_3);
    	System.out.println("OUVERTURE DU COFFRE-FORT !!!");
    	if (d>=0){
    		System.out.println("Il vous restai "+essais+" tentatives avant d'échoué.");	
    	}
    }
    if(essais<=0){
    	if(d>=0){
    		System.out.println("BIP, SECURITE DU COFFRE CAR CODE SAISIT HORS-DELAI !!!");
    	}
    }
System.exit(0);
	}
}


class MyTask extends TimerTask {
	private int times =300;
        @Override
        public void run() {
		times--;
		if (times > 0) {
			System.out.println("                                          SECONDES RESTANTES : "+times);
		} else {
            System.out.println("Vous avez perdu...");
            this.cancel();
		}
	}
}
