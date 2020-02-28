package com.foreknow.test;

import com.foreknow.model.Guestbook;
import com.foreknow.service.GuestbookService;
import com.foreknow.service.GuestbookServiceImpl;

import java.util.Date;

public class GuestbookServiceTest {
    public static void main(String[] args) {
        Guestbook gb = new Guestbook();
        gb.setName("刘哲");
        gb.setPhone("12312312321");
        gb.setEmail("xxx@xxx.com");
        gb.setTitle("111");
        gb.setContent("context");
        gb.setCreatedtime(new Date().toString());
        GuestbookService service = new GuestbookServiceImpl();
        boolean isRight = service.save(gb);
        if (isRight) System.out.println("添加成功");
    }
}
