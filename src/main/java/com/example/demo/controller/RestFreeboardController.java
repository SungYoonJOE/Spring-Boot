/*
 * package com.example.demo.controller;
 * 
 * import javax.servlet.http.HttpSession;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.ResponseBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.demo.mappers.FreeboardMapper; import
 * com.example.demo.model.Freeboard;
 * 
 * @RestController public class RestFreeboardController {
 * 
 * @Autowired private FreeboardMapper freeboardMapper;
 * 
 * 
 * @GetMapping("/freeBoardInfo") public @ResponseBody Freeboard
 * getFreeboard(@RequestParam(value = "freeId") String freeId, @Autowired
 * HttpSession session) { Long freeid = Long.parseLong(freeId); Freeboard
 * freeboard = freeboardMapper.selectFreeboardById(freeid);
 * 
 * if(freeboard == null ) {String page = "freeboard";}
 * session.setAttribute("freeboard", freeboard);
 * 
 * //freeboard를 JSON으로 프론트에 주기
 * 
 * return freeboard; } }
 */