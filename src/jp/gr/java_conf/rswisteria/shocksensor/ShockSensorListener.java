package jp.gr.java_conf.rswisteria.shocksensor;

import jp.gr.java_conf.rswisteria.shocksensor.event.ShockEvent;

/**
 * 衝撃を感知した場合に通知されるイベントのリスナー.
 *
 * @author TOYOTA, Yoichi
 *
 */
public interface ShockSensorListener {

    /**
     * 衝撃を感知した場合に呼び出されるメソッド.
     *
     * @param event イベントオブジェクト
     */
    void onShocked(ShockEvent event);
}
