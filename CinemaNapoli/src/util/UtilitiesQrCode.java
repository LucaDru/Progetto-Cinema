package util;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class UtilitiesQrCode {
	public static boolean generateQRCodeImage(String testoDaInserire, int larghezza, int altezza, String pathDoveSalvare){
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix=null;
		try {
			bitMatrix = qrCodeWriter.encode(testoDaInserire, BarcodeFormat.QR_CODE, larghezza, altezza);
		} catch (WriterException e) {
			return false;
		}

        Path path = FileSystems.getDefault().getPath(pathDoveSalvare);
        //Path path=Paths.get("","");
        path=path.resolve(testoDaInserire+".PNG");
		try {
			MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		} catch (IOException e) {
			return false;
		}
        return true;
    }
}
