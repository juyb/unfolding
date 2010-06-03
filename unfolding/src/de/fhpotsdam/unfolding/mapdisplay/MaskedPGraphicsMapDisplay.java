package de.fhpotsdam.unfolding.mapdisplay;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;


public class MaskedPGraphicsMapDisplay extends ProcessingMapDisplay implements PConstants {

	protected PGraphics pg;

	public MaskedPGraphicsMapDisplay(PApplet papplet, AbstractMapProvider provider,
			float offsetX, float offsetY, float width, float height) {
		super(papplet, provider, offsetX, offsetY, width, height);

		pg = papplet.createGraphics((int) width, (int) height, P3D);
	}

	protected PGraphics getPG() {
		pg.beginDraw();
		return pg;
	}

	protected void postDraw() {
		pg.endDraw();

		papplet.pushMatrix();
		papplet.translate(offsetX, offsetY);
		papplet.image(pg, 0, 0);
		papplet.popMatrix();
	}

}