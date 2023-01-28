package com.driver;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("whatsapp")
public class WhatsappController {

    //Autowire will not work in this case, no need to change this and add autowire
    WhatsappService whatsappService = new WhatsappService();

    @PostMapping("/add-user")
    public String createUser(String name, String mobile) throws Exception {

        return whatsappService.createUser(name, mobile);
    }

    @PostMapping("/add-group")
    public Group createGroup(List<User> users){
        return whatsappService.createGroup(users);
    }

    @PostMapping("/add-message")
    public int createMessage(String content){
        return whatsappService.createMessage(content);
    }

    @PutMapping("/send-message")
    public int sendMessage(Message message, User sender, Group group) throws Exception{
        return whatsappService.sendMessage(message, sender, group);
    }
    @PutMapping("/change-admin")
    public String changeAdmin(User approver, User user, Group group) throws Exception{
        return whatsappService.changeAdmin(approver, user, group);
    }

    @DeleteMapping("/remove-user")
    public int removeUser(User user) throws Exception{
        return whatsappService.removeUser(user);
    }

    @GetMapping("/find-messages")
    public String findMessage(Date start, Date end, int K) throws Exception{
        return whatsappService.findMessage(start, end, K);
    }
}
