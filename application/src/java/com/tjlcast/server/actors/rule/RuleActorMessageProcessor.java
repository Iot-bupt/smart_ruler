package com.tjlcast.server.actors.rule;


import akka.event.LoggingAdapter;
import com.tjlcast.server.actors.ActorSystemContext;
import com.tjlcast.server.actors.shared.AbstractContextAwareMsgProcessor;
import com.tjlcast.server.data.Filter;
import com.tjlcast.server.data_source.FromMsgMiddlerDeviceMsg;
import com.tjlcast.server.data_source.Item;
import com.tjlcast.server.message.DeviceRecognitionMsg;
import com.tjlcast.server.nashorn.Nashorn;
import okhttp3.*;
import scala.concurrent.duration.Duration;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangjialiang on 2017/12/12.
 */
public class RuleActorMessageProcessor extends AbstractContextAwareMsgProcessor {

    private Nashorn nashorn;

    private final UUID ruleId;
    private final List<Filter> filters;


    public RuleActorMessageProcessor(ActorSystemContext systemContext, LoggingAdapter logger, UUID ruleId) {
        super(systemContext, logger);
        this.ruleId = ruleId;
        this.filters=systemContext.getFilterService().findFilterByRuleId(ruleId);
        this.nashorn=new Nashorn();

        initAttributes();
    }

    public RuleActorMessageProcessor(ActorSystemContext systemContext, LoggingAdapter logger, UUID ruleId, RuleActor belongActor) {
        super(systemContext, logger);
        this.ruleId = ruleId;
        this.filters=systemContext.getFilterService().findFilterByRuleId(ruleId);
        this.nashorn=new Nashorn();
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

    public void process(FromMsgMiddlerDeviceMsg msg) throws ScriptException, NoSuchMethodException {
        // todo
        for(int i=0;i<msg.getItems().size();i++) {
            Item item = msg.getItems().get(i);
            if(nashornProcess(filters,item))
            {
                sendHTTPRequest(msg);
            }
        }
    }

    public boolean nashornProcess(List<Filter> filters, Item item) throws ScriptException, NoSuchMethodException {
        for(Filter filter:filters) {

            if (!nashorn.invokeFunction(filter.getJsCode(), item.getKey(), Double.parseDouble(item.getValue()))) {
                    return false;
            }
        }

        return true;
    }

    public String sendHTTPRequest(FromMsgMiddlerDeviceMsg msg)
    {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder formBody =new FormBody.Builder();
        formBody.add("deviceId",msg.getDeviceId().toString());
        formBody.add("tenantId",msg.getTenantId().toString());
        formBody.add("data",msg.getItems().toString());
        Request request = new Request.Builder()
                .url("http://localhost:8080/api/test/receive") //Todo 输入URL
                .post(formBody.build())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e);
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    System.out.println("Success");
                }
            }
        });
        return "Success";
    }



}
