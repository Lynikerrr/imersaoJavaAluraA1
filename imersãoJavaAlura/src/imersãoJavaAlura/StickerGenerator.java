package imersãoJavaAlura;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class StickerGenerator {

	public void criar(InputStream inputStream, String nomeArquivo) throws Exception {

		//InputStream inputStream = new URL(
			//	"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_4.jpg").openStream();
		BufferedImage imgOriginal1 = ImageIO.read(inputStream);

		int altura = imgOriginal1.getHeight();
		int largura = imgOriginal1.getWidth();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imgOriginal1, 0, 0, null);

		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setColor(Color.ORANGE);
		graphics.setFont(fonte);

		graphics.drawString("Filme Top!", 400, novaAltura - 100);

		ImageIO.write(novaImagem, "png", new File("Saida/nomeArquivo.png"));

	}

	
		
	

		

	
}
