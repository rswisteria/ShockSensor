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
     * �Փ˂̃|�W�e�B�u�f�[�^��ǂݍ��݁A���ꂪ�Փ˔���̃C�x���g�𔭉΂��邩�ǂ������m�F����
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

        assertTrue("shock_1�̃��[�V�����ŃC�x���g�����s����Ȃ�", isCalled);
        assertFalse("shock_1�̃��[�V�����ŕ�����̃C�x���g�����s����Ă���", doubleCalled);
    }
    
    /**
     * �Փ˂̃|�W�e�B�u�f�[�^��ǂݍ��݁A���ꂪ�Փ˔���̃C�x���g�𔭉΂��邩�ǂ������m�F����
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

        assertTrue("shock_2�̃��[�V�����ŃC�x���g�����s����Ȃ�", isCalled);
        assertFalse("shock_2�̃��[�V�����ŕ�����̃C�x���g�����s����Ă���", doubleCalled);
    }
    
    /**
     * �Փ˂̃|�W�e�B�u�f�[�^��ǂݍ��݁A���ꂪ�Փ˔���̃C�x���g�𔭉΂��邩�ǂ������m�F����
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

        assertTrue("shock_3�̃��[�V�����ŃC�x���g�����s����Ȃ�", isCalled);
        assertFalse("shock_3�̃��[�V�����ŕ�����̃C�x���g�����s����Ă���", doubleCalled);
    }
    
    /**
     * �Փ˂̃|�W�e�B�u�f�[�^��ǂݍ��݁A���ꂪ�Փ˔���̃C�x���g�𔭉΂��邩�ǂ������m�F����
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

        assertTrue("shock_4�̃��[�V�����ŃC�x���g�����s����Ȃ�", isCalled);
        assertFalse("shock_4�̃��[�V�����ŕ�����̃C�x���g�����s����Ă���", doubleCalled);
    }
    
    /**
     * �Փ˂̃|�W�e�B�u�f�[�^��ǂݍ��݁A���ꂪ�Փ˔���̃C�x���g�𔭉΂��邩�ǂ������m�F����
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

        assertTrue("shock_5�̃��[�V�����ŃC�x���g�����s����Ȃ�", isCalled);
        assertFalse("shock_5�̃��[�V�����ŕ�����̃C�x���g�����s����Ă���", doubleCalled);
    }
    
    /**
     * �Փ˂̃l�K�e�B�u�f�[�^��ǂݍ��݁A���ꂪ�Փ˔���̃C�x���g�����΂��Ȃ����Ƃ��m�F����
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

        assertFalse("shock_negative_1�̃��[�V�����ŃC�x���g�����s����Ă��܂�", isCalled);
    }

    /**
     * �Փ˂̃l�K�e�B�u�f�[�^��ǂݍ��݁A���ꂪ�Փ˔���̃C�x���g�����΂��Ȃ����Ƃ��m�F����
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

        assertFalse("shock_negative_2�̃��[�V�����ŃC�x���g�����s����Ă��܂�", isCalled);
    }

    /**
     * �Փ˂̃l�K�e�B�u�f�[�^��ǂݍ��݁A���ꂪ�Փ˔���̃C�x���g�����΂��Ȃ����Ƃ��m�F����
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

        assertFalse("shock_negative_2�̃��[�V�����ŃC�x���g�����s����Ă��܂�", isCalled);
    }

    /**
     * �Փ˂̃l�K�e�B�u�f�[�^��ǂݍ��݁A���ꂪ�Փ˔���̃C�x���g�����΂��Ȃ����Ƃ��m�F����
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

        assertFalse("shock_negative_2�̃��[�V�����ŃC�x���g�����s����Ă��܂�", isCalled);
    }

    /**
     * �Փ˂̃l�K�e�B�u�f�[�^��ǂݍ��݁A���ꂪ�Փ˔���̃C�x���g�����΂��Ȃ����Ƃ��m�F����
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

        assertFalse("shock_negative_5�̃��[�V�����ŃC�x���g�����s����Ă��܂�", isCalled);
    }

    /**
     * ���[�V�����t�@�C�����擾�ł���
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
            fail("�e�X�g���[�V�����̓ǂݍ��݂Ɏ��s");
        }
        return null;
    }
    
}
