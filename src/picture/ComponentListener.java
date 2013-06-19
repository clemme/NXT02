package picture;

import java.awt.event.ComponentEvent;

import com.googlecode.javacv.CanvasFrame;

public class ComponentListener implements java.awt.event.ComponentListener{

	CanvasFrame a,b;
	public ComponentListener(CanvasFrame a, CanvasFrame b){
		this.a = a;
		this.b = b;
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		
		/* Stick Filter and Source CanvasFrames together */
		if(a.isFocused()){
			b.setLocation((int) a.getLocation().getX()+666, (int) (a.getLocation().getY()));
		} else {
			a.setLocation((int) b.getLocation().getX()-666, (int) b.getLocation().getY());
		}
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
