package com.example.study.controller;


import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //localhost:8080/api에 매핑됨
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // /api/getMethod에 매핑
    public String getRequest(){
        return "Hi getMethod";
    }

    @GetMapping("/getParameter") //localhost:8080/api/getParameter?id=1234password=abcd 로 매핑되게함
    public String getParameter(@RequestParam String id, @RequestParam(name="password") String pwd){

        String password = "bbbb";

        System.out.println("id: "+id);
        System.out.println("pwd: "+pwd);

        return id+password;
    }

    //localhost:8080/api/multiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;

    }


}
