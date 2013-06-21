package picture;

import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FrameGrabber.Exception;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_core.*;

/*
 * Class to test the camera setup
 */
public class CameraSetupFeed {

	static OpenCVFrameGrabber grabber;
	static CanvasFrame canvas;
	static IplImage image;

	public static void main(String[] args) throws Exception {
		grabber = new OpenCVFrameGrabber(0);
		canvas  = new CanvasFrame("Camera Setup Feed");
		canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		new CameraSetupFeed();
	}

	public CameraSetupFeed() throws Exception {
		canvas.getCanvas().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PointerInfo a = MouseInfo.getPointerInfo();
				Point point = new Point(a.getLocation());
				SwingUtilities.convertPointFromScreen(point, arg0.getComponent());
				int mousex = (int) point.getX();
				int mousey = (int) point.getY();
				
				System.out.println("("+mousex+","+mousey+")");
			}
		});
		grabber.start();
		while(true) {
			try {
				image = grabber.grab();

				if (image != null) {
					canvas.showImage(image);
					cvSaveImage("image.jpg", image);
				}
			} catch (com.googlecode.javacv.FrameGrabber.Exception e) {
				e.printStackTrace();
			}
			//cvSetMouseCallback("canvas", CV_EVENT_LBUTTONUP, null);
		}
	}

	
	
}
