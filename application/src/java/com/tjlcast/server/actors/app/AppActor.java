package com.tjlcast.server.actors.app;


import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.SupervisorStrategy.Directive;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Function;
import com.tjlcast.server.actors.ActorSystemContext;
import com.tjlcast.server.actors.service.ContextAwareActor;
import com.tjlcast.server.actors.service.ContextBasedCreator;
import com.tjlcast.server.actors.service.DefaultActorService;
import com.tjlcast.server.actors.tenant.TenantActor;
import com.tjlcast.server.data.Device;
import com.tjlcast.server.data_source.FromMsgMiddlerDeviceMsg;
import com.tjlcast.server.message.DeviceRecognitionMsg;
import com.tjlcast.server.services.DeviceService;
import scala.concurrent.duration.Duration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by tangjialiang on 2017/12/8.
 *
 * AppActor in the world of Actor
 */

public class AppActor extends ContextAwareActor {

    private DeviceService deviceService;

    private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this) ;

    private final Map<UUID, ActorRef> tenantActors ;

    public AppActor(ActorSystemContext systemContext) {
        super(systemContext) ;
        this.tenantActors = new HashMap<>() ;
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof DeviceRecognitionMsg) {
            // not sure.
            UUID deviceId =((DeviceRecognitionMsg) message).getDeviceId();
            Device device=deviceService.findDeviceById(deviceId);
            UUID tenantId=device.getTenantId();
            getOrCreateTenantActor(tenantId).tell(message,ActorRef.noSender());
        } else if (message instanceof FromMsgMiddlerDeviceMsg) {
            FromMsgMiddlerDeviceMsg mmessage = (FromMsgMiddlerDeviceMsg) message;
            UUID tenantId = mmessage.getTenantId();
            getOrCreateTenantActor(tenantId).tell(message,ActorRef.noSender()) ;
        }
    }

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy ;
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
    }

    private ActorRef getOrCreateTenantActor(final UUID tenantId) {
        return tenantActors.computeIfAbsent(tenantId,
                k -> context().actorOf(Props.create(new TenantActor.ActorCreator(systemContext, tenantId)).withDispatcher(DefaultActorService.CORE_DISPATCHER_NAME),
                        tenantId.toString()));
    }

    // for creating the AppActor
    public static class ActorCreator extends ContextBasedCreator<AppActor> {
        /**
         * this class is the inner class of AppActor,
         * so could new an AppActor by this class.
         */

        public ActorCreator(ActorSystemContext context) {
            super(context);
        }

        @Override
        public AppActor create() throws Exception {
            return new AppActor(context) ;
        }
    }

    private final SupervisorStrategy strategy = new OneForOneStrategy(3,
            Duration.create("1 minute"),
            new Function<Throwable, Directive>() {
                @Override
                public Directive apply(Throwable param) throws Exception {
                    logger.error(param, "Unknown failure") ;
                    if (param instanceof RuntimeException) {
                        return SupervisorStrategy.restart() ;
                    } else {
                        return SupervisorStrategy.stop() ;
                    }
                }
            }) ;
}
