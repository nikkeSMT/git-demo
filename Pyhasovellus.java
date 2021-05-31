package N1k0;

import java.util.Scanner;

public class Pyh‰sovellus {
	public static boolean karkausvuosi(int vuosi) {	// Laskukaava jolla selvitet‰‰n onko kyseinen vuosi karkausvuosi
		
		boolean karkausvuosi;

		karkausvuosi = !(vuosi % 4 != 0 || (vuosi % 100 == 0 && vuosi % 400 != 0));

		return karkausvuosi;

	}
	static void P‰‰si‰inen(int vuosi) { // Koodi joka laskee p‰‰si‰isen ajankohdan k‰ytt‰j‰n antamalla vuodella.
		
		float A, B, C, P, Q, M, N, D, E;	// Carl Friedrich Gaussin kehitt‰m‰ algoritmi 1800-luvulla joka laskee p‰‰si‰isen mille tahansa vuodelle.
										
		A = vuosi % 19; //Laskee ensin vuoden Y ajakohdan Metonic-sykliss‰.
		B = vuosi % 4;	//Etsii karkausp‰ivien m‰‰r‰n Julianuksen kalenterin mukaan.
		C = vuosi % 7;	//Otetaan huomioon ett‰ karkausvuodessa on yksi p‰iv‰ lis‰‰ 52 viikon p‰‰lle.
		P = (float) Math.floor(vuosi / 100);	//M riippuu vuoden Y vuosisadasta. 1800-luvulla M = 23. 2000-luvulla M = 24 ja niin edelleen. Se lasketaan seuraavien suhteiden avulla (P, Q, M)
		Q = (float) Math.floor((13 + 8 * P) / 25);	
		M = (15 - Q + P - P / 4) % 30;
		N = (4 + P - P / 4) % 7;	//Julianuksen ja gregoriaanisen kalenterin v‰listen karkausp‰ivien v‰linen ero.
		D = (19 * A + M) % 30;	//P‰iv‰m‰‰r‰t, jotka lis‰t‰‰n 21. maaliskuuta Paschalin t‰yskuun p‰iv‰m‰‰r‰n lˆyt‰miseksi. 
		E = (2 * B + 4 * C + 6 * D + N) % 7;	//P‰ivien lukum‰‰r‰ Paschalin t‰yskuusta seuraavaan sunnuntaihin.
		int days = (int) (22 + D + E);

		if ((D == 29) && (E == 6)) { // D- ja E-arvoja k‰ytett‰ess‰ p‰‰si‰issunnuntai tulee olemaan maaliskuu (22 + D + E). Jos t‰m‰ luku on suurempi kuin 31, siirrymme huhtikuuhun.
			System.out.println("19 huhtikuuta");
			return;
		}

		else if ((D == 28) && (E == 6)) {	// D- ja E-arvoja k‰ytett‰ess‰ p‰‰si‰issunnuntai tulee olemaan maaliskuu (22 + D + E). Jos t‰m‰ luku on suurempi kuin 31, siirrymme huhtikuuhun.
			System.out.println("18 huhtikuuta");
			return;
		} else {

			if (days > 31) {	// D- ja E-arvoja k‰ytett‰ess‰ p‰‰si‰issunnuntai tulee olemaan maaliskuu (22 + D + E). Jos t‰m‰ luku on suurempi kuin 31, siirrymme huhtikuuhun.
				System.out.println("P‰‰si‰inen on " + (days - 31) + " huhtikuuta");
				System.out.println("Pitk‰perjantai on " + (days - 33) + " huhtikuuta");
				
				return;
			}

			else {	// D- ja E-arvoja k‰ytett‰ess‰ p‰‰si‰issunnuntai tulee olemaan maaliskuu (22 + D + E). Jos t‰m‰ luku on suurempi kuin 31, siirrymme huhtikuuhun.
				System.out.println("\nP‰‰si‰inen on " + days + " maaliskuuta");
				System.out.println("Pitk‰perjantai on " + (days - 2) + " maaliskuuta");
				
				return;
			}
		}
	}

	public static void main(String[] args) 	// P‰‰koodi

