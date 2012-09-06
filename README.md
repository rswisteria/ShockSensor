# ShockSensor

ShockSensor��Android���ŗ��p�����3�������x�Z���T�[����̓��͂��󂯎��ABump�݂����ȃA�v����
���p�����Փ˃A�N�V���������m���A�C�x���g�𔭍s���邽�߂̃��C�u�����ł��B

# Getting Start

ShockSensor�͏Փ˂����m�����ۂɃC�x���g�𔭍s����I�u�U�[�o�[�Ƃ��ċ@�\���܂��B
�Փ˂����������Ƃ��Ɏ��s�������C�x���g��ShockSensorListener�C���^�[�t�F�C�X�����N���X�Ƃ��Ď������܂��B

    public class SampleActivity extends Activity
            implements ShockSensorListener, SensorEventListener {
        private ShockSensor sensor = new ShockSensor();
        private SensorManager manager;
        
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            SensorManager manager =
                    (SensorManager)getSystemService(SENSOR_SERVICE);
            List<Sensor> sensors =
                    manager.getSensorList(Sensor.TYPE_ACCELEROMETER);
            if (sensors.size() > 0) {
                Sensor s = sensors.get(0);
                this.sensorManager.registerListener(this, s,
                        SensorManager.SENSOR_DELAY_GAME);
                manager.registerListener(this, s);
            }
            sensor.addShockSensorListener(this);
        }

        public void onSensorChanged(SensorEvent event) {
            sensor.input(event.value);
        }
        
        public void onShocked(ShockEvent event) {
            // ShockSensorListener�̃C���^�[�t�F�C�X���������郁�\�b�h
            // �Փ˂����������ۂɎ��s�������������L�q
        }
    }

Android�ŗ��p����ꍇ�A��L�̂悤�ɉ����x�Z���T�[�����������A�����x�Z���T�[�̒l���ύX�����ۂ�
�Ăяo�����onSensorChanged�ŁAShockSensor#input���Ăяo���܂��B����ɂ��A�ω���������x
��ShockSensor�ɒ�����͂���A���͂��ꂽ�����x���Փ˂ƌ��Ȃ���ShockSensor#addShockSensorListener
�œo�^����Ă���C�x���g���X�i�[��onShocked���\�b�h���Ăяo���܂��B

�Փˎ��̂���r�I�Z�����Ԃ̉����x�̕ω��𔺂��A���̔��f���s���K�v�����邽�߁A�����x�Z���T�[�̎擾�p�x��
SENSOR_DELAY_GAME(20ms��1�x���炢�̕p�x�ŉ����x���擾�\)�ɐݒ肷��K�v������܂��B
SENSOR_DELAY_UI��SENSOR_DELAY_NORMAL���x�̕p�x���ƁA�����炭�Փ˂����m�ł��Ȃ��͂��ł��B

# �Փˌ��m�̎d�g��

�[���̏Փ˂̂悤�ȉ����x�̓����Ƃ��āA�[���̋}��~�ɂ��}�������Z���Ԃɔ������邱�Ƃ��グ���܂��B
���̃��C�u�����ł́A�����x�Z���T�[����擾�ł���l����d�͉����x����菜���A���̃x�N�g���̑傫���i�X�J���l�j
���Z���Ԃő����������Ƃ����ω��������ꍇ�ɁA������Փ˂Ɣ��肷��悤�Ɏ������Ă���܂��B
