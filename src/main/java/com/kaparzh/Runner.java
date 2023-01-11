package com.kaparzh;

import com.kaparzh.service.impl.EventServiceImpl;
import com.kaparzh.service.impl.FileServiceImpl;
import com.kaparzh.service.impl.UserServiceImpl;

public class Runner {

    public static void main(String[] args) {
//        UserServiceImpl userService = UserServiceImpl.getInstance();
//        System.out.println(userService.getById(1));

//        FileServiceImpl fileService = FileServiceImpl.getInstance();
//        System.out.println(fileService.getById(1));

        EventServiceImpl eventService = EventServiceImpl.getInstance();
        System.out.println(eventService.getAll());
    }
}
