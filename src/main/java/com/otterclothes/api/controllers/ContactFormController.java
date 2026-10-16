package com.otterclothes.api.controllers;

import com.otterclothes.api.models.ContactForm;
import com.otterclothes.api.repository.ContactFormRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-forms")
public class ContactFormController {

    private final ContactFormRepository contactFormRepository;

    public ContactFormController(ContactFormRepository contactFormRepository) {
        this.contactFormRepository = contactFormRepository;
    }

    @GetMapping
    public List<ContactForm> getAllContactForms() {
        return contactFormRepository.findAll();
    }

    @PostMapping
    public ContactForm createContactForm(@RequestBody ContactForm contactForm) {
        contactForm.setContactFormId(null);
        return contactFormRepository.save(contactForm);
    }
}