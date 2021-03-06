package de.fhpotsdam.unfolding.examples.marker.multimarker;

import java.util.HashMap;
import java.util.List;

import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePolygonMarker;
import de.fhpotsdam.unfolding.utils.GeoUtils;

/**
 * Implements the getDistanceTo method by checking distances to each polygon vertex, and returns the minimum. Thus,
 * instead of using the centroid, the results are more like expected.
 * 
 * TODO Yet, as only existing vertices are used, it might happen that a vertex from another polygon is still closer as
 * to the nearest vertex of the actual nearest polygon
 */
public class DistancePerLocationPolygonMarker extends SimplePolygonMarker {

	public DistancePerLocationPolygonMarker() {
		super();
	}

	public DistancePerLocationPolygonMarker(List<Location> locations) {
		super(locations);
	}

	public DistancePerLocationPolygonMarker(List<Location> locations, HashMap<String, Object> properties) {
		super(locations, properties);
	}

	@Override
	public double getDistanceTo(Location location) {
		double minDistance = Double.MAX_VALUE;
		for (Location loc : locations) {
			double dist = GeoUtils.getDistance(location, loc);
			minDistance = dist < minDistance ? dist : minDistance;
		}
		return minDistance;
	}
}
