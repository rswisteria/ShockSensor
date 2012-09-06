# ShockSensor

ShockSensorはAndroid等で利用される3軸加速度センサーからの入力を受け取り、Bumpみたいなアプリで
利用される衝突アクションを感知し、イベントを発行するためのライブラリです。

# Getting Start

ShockSensorは衝突を感知した際にイベントを発行するオブザーバーとして機能します。
衝突が発生したときに実行したいイベントをShockSensorListenerインターフェイスを持つクラスとして実装します。

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
            // ShockSensorListenerのインターフェイスを実装するメソッド
            // 衝突が発生した際に実行したい処理を記述
        }
    }

Androidで利用する場合、上記のように加速度センサーを初期化し、加速度センサーの値が変更した際に
呼び出されるonSensorChangedで、ShockSensor#inputを呼び出します。これにより、変化する加速度
がShockSensorに逐一入力され、入力された加速度を衝突と見なすとShockSensor#addShockSensorListener
で登録されているイベントリスナーのonShockedメソッドを呼び出します。

衝突自体が比較的短い時間の加速度の変化を伴い、その判断を行う必要があるため、加速度センサーの取得頻度は
SENSOR_DELAY_GAME(20msに1度くらいの頻度で加速度を取得可能)に設定する必要があります。
SENSOR_DELAY_UIやSENSOR_DELAY_NORMAL程度の頻度だと、おそらく衝突が検知できないはずです。

# 衝突検知の仕組み

端末の衝突のような加速度の特徴として、端末の急停止による急加速が短時間に発生することが上げられます。
このライブラリでは、加速度センサーから取得できる値から重力加速度を取り除き、そのベクトルの大きさ（スカラ値）
が短時間で増加→減少という変化をした場合に、それを衝突と判定するように実装してあります。
