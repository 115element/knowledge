// [Content-Type: application/x-www-form-urlencoded] 表示参数在URL上


//curl 192.168.0.48:8080/b -X POST -d s=222     默认是：[Content-Type: application/x-www-form-urlencoded]
@PostMapping("b")
public String s(@RequestParam String s) {
    System.out.println(s);
    return s;
}

//curl 192.168.0.48:8080/b1 -X POST -d s1=222\&s2=111   默认是：[Content-Type: application/x-www-form-urlencoded]
@PostMapping("b1")
public String s(@RequestParam String s1, @RequestParam String s2) {
    System.out.println(s1 + "---" + s1);
    return s1 + s2;
}

@Data
public static class Req {
    private String s1;
    private String s2;
}

//curl 192.168.0.48:8080/b2 -d '{"s1":"1","s2":"2"}' --header "Content-Type: application/json"
@PostMapping("b2")
public String s1(@RequestBody Req req) {
    System.out.println(req);
    return JSONObject.toJSONString(req);
}