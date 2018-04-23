package com.tjlcast.server.actors.rule;

import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.tjlcast.server.actors.ActorSystemContext;
import com.tjlcast.server.actors.service.ContextAwareActor;
import com.tjlcast.server.actors.service.ContextBasedCreator;
import com.tjlcast.server.data.Filter;
import com.tjlcast.server.data_source.FromMsgMiddlerDeviceMsg;
import com.tjlcast.server.message.DeviceRecognitionMsg;
import com.tjlcast.server.nashorn.NashornTest;
import com.tjlcast.server.services.FilterService;

import javax.persistence.criteria.From;
import java.util.List;
import java.util.UUID;

/**
 * Created by tangjialiang on 2017/12/8.
 */
public class RuleActor extends ContextAwareActor {
    private FilterService filterService;

    private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this) ;

    private final UUID tenantId ;
    private final UUID ruleId ;
    private final RuleActorMessageProcessor processor;
    public final List<Filter> filters; // todo


    private RuleActor(ActorSystemContext context, UUID tenantId, UUID ruleId) {
        super(context) ;
        this.tenantId = tenantId ;
        this.ruleId = ruleId ;
        this.processor = new RuleActorMessageProcessor(systemContext, logger, ruleId, this);
        this.filters=filterService.findFilterByRuleId(ruleId);
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof DeviceRecognitionMsg){

            boolean tag = true;

            for(Filter filter:filters) {
                NashornTest noshorn = new NashornTest(filter.getJsCode(), ((DeviceRecognitionMsg) message).getKey(), ((DeviceRecognitionMsg) message).getValue());
                if (!noshorn.invokeFunction()) {
                    tag = false;
                    break;
                }
            }

            if(tag)
            {
                processor.process((DeviceRecognitionMsg) message);
            }
        } else if (message instanceof FromMsgMiddlerDeviceMsg) {
            processor.process((FromMsgMiddlerDeviceMsg)message);
        }
    }

    public static class ActorCreator extends ContextBasedCreator<RuleActor> {
        private static final long serialVersionUID = 1L ;

        private final UUID tenantId ;
        private final UUID ruleId ;

        public ActorCreator(ActorSystemContext context, UUID tenantId,UUID ruleId) {
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
