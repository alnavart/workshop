package org.demo.workshop;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("space")
interface HearingAid {

    @RequestMapping(method = RequestMethod.GET, value = "{spacecraft}/answer")
    Message getAnswerFrom(@PathVariable("spacecraft") String spacecraft);
}
