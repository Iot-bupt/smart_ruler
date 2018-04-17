package com.tjlcast.server.actors.tenant;


import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.tjlcast.server.actors.ActorSystemContext;
import com.tjlcast.server.actors.rule.RuleActor;
import com.tjlcast.server.actors.service.ContextAwareActor;
import com.tjlcast.server.actors.service.ContextBasedCreator;
import com.tjlcast.server.actors.service.DefaultActorService;
import com.tjlcast.server.data.Rule;
import com.tjlcast.server.message.DeviceRecognitionMsg;
import com.tjlcast.server.services.RulerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by tangjialiang on 2017/12/8.
 *
 */

public class TenantActor extends ContextAwareActor {
    private RulerService ruleService;

    private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this) ;

    private final UUID tenantId ;
    private final Map<UUID, ActorRef> ruleActors ;

    public TenantActor(ActorSystemContext context, UUID tenantId) {
        super(context) ;
        this.tenantId = tenantId;
        ruleActors = new HashMap<UUID, ActorRef>() ;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof DeviceRecognitionMsg)
        {
            List<Rule> rules=ruleService.findRuleByTenantId(tenantId);
            for (Rule rule : rules)
            {
                getOrCreateRuleActor(rule.getId()).tell(message,ActorRef.noSender());
            }
        }
//        if (message instanceof ToDeviceActorNotificationMsg) {
//            onToDeviceActorMsg((ToDeviceActorNotificationMsg) message);
//        } else if(message instanceof DeviceRecognitionMsg){
//            getOrCreateDeviceActor(((DeviceRecognitionMsg) message).getDeviceId()).tell(message,ActorRef.noSender());
//        }
    }

    private ActorRef getOrCreateRuleActor(final UUID ruleId) {
        return ruleActors.computeIfAbsent(
                ruleId,
                k -> context().actorOf(Props.create(new RuleActor.ActorCreator(systemContext, tenantId, ruleId)).withDispatcher(DefaultActorService.CORE_DISPATCHER_NAME),
                        ruleId.toString())
        ) ;
    }

    public static class ActorCreator extends ContextBasedCreator<TenantActor> {
        private static final long serialVersionUID = 1L ;

        private final UUID tenantId ;

        public ActorCreator(ActorSystemContext context, UUID tenantId) {
            super(context);
            this.tenantId = tenantId ;
        }

        @Override
        public TenantActor create() throws  Exception {
            return new TenantActor(context, tenantId) ;
        }
    }

//    private void onToDeviceActorMsg(ToDeviceActorNotificationMsg msg) {
//        getOrCreateDeviceActor(msg.getDeviceId()).tell(msg, ActorRef.noSender());
//    }
}
