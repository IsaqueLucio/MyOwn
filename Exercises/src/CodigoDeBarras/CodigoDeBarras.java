import java.util.Arrays;
import java.util.Scanner;

public class CodigoDeBarras {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("=======================================                  MENU                     ====================================="+"\n");
        System.out.println("Choice betwen one of the two options below: "+"\n");
        System.out.println("1°Option: Receive a 13-digit code(EAN-13) and determine if it is " +
                "valid by verifying that the control digit is correct. Input "+1+" for use.");
        System.out.println("2°Option: Receive the first 12 digits and calculate the correct 13th control digit to form a complete and valid code.(EAN-13) Input "+2+" for use.");
        int option = input.nextInt();

        switch(option) {
            case 1:
                int impar = 0;
                int par = 0;
                int digitoVer;
                int finalNum;
                String codigo;
                int vetEAN[] = new int[13];

                System.out.println("Input the EAN-13 code: ");
                codigo= input.next();

                while (codigo.length() != 13) {
                    System.out.println("Please, input exactly 13 numbers in the code: ");
                    codigo = input.next();
                }
                char numVer = codigo.charAt(12);
                vetEAN[12] = Character.getNumericValue(numVer);
                for (int i = 0; i < 12; i++) {
                    char numEAN = codigo.charAt(i);
                    vetEAN[i] = Character.getNumericValue(numEAN);
                    if (i % 2 != 0) {
                        impar = impar + vetEAN[i];
                    } else if (i % 2 == 0) {
                        par = par + vetEAN[i];
                    }
                }
                finalNum = par + (impar * 3);
                if (finalNum % 10 == 0) {
                    digitoVer = 0;
                } else {
                    digitoVer = 10 - (finalNum % 10);
                }

                if (digitoVer==vetEAN[12]){
                    System.out.println("The code is valid!");
                } else {
                    System.out.println("The code is not valid!");
                }
                break;

            case 2:
                int impar2 = 0;
                int par2 = 0;
                int digitoVer2;
                int finalNum2;
                String codigo2;
                int vetEAN2[] = new int[12];

            System.out.println("Input the code with 12 numbers: ");
            codigo2 = input.next();

            while (codigo2.length() != 12) {
                System.out.println("Please, input exactly 12 numbers in the code: ");
                codigo2 = input.next();
            }
            for (int i = 0; i < 12; i++) {
                char numEAN = codigo2.charAt(i);
                vetEAN2[i] = Character.getNumericValue(numEAN);
                if (i % 2 != 0) {
                    impar2 = impar2 + vetEAN2[i];
                } else if (i % 2 == 0) {
                    par2 = par2 + vetEAN2[i];
                }
            }
            finalNum2 = par2 + (impar2 * 3);
            if (finalNum2 % 10 == 0) {
                digitoVer2 = 0;
            } else {
                digitoVer2 = 10 - (finalNum2 % 10);
            }
            System.out.println("The check digit is "+digitoVer2+" so the valid e complete EAN-13 code is "+codigo2+digitoVer2);
          break;
        }
    }
}
