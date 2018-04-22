package com.tjlcast.server.actors.rule;


import akka.event.LoggingAdapter;
import com.tjlcast.server.actors.ActorSystemContext;
import com.tjlcast.server.actors.shared.AbstractContextAwareMsgProcessor;
import com.tjlcast.server.message.DeviceRecognitionMsg;
import okhttp3.*;
import scala.concurrent.duration.Duration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangjialiang on 2017/12/12.
 */
public class RuleActorMessageProcessor extends AbstractContextAwareMsgProcessor {

    private final UUID ruleId;
    private final Map<UUID, UUID> sessions;
    private final Map<UUID, UUID> attributeSubscriptions;
    private final Map<UUID, UUID> rpcSubscriptions;

    public RuleActorMessageProcessor(ActorSystemContext systemContext, LoggingAdapter logger, UUID ruleId) {
        super(systemContext, logger);
        this.ruleId = ruleId;
        this.sessions = new HashMap<>();
        this.attributeSubscriptions = new HashMap<>();
        this.rpcSubscriptions = new HashMap<>();

        initAttributes();
    }

    private void initAttributes() {
//        Device device = systemContext.getDeviceService().findDeviceById(deviceId);
//        this.deviceName = device.getName();
//        this.deviceType = device.getType();
//        this.deviceAttributes = new DeviceAttributes(fetchAttributes(DataConstants.CLIENT_SCOPE),
//                fetchAttributes(DataConstants.SERVER_SCOPE), fetchAttributes(DataConstants.SHARED_SCOPE));
        // 初始化设备影子
        //TODO 初始化设备影子并开启心跳
        initDeviceShadow();
        systemContext.getScheduler().schedule(Duration.create(2000, TimeUnit.MILLISECONDS),
                Duration.create(2000, TimeUnit.MILLISECONDS), new Runnable() {
                    @Override
                    public void run() {
                        //TODO 发送心跳
                    }
                },systemContext.getActorSystem().dispatcher());

    }


    private void initDeviceShadow(){
//        Device device = systemContext.getDeviceService().findDeviceById(deviceId);
//        String manufacture = device.getManufacture();
//        String deviceType = device.getDeviceType();
//        String model = device.getModel();
//        if(StringUtil.checkNotNull(manufacture,deviceType,model)){
//            deviceShadow = HttpUtil.getDeviceShadowDoc(manufacture,deviceType,model);
//            deviceShadow.addProperty("deviceId",device.getId().toString());
//            //TODO send to service midware
//        }
    };

//    private void refreshAttributes(DeviceAttributesEventNotificationMsg msg) {
//        if (msg.isDeleted()) {
//            msg.getDeletedKeys().forEach(key -> deviceAttributes.remove(key));
//        } else {
//            deviceAttributes.update(msg.getScope(), msg.getValues());
//        }
//    }

    public void process(DeviceRecognitionMsg msg){

        OkHttpClient client = new OkHttpClient();
        FormBody.Builder formBody =new FormBody.Builder();
        formBody.add("deviceId",msg.getDeviceId().toString());
        formBody.add("deviceName",msg.getDeviceName());
        formBody.add("ts",msg.getTs());
        formBody.add("key",msg.getKey());
        formBody.add("value",msg.getValue().toString());
        Request request = new Request.Builder()
                .url("") //Todo 输入URL
                .post(formBody.build())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    //Todo something
                }
            }
        });
//        Device device = systemContext.getDeviceService().findDeviceById(deviceId);
//        String manufacture = msg.getManufacture();
//        String deviceType = msg.getDeviceType();
//        String model = msg.getModel();
//        if(StringUtil.checkNotNull(manufacture,deviceType,model)){
//            deviceShadow = HttpUtil.getDeviceShadowDoc(manufacture,deviceType,model);
//            deviceShadow.addProperty("deviceId",device.getId().toString());
//            //TODO send to service midware
//        }
    }
}
