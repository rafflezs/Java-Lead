import java.util.Scanner;
 public class AparelhoDeSom {
     private static Scanner scanner;
     private static final int minVol = 0, maxVol = 100;
     @SuppressWarnings("unused")
	private int volume;

     public AparelhoDeSom() {
         scanner = new Scanner(System.in);
     }

     @SuppressWarnings("unused")
	private void definirVolume() throws VolumeException {
    	 System.out.print("Digite o valor do volume: ");
         int volume = scanner.nextInt();
         if(volume < minVol || volume > maxVol)
        	 throw new VolumeException(volume);

         this.volume = volume;
     }
}