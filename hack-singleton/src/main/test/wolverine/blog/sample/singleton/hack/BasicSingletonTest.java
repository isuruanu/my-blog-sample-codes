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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import wolverine.blog.sample.util.Point;

import java.io.*;

import static org.testng.Assert.assertEquals;

public class BasicSingletonTest {

    @BeforeClass
    public void setUp() throws Exception {
    }

    @Test
    public void testSingleton() throws IOException, ClassNotFoundException {
        BasicSingleton instance = BasicSingleton.INSTANCE;
        assertEquals(instance.getGeoLocation().getX(), 80.43) ;
        assertEquals(instance.getGeoLocation().getY(), 7.57) ;

        FileOutputStream fileOutputStream = new FileOutputStream("serialized-objects", false);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

        oos.writeObject(instance);

        FileInputStream fileInputStream = new FileInputStream("serialized-objects");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        BasicSingleton singletonImpersonator1 = (BasicSingleton) ois.readObject();

        oos.close();
        oos.flush();
        ois.close();

        assertEquals(singletonImpersonator1.getGeoLocation().getX(), 80.43) ;
        assertEquals(singletonImpersonator1.getGeoLocation().getY(), 7.57) ;

        instance.setGeoLocation(new Point.Builder().withX(-98.73).withY(40.42).build());
        assertEquals(singletonImpersonator1.getGeoLocation().getX(), 80.43);
        assertEquals(instance.getGeoLocation().getX(), -98.73);
    }
}