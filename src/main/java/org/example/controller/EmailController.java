package org.example.controller;

import jakarta.validation.Valid;
import org.example.entity.MailAddress;
import org.example.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class EmailController {

    private EmailServiceImpl emailService;

    @Autowired
    public EmailController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/emails")
    public String getEmails(Model model) {
        model.addAttribute("emailList", emailService.getEmailAddresses());
        return "emailPage";
    }

    @PostMapping("/emails")
    public String addEmail(@Valid MailAddress newEmail,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtil.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("emailList", emailService.getEmailAddresses());
            return "emailPage";
        }
        emailService.addEmailAddress(newEmail);
        return "redirect:/emails";
    }

    @GetMapping("/editEmail")
    public String editEmail(@RequestParam MailAddress email, Model model) {
        model.addAttribute("emailToEdit", email.getMailAddress());
        return "editEmailPage";
    }

    @PostMapping("/saveEmail")
    public String saveEmail(@RequestParam String emailToEdit,
                            @Valid MailAddress editedEmail,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtil.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("emailToEdit", emailToEdit);
            return "editEmailPage";
        }
        emailService.updateEmailAddress(emailToEdit, editedEmail);
        return "redirect:/emails";
    }

    @GetMapping("/deleteEmail")
    public String deleteEmail(@RequestParam String email) {
        emailService.deleteEmailAddress(email);
        return "redirect:/emails";
    }
}

