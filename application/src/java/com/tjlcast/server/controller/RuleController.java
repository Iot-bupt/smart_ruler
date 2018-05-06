package com.tjlcast.server.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tjlcast.server.data.Filter;
import com.tjlcast.server.data.Rule;
import com.tjlcast.server.data.Rule2Filter;
import com.tjlcast.server.data_source.RuleCreation;
import com.tjlcast.server.services.FilterService;
import com.tjlcast.server.services.Rule2FilterService;
import com.tjlcast.server.services.RuleService;
import com.tjlcast.server.services.TransformService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tangjialiang on 2018/4/13.
 */

@RestController
@RequestMapping("/api/rule")
@Slf4j
public class RuleController extends BaseContoller {
    @Autowired
    RuleService ruleService ;

    @Autowired
    FilterService filterService;

    @Autowired
    TransformService transformService;

    @Autowired
    Rule2FilterService rule2FilterService;

    //Post
    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addRule(@RequestBody String jsonStr) {
        JsonObject jsonObj = (JsonObject)new JsonParser().parse(jsonStr);
        RuleCreation ruleCreation = new RuleCreation(jsonObj);

        transformService.addTransform(ruleCreation.getTransform());
        Integer transformId =ruleCreation.getTransform().getTransformId();
        ruleCreation.getRule().setTransformId(transformId);

        ruleService.addRule(ruleCreation.getRule());
        Integer ruleId = ruleCreation.getRule().getRuleId();


        for(Filter filter:ruleCreation.getFilters())
        {
            filterService.addFilter(filter);
            Integer filterId =filter.getFilterId();

            Rule2Filter rule2Filter=new Rule2Filter(ruleId,filterId);
            rule2FilterService.addARelation(rule2Filter);

        }
        return "OK" ;
    }

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/{rulrId}/activate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String activateRule(@PathVariable("ruleId") String ruleId) {
        ruleService.setRuleActive(Integer.valueOf(ruleId));
        return "Activate" ;
    }

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/{rulrId}/suspend", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String suspendRule(@PathVariable("ruleId") String ruleId) {
        ruleService.setRuleSuspend(Integer.valueOf(ruleId));
        return "Suspend" ;
    }

    //Delete
    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String removeRule(@RequestParam String id) {
        // todo
        // 1. remove the rule in db.
        return "OK" ;
    }

    //GET
    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/rules", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Rule> getRules() {
        List<Rule> allRule = ruleService.getAllRule();
        return allRule ;
    }

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/tenantRule/{tenantId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Rule> getTenantRules(@PathVariable("tenantId") String tenantId)
    {
        List<Rule> allTenantRule = ruleService.findRuleByTenantId(Integer.valueOf(tenantId));
        return  allTenantRule;
    }

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/rule/{ruleId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Rule getARule(@PathVariable("ruleId") String ruleId)
    {
        Rule aRule = ruleService.findRuleById(Integer.valueOf(ruleId));
        return aRule;
    }

}
