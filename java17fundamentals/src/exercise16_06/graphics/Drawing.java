package exercise16_06.graphics;

import java.util.*;


@SuppressWarnings("rawtypes")
public class Drawing implements Drawable,Iterable {
	private class DrawableIterator implements Iterator {
		private int index = 0;

		public boolean hasNext() {
			for (int i = index; i < drawables.length; i++) {
				if (drawables[i] != null) {
				   index = i;
					return true;
				}
			}
			return false;
		}

		public Object next() {
			for (int i = index; i < drawables.length; i++) {
				if (drawables[i] != null) {
					index = i;
					break;
				}
			}
			if(index == drawables.length) {
				throw new NoSuchElementException("No more drawables");
			}
			return drawables[index++];
		}
	}
	private final int MAX = 100;

	private Drawable[] drawables = new Drawable[MAX];

	private int size = 0;


	public void add(Drawable d) {
		if (!present(d)) {
			int location = getFreeLocation();
			drawables[location] = d;
			size++;
		}
	}

	public void clear() {
		drawables = new Drawable[100];
		size = 0;
	}

   public void draw(DrawingContext dc) {
		for (int i = 0; i < drawables.length; i++) {
			if (drawables[i] != null) {
            drawables[i].draw(dc);
			}
		}
	}

	private int getFreeLocation() {
		for (int i = 0; i < drawables.length; i++) {
			if (drawables[i] == null)
				return i;
		}
		// Create new array
		Drawable[] temp = new Drawable[drawables.length + MAX];
		for (int i = 0; i < drawables.length; i++) {
			temp[i] = drawables[i];
		}
		int location = drawables.length;
		drawables = temp;

		return location;
	}

	public Iterator iterator() {
      return new DrawableIterator();
   }

	public int getSize() {
		return size;
	}

	/* Private methods */
	private boolean present(Drawable s) {
		for (int i = 0; i < drawables.length; i++) {
			if (s.equals(drawables[i]))
				return true;
		}
		return false;
	}

   public void remove(Drawable d) {
		for (int i = 0; i < drawables.length; i++) {
			if (d.equals(drawables[i])) {
				drawables[i] = null;
				size--;
				return;
			}
		}
	}
	
	public void scale(int factor) {
      if (factor < 0)
         throw new NegativeSizeException("Negative scale factor");
		for (int i = 0; i < drawables.length; i++) {
			if (drawables[i] != null) {
				drawables[i].scale(factor);
			}
		}
	}
}
