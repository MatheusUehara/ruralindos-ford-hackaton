package com.applink.ford.hellosdlandroid;

import android.util.Log;

import com.smartdevicelink.proxy.rpc.BodyInformation;
import com.smartdevicelink.proxy.rpc.GPSData;
import com.smartdevicelink.proxy.rpc.GetVehicleData;
import com.smartdevicelink.proxy.rpc.SubscribeVehicleData;
import com.smartdevicelink.proxy.rpc.VehicleDataResult;

/**
 * Created by igormlgomes on 21/08/16.
 */
public class Info {

    BodyInformation bi = new BodyInformation();

    public void setBi(BodyInformation bi) {
        bi.getDriverDoorAjar();
        bi.getPassengerDoorAjar();
        bi.getRearLeftDoorAjar();
        bi.getRearRightDoorAjar();
        this.bi = bi;

    }

    public BodyInformation getBi() {
        return bi;
    }

    GPSData gpsData = new GPSData();

    public void setGpsData(GPSData gpsData) {
        gpsData.getActual();
        gpsData.getLatitudeDegrees();
        getGpsData().getLongitudeDegrees();
        this.gpsData = gpsData;

    }

    public GPSData getGpsData() {
        return gpsData;
    }


    GetVehicleData vd = new GetVehicleData();

    public void setVd(GetVehicleData vd) {
        vd.getVin();
        vd.getDeviceStatus();
        this.vd = vd;

    }

    SubscribeVehicleData info = new SubscribeVehicleData();

    public void setInfo(SubscribeVehicleData info) {
        info.getDeviceStatus();
        info.getGps();
        this.info = info;
    }

    public Info(){

    }
}
