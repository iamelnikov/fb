package com.ee.fb.repository;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.repository.CrudRepository;

import com.ee.domain.delivery.Route;
import com.ee.domain.delivery.RouteStopPoint;

public interface RouteStopPointRepository extends
		CrudRepository<RouteStopPoint, String> {

	public List<RouteStopPoint> findByRoute(Route route);
	
	public List<RouteStopPoint> findByRouteId(String routeId);
	
	public GeoResults<RouteStopPoint> findByAddressGeoLocation(Point point);

	public GeoResults<RouteStopPoint> findByAddressGeoLocation(Point point,
			Distance min, Distance max);
}