	{
		Scanner lukija = new Scanner(System.in); // Luo lukija nimisen scannerin
		
		System.out.print("Hei, mik‰ on nimesi?: "); // Kysyy k‰ytt‰j‰n nimen
		String nimi = lukija.nextLine();
		
		System.out.print("\nHei "+nimi+"!"+"\nAnna vuosiluku: "); // Kysyy k‰ytt‰j‰lt‰ vuosiluvun
		int vuosi = lukija.nextInt();
		
		lukija.close(); // Sulkee lukija nimisen scannerin

		if (karkausvuosi(vuosi)) {	// Tulostaa annetun vuosiluvun perusteella onko annettu vuosi karkausvuosi

			System.out.println(vuosi +" on karkausvuosi");
		} else {
			System.out.println(vuosi +" ei ole karkausvuosi");
		}
		P‰‰si‰inen(vuosi); // Tulostaa p‰‰si‰isen tiedot

		System.out.println("");
		
		//M‰‰ritet‰‰n taulukko ja sen attribuutit
		String[] taulukko = { "\n Juhlapyh‰t vuodelle " + vuosi + ":" + "\n\t1.1. Uudenvuodenp‰iv‰",

				"\n\t6.1. Loppiainen",

				"\n\t1.5. Vappu",

				"\n\tToukokuun 2. sunnuntai: ƒitienp‰iv‰",
				"\n\t"+"Helatorstai on 40 p‰iv‰‰ p‰‰si‰issunnuntaista",

				"\n\tKes‰kuun 20. ja 26. p‰iv‰n v‰linen lauantai: Juhannusp‰iv‰",

				"\n\t31.10. ñ 6.11. v‰lille osuva lauantai: Pyh‰inp‰iv‰",

				"\n\tMarraskuun 2. sunnuntai: Is‰np‰iv‰",

				"\n\t6.12. Itsen‰isyysp‰iv‰",

				"\n\t24. ñ 25.12. Jouluaatto ja ñp‰iv‰",

				"\n\t26.12. Tapaninp‰iv‰"
				+"\n\nLiputusp‰iv‰t vuodelle " + vuosi + ":" + " \n\t5.2. J.L. Runebergin p‰iv‰",
				"\n\t28.2. Kalevalan p‰iv‰, suomalaisen kulttuurin p‰iv‰",
				"\n\t19.3. Minna Canthin p‰iv‰, tasa-arvon p‰iv‰",
				"\n\t9.4. Mikael Agricolan p‰iv‰, Suomen kielen p‰iv‰", "\n\t27.4. Kansallinen veteraanip‰iv‰",
				"\n\t1.5. Vappu, suomalaisen tyˆn p‰iv‰", "\n\tƒitienp‰iv‰ toukokuun toinen sunnuntai",
				"\n\t9.5. Eurooppa-p‰iv‰", "\n\t12.5. J.V. Snellmanin p‰iv‰, Suomalaisuuden p‰iv‰",
				"\n\t4.6. Puolustusvoimain lippujuhlan p‰iv‰",
				"\n\tJuhannus, Suomen lipun p‰iv‰ kes‰kuun 20. ja 26. p‰iv‰n v‰linen lauantai",
				"\n\tKaatuneitten muistop‰iv‰ toukokuun kolmas sunnuntai",
				"\n\t6.7. Eino Leinon p‰iv‰, Runon ja suven p‰iv‰",
				"\n\t10.10. Aleksis Kiven p‰iv‰, Suomalaisen kirjallisuuden p‰iv‰", "\n\t24.10. YK:n p‰iv‰",
				"\n\t6.11. Ruotsalaisuuden p‰iv‰, Kustaa Aadolfin p‰iv‰", "\n\tIs‰np‰iv‰ marraskuun toinen sunnuntai",
				"\n\t20.11. Lapsen oikeuksien p‰iv‰", "\n\t6.12. Itsen‰isyysp‰iv‰",
				"\n\t8.12. Jean Sibeliuksen p‰iv‰, Suomalaisen musiikin p‰iv‰" };
		
		for (int i = 0; i < taulukko.length - 1; ++i) {	//Tulostetaan taulukko
			System.out.println(taulukko[i]);
		}
	}

} // Tekij‰t Niklas Tuominen ja Niko Salonen