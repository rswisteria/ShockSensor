/**
 * 
 */
package jp.co.xtone.android.shocksensor;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

import jp.co.xtone.accel.Motion;
import jp.co.xtone.android.shocksensor.event.ShockEvent;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;

/**
 * @author w
 *
 */
public class ShockSensorTest implements ShockSensorListener {

    private ShockSensor sensor; 
    private ShockEvent e;
    private boolean isCalled;
    private boolean doubleCalled;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        sensor = new ShockSensor();
        sensor.addShockSensorListener(this);
        this.e = null;
        this.isCalled = false;
        this.doubleCalled = false;
    }

    /**
     * 衝突のポジティブデータを読み込み、それが衝突判定のイベントを発火するかどうかを確認する
     */
    @Test
    public void testInputPositive1() {
        List<Motion> motion1 = getMotions("shock_1");
        for (Motion m : motion1) {
            float[] accel = new float[3];
            accel[0] = (float) m.x;
            accel[1] = (float) m.y;
            accel[2] = (float) m.z;
            sensor.input(accel, m.time);
        }

        assertTrue("shock_1のモーションでイベントが発行されない", isCalled);
        assertFalse("shock_1のモーションで複数回のイベントが発行されている", doubleCalled);
    }
    
    /**
     * 衝突のポジティブデータを読み込み、それが衝突判定のイベントを発火するかどうかを確認する
     */
    @Test
    public void testInputPositive2() {
        List<Motion> motion1 = getMotions("shock_2");
        for (Motion m : motion1) {
            float[] accel = new float[3];
            accel[0] = (float) m.x;
            accel[1] = (float) m.y;
            accel[2] = (float) m.z;
            sensor.input(accel, m.time);
        }

        assertTrue("shock_2のモーションでイベントが発行されない", isCalled);
        assertFalse("shock_2のモーションで複数回のイベントが発行されている", doubleCalled);
    }
    
    /**
     * 衝突のポジティブデータを読み込み、それが衝突判定のイベントを発火するかどうかを確認する
     */
    @Test
    public void testInputPositive3() {
        List<Motion> motion1 = getMotions("shock_3");
        for (Motion m : motion1) {
            float[] accel = new float[3];
            accel[0] = (float) m.x;
            accel[1] = (float) m.y;
            accel[2] = (float) m.z;
            sensor.input(accel, m.time);
        }

        assertTrue("shock_3のモーションでイベントが発行されない", isCalled);
        assertFalse("shock_3のモーションで複数回のイベントが発行されている", doubleCalled);
    }
    
    /**
     * 衝突のポジティブデータを読み込み、それが衝突判定のイベントを発火するかどうかを確認する
     */
    @Test
    public void testInputPositive4() {
        List<Motion> motion1 = getMotions("shock_4");
        for (Motion m : motion1) {
            float[] accel = new float[3];
            accel[0] = (float) m.x;
            accel[1] = (float) m.y;
            accel[2] = (float) m.z;
            sensor.input(accel, m.time);
        }

        assertTrue("shock_4のモーションでイベントが発行されない", isCalled);
        assertFalse("shock_4のモーションで複数回のイベントが発行されている", doubleCalled);
    }
    
    /**
     * 衝突のポジティブデータを読み込み、それが衝突判定のイベントを発火するかどうかを確認する
     */
    @Test
    public void testInputPositive5() {
        List<Motion> motion1 = getMotions("shock_5");
        for (Motion m : motion1) {
            float[] accel = new float[3];
            accel[0] = (float) m.x;
            accel[1] = (float) m.y;
            accel[2] = (float) m.z;
            sensor.input(accel, m.time);
        }

        assertTrue("shock_5のモーションでイベントが発行されない", isCalled);
        assertFalse("shock_5のモーションで複数回のイベントが発行されている", doubleCalled);
    }
    
    /**
     * 衝突のネガティブデータを読み込み、それが衝突判定のイベントが発火しないことを確認する
     */
    @Test
    public void testInputNegative1() {
        List<Motion> motion1 = getMotions("shock_negative_1");
        for (Motion m : motion1) {
            float[] accel = new float[3];
            accel[0] = (float) m.x;
            accel[1] = (float) m.y;
            accel[2] = (float) m.z;
            sensor.input(accel, m.time);
        }

        assertFalse("shock_negative_1のモーションでイベントが発行されてしまう", isCalled);
    }

    /**
     * 衝突のネガティブデータを読み込み、それが衝突判定のイベントが発火しないことを確認する
     */
    @Test
    public void testInputNegative2() {
        List<Motion> motion1 = getMotions("shock_negative_2");
        for (Motion m : motion1) {
            float[] accel = new float[3];
            accel[0] = (float) m.x;
            accel[1] = (float) m.y;
            accel[2] = (float) m.z;
            sensor.input(accel, m.time);
        }

        assertFalse("shock_negative_2のモーションでイベントが発行されてしまう", isCalled);
    }

    /**
     * 衝突のネガティブデータを読み込み、それが衝突判定のイベントが発火しないことを確認する
     */
    @Test
    public void testInputNegative3() {
        List<Motion> motion1 = getMotions("shock_negative_3");
        for (Motion m : motion1) {
            float[] accel = new float[3];
            accel[0] = (float) m.x;
            accel[1] = (float) m.y;
            accel[2] = (float) m.z;
            sensor.input(accel, m.time);
        }

        assertFalse("shock_negative_2のモーションでイベントが発行されてしまう", isCalled);
    }

    /**
     * 衝突のネガティブデータを読み込み、それが衝突判定のイベントが発火しないことを確認する
     */
    @Test
    public void testInputNegative4() {
        List<Motion> motion1 = getMotions("shock_negative_4");
        for (Motion m : motion1) {
            float[] accel = new float[3];
            accel[0] = (float) m.x;
            accel[1] = (float) m.y;
            accel[2] = (float) m.z;
            sensor.input(accel, m.time);
        }

        assertFalse("shock_negative_2のモーションでイベントが発行されてしまう", isCalled);
    }

    /**
     * 衝突のネガティブデータを読み込み、それが衝突判定のイベントが発火しないことを確認する
     */
    @Test
    public void testInputNegative5() {
        List<Motion> motion1 = getMotions("shock_negative_5");
        for (Motion m : motion1) {
            float[] accel = new float[3];
            accel[0] = (float) m.x;
            accel[1] = (float) m.y;
            accel[2] = (float) m.z;
            sensor.input(accel, m.time);
        }

        assertFalse("shock_negative_5のモーションでイベントが発行されてしまう", isCalled);
    }

    /**
     * モーションファイルが取得できる
     */
    @Test
    public void fileTest() {
        assertTrue(new File("test/shock_1").exists());
    }

    public void onShocked(ShockEvent e) {
        if (this.isCalled) {
            this.doubleCalled = true;
            return;
        }
        this.e = e;
        this.isCalled = true;
    }

    private List<Motion> getMotions(String filename) {
        try {
            InputStream is = new FileInputStream(new File("test/" + filename));
            ObjectInputStream ois = new ObjectInputStream(is);
            Object obj = ois.readObject();
            return (List<Motion>)obj;
        } catch (Exception e) {
            e.printStackTrace();
            fail("テストモーションの読み込みに失敗");
        }
        return null;
    }
    
}
