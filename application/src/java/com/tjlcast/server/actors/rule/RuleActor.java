package com.tjlcast.server.actors.rule;

import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.tjlcast.server.actors.ActorSystemContext;
import com.tjlcast.server.actors.service.ContextAwareActor;
import com.tjlcast.server.actors.service.ContextBasedCreator;
import com.tjlcast.server.message.DeviceRecognitionMsg;

import java.util.UUID;

/**
 * Created by tangjialiang on 2017/12/8.
 */
public class RuleActor extends ContextAwareActor {

    private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this) ;

    private final UUID tenantId ;
    private final UUID ruleId ;
    private final RuleActorMessageProcessor processor;

    private RuleActor(ActorSystemContext context, UUID tenantId, UUID ruleId) {
        super(context) ;
        this.tenantId = tenantId ;
        this.ruleId = ruleId ;
        this.processor = new RuleActorMessageProcessor(systemContext, logger, ruleId);
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof DeviceRecognitionMsg){

        }
//            processor.process((DeviceRecognitionMsg)message);
//        } else if (message instanceof ToDeviceActorNotificationMsg) {
//            if (msg instanceof DeviceAttributesEventNotificationMsg) {
//                processor.processAttributesUpdate(context(), (DeviceAttributesEventNotificationMsg) msg);
//            } else if (msg instanceof ToDeviceRpcRequestPluginMsg) {
//                processor.processRpcRequest(context(), (ToDeviceRpcRequestPluginMsg) msg);
//            } else if (msg instanceof DeviceCredentialsUpdateNotificationMsg){
//                processor.processCredentialsUpdate();
//            } else if (msg instanceof DeviceNameOrTypeUpdateMsg){
//                processor.processNameOrTypeUpdate((DeviceNameOrTypeUpdateMsg) msg);
//                //TODO modified by cc
//            }
//            if(message instanceof DeviceShadowMsg){
//                processor.processDeviceShadowMsg((DeviceShadowMsg)message);
//           }
//        }//TODO filter and process
    }

    public static class ActorCreator extends ContextBasedCreator<RuleActor> {
        private static final long serialVersionUID = 1L ;

        private final UUID tenantId ;
        private final UUID ruleId ;

        public ActorCreator(ActorSystemContext context, UUID tenantId, UUID ruleId) {
            super(context) ;
            this.tenantId = tenantId ;
            this.ruleId = ruleId ;
        }

        @Override
        public RuleActor create() throws Exception {
            return new RuleActor(context, tenantId, ruleId) ;
        }
    }
}
