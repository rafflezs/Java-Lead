import java.io.*;
import javax.swing.JOptionPane;

public class GravarArquivo {

    public static void main(String[] args) {
        getHash();
    }

    public static String getHash() throws Exception {
        String input = "498691cea08b626c057f228108a5b3d7b9c74900fb03c7469ec03092dd0efd0b34fb558817286deb2269fc0368118115682698d5225175a86a04e1fcc36d76aa";
        MessageDigest md = MessageDigest.getInstance(SHA-512);
        byte[] out = md.digest(input.getBytes());
        return HexEncoder.toHex(out);
    }
}
