/*
 *   (C) Copyright 2008-2012 hSenid Mobile Solutions (Pvt) Limited.
 *   All Rights Reserved.
 *
 *   These materials are unpublished, proprietary, confidential source code of
 *   hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
 *   of hSenid Mobile Solutions (Pvt) Limited.
 *
 *   hSenid Mobile Solutions (Pvt) Limited retains all title to and doubleellectual
 *   property rights in these materials.
 *
 */
package wolverine.blog.sample.util;

import java.io.Serializable;

public class Point implements Serializable {

    private double x;
    private double y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static class Builder {
        double x = 0;
        double y = 0;

        public Builder withX(double x){
            this.x = x;
            return this;
        }

        public Builder withY(double y) {
            this.y = y;
            return this;
        }

        public Point build(){
            return new Point(x,y);
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}