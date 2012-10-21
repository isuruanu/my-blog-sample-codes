/*
 *   (C) Copyright 2008-2012 hSenid Mobile Solutions (Pvt) Limited.
 *   All Rights Reserved.
 *
 *   These materials are unpublished, proprietary, confidential source code of
 *   hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
 *   of hSenid Mobile Solutions (Pvt) Limited.
 *
 *   hSenid Mobile Solutions (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 *
 */
package wolverine.blog.sample.singleton.hack;


import wolverine.blog.sample.util.Point;

public class BasicSingleton extends SomeClass{

    public static final BasicSingleton INSTANCE  = new BasicSingleton();

    private Point geoLocation;

    private BasicSingleton() {
        geoLocation = new Point.Builder().withX(80.43).withY(7.57).build();
    }

    public Point getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(Point geoLocation) {
        this.geoLocation = geoLocation;
    }
}