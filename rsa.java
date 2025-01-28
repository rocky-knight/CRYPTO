import java.util.*;
import java.math.*;
import java.nio.charset.StandardCharsets;

public class rsa {
    public static void main(String[] args) {
        BigInteger p, q, N, phi, e, d;

        // Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Input p and q from the user
        System.out.println("Enter the value for prime number p:");
        p = new BigInteger(sc.nextLine());
        System.out.println("Enter the value for prime number q:");
        q = new BigInteger(sc.nextLine());

        // Calculate N and φ (phi)
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Generate public key (e)
        e = BigInteger.probablePrime(512, new Random());

        // Ensure e and phi are co-prime (gcd(e, phi) = 1) & 0 < e < phi
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }

        // Calculate private key (d)
        d = e.modInverse(phi);

        // Display keys
        System.out.println("\nPrime number p: " + p);
        System.out.println("Prime number q: " + q);
        System.out.println("Value of N (p * q): " + N);
        System.out.println("Value of φ (phi): " + phi);
        System.out.println("Public key (e): " + e);
        System.out.println("Private key (d): " + d);

        // Encrypt and decrypt a message
        System.out.print("\nEnter the plain text: ");
        String plainText = sc.nextLine();
        System.out.println("Encrypting String: " + plainText);

        // Encrypt each character of the string
        List<BigInteger> encryptedChars = new ArrayList<>();
        for (char c : plainText.toCharArray()) {
            encryptedChars.add(BigInteger.valueOf(c).modPow(e, N));
        }

        // Decrypt each character back to plain text
        StringBuilder decryptedText = new StringBuilder();
        for (BigInteger encryptedChar : encryptedChars) {
            decryptedText.append((char) encryptedChar.modPow(d, N).intValue());
        }

        // Display encrypted and decrypted results
        System.out.print("Encrypted Bytes: ");
        for (BigInteger encryptedChar : encryptedChars) {
            System.out.print(encryptedChar + " ");
        }
        System.out.println();

        System.out.println("Decrypted String: " + decryptedText.toString());
    }
}
<<<<<<< HEAD
=======
/*output
Prime number p: 158585821695280019444624260944752903207438494463073269677823503976014530556037406143491491234974843826503492253071310022193836395349373554956938565313365997035857103912846891072966672818673091476350419256010960982422199731088253777873939408562379001937274864012229265798321412448211908947429197311712832913137
Prime number q: 115093934836796129958656982226662629286633664637698213737377755417643007714718682812944405195745535707629829810786781599733521269591411952338847209738982175058435519967086310064876636279797010072622104174288597173529508563902314234616588908399924576869991011135367447671578550306390239748566134128233547739079
Public key is: 12331369603500579199414429955330825383242104525394400839819784936675013661305022446067259596636403660240823474380677203959858451708633516237347559422494061
Private key is: 9174699399196875263705200904182394442578442258538376103083580598206385803064062844987303187092183563851576532892432691130669083898183718222241580044622907302447101982078564975616881455192293545077271716837791432534157522686494074037223163620729163317205190423465236379643986339478783999004863636618389852221809971369400782361854927180933551592859488585747406171469984694211410780660389758036072385361350122496277189850930701626349094321065720795278994656037851468036462054224948779569966727239274764465702288999218302453010471791829734968702499536953268534513336332163822679200451779417106627877984191270056175204133
Enter the plain text: dsde
Encrypting String: dsde
Encrypted Bytes: 113-2250-742193-98-144-117-8935-105-738-74-128122-105-94-3310248-104-86-9534823-7124-7988-88-179-109119-102105-109-39-117102-72-18-2393367-4398-30124108-103-77-89109-21103271727447458-8079121-8113-447435-86-91-2733123-6591-657565551253828-12593-118-52621121-9356977984119-725261-105-2835-51827-3-8518-48311113871-6246-7Enter the plain text: dsde
Encrypting String: dsde
Encrypted Bytes: 113-2250-742193-98-144-117-8935-105-738-74-128122-105-94-3310248-104-86-9534823-7124-7988-88-179-109119-102105-109-39-117102-72-18-2393367-4398-30124108-103-77-89109-21103271727447458-8079121-8113-447435-86-91-2733123-6591-657565551253828-12593-118-52621121-9356977984119-725261-105-2835-51827-3-8518-48311113871-6246-74-86-9534823-7124-7988-88-179-109119-102105-109-39-117102-72-18-2393367-4398-30124108-103-77-89109-21103271727447458-8079121-8113-447435-86-91-2733123-6591-657565551253828-12593-118-52621121-9356977984119-725261-105-2835-51827-3-8518-48311113871-6246-78-103-77-89109-21103271727447458-8079121-8113-447435-86-91-2733123-6591-657565551253828-12593-118-52621121-9356977984119-725261-105-2835-51827-3-8518-48311113871-6246-7828-12593-118-52621121-9356977984119-725261-105-2835-51827-3-8518-48311113871-6246-782196421-1284929-56-507110456-10947-107-1217712383114-8442-40-88-3419-621358-51-41124-348-73619-127-34-8146114-50101-121838764-1711-84-90171131108753-26-23-11-5351-10622124103-7453-60-113-43-3869-17-971032910551-39-119126-128-584350-738-1215969-86-1101146568-5919107-104-421-84-34-78-6237374127-7234-119-9918101491068258-1093161-45-366761-3-1210125-106-93
Decrypted Bytes: 100115100101
Decrypted String: dsde*/

                                ( OR )
