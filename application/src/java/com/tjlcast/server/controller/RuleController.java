package com.tjlcast.server.controller;

import com.tjlcast.server.data.Rule;
import com.tjlcast.server.services.RuleService;
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

    //Post
    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addRule(@RequestBody String jsonStr) {
        // todo
        // 1. decode the jsonStr to be a jsonObj.
        // 2. add the jsonStr to db.
        return "OK" ;
    }

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/{rulrId}/activate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String activateRule(@PathVariable("ruleId") String ruleId) {
        // todo
        // 1. update state to activate
        return "Activate" ;
    }

    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/{rulrId}/suspend", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String suspendRule(@PathVariable("ruleId") String ruleId) {
        // todo
        // 1. activate state to suspend
        return "Suspend" ;
    }

    //Delete
    @ApiOperation(value = "todo ***")
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
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
