package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); // making Scanner with a File

		if (in.hasNextLine()) {
			String name = in.next();
			int r = in.nextInt();
			int g = in.nextInt();
			int b = in.nextInt();
			boolean filled = in.nextBoolean();
			StdDraw.setPenColor(r, g, b);
			if (name.equals("triangle")) {
				double x1 = in.nextDouble();
				double y1 = in.nextDouble();
				double x2 = in.nextDouble();
				double y2 = in.nextDouble();
				double x3 = in.nextDouble();
				double y3 = in.nextDouble();
				double[] xArray = { x1, x2, x3 };
				double[] yArray = { y1, y2, y3 };

				if (filled) {
					StdDraw.filledPolygon(xArray, yArray);
				} else {
					StdDraw.polygon(xArray, yArray);
				}
			}

				if (name.equals("rectangle")) {
					double x = in.nextDouble();
					double y = in.nextDouble();
					double halfWidth = in.nextDouble();
					double halfHeight = in.nextDouble();

					if (filled) {
						StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
					} else {
						StdDraw.rectangle(x, y, halfWidth, halfHeight);
					}
				}
			
		}
	}
}