import java.util.*;
import java.math.*;
import java.nio.charset.StandardCharsets;

public class rsa {
    public static void main(String[] args) {
        BigInteger p, q, N, phi, e, d;

        // Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Input p and q from the user
        System.out.println("Enter the value for prime number p:");
        p = new BigInteger(sc.nextLine());
        System.out.println("Enter the value for prime number q:");
        q = new BigInteger(sc.nextLine());

        // Calculate N and φ (phi)
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Generate public key (e)
        e = BigInteger.probablePrime(512, new Random());

        // Ensure e and phi are co-prime (gcd(e, phi) = 1) & 0 < e < phi
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }

        // Calculate private key (d)
        d = e.modInverse(phi);

        // Display keys
        System.out.println("\nPrime number p: " + p);
        System.out.println("Prime number q: " + q);
        System.out.println("Value of N (p * q): " + N);
        System.out.println("Value of φ (phi): " + phi);
        System.out.println("Public key (e): " + e);
        System.out.println("Private key (d): " + d);

        // Encrypt and decrypt a message
        System.out.print("\nEnter the plain text: ");
        String plainText = sc.nextLine();
        System.out.println("Encrypting String: " + plainText);

        // Encrypt each character of the string
        List<BigInteger> encryptedChars = new ArrayList<>();
        for (char c : plainText.toCharArray()) {
            encryptedChars.add(BigInteger.valueOf(c).modPow(e, N));
        }

        // Decrypt each character back to plain text
        StringBuilder decryptedText = new StringBuilder();
        for (BigInteger encryptedChar : encryptedChars) {
            decryptedText.append((char) encryptedChar.modPow(d, N).intValue());
        }

        // Display encrypted and decrypted results
        System.out.print("Encrypted Bytes: ");
        for (BigInteger encryptedChar : encryptedChars) {
            System.out.print(encryptedChar + " ");
        }
        System.out.println();

        System.out.println("Decrypted String: " + decryptedText.toString());
    }
}
Enter the value for prime number p:
13
Enter the value for prime number q:
19
Enter the plain text:
hihi
Prime number p: 13
Prime number q: 19
Value of N (p * q): 247
Value of φ (phi): 216
Public key (e): 5
Private key (d): 173

Encrypting String: hihi
Encrypted Bytes: 104 0 104 0 
Decrypted String: hihi
>>>>>>> 8fd03a31442349f3c85c76b4453f99deafe7c103
