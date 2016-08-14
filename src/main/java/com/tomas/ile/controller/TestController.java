package com.tomas.ile.controller;

import com.tomas.ile.dto.*;
import com.tomas.ile.services.UserServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Locale;
import java.util.Map;

/**
 * @author Tomas Yussef Galicia Guzman
 */
@Controller
public class TestController
{
    private static final Logger log = LogManager.getLogger();

    @Inject
    private UserServices userServices;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUser(Map<String, Object> model, Locale locale)
    {
        log.info("\n\n" + locale + "\n\n");
        model.put("userDto", new UserDto());
        return "test/form";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@Valid @ModelAttribute("userDto") UserDto userDto,
                           BindingResult bindingResult,
                           Map<String, Object> model)
    {
        if (bindingResult.hasErrors())
            return "test/form";
        this.userServices.addUserDto(userDto);
        return "redirect:/list";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String getViewUser(@PathVariable("id") Long id, Map<String, Object> model)
    {
        model.put("userDto", this.userServices.getUser(id));
        return "test/view";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUpdateUser( Map<String, Object> model, @PathVariable("id") Long id)
    {
        model.put("userDto", this.userServices.getUser(id));
        return "test/form";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String postUpdateUser(@Valid @ModelAttribute("userDto") UserDto userDto,
                                 BindingResult bindingResult,
                                 Map<String, Object> model)
    {
        if (bindingResult.hasErrors())
            return "test/update";

        this.userServices.updateUserDto(userDto);

        return "redirect:/list";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String getRemoveUser(@PathVariable("id") Long id)
    {
        this.userServices.removeUserDto(id);
        return "redirect:/list";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getRemoveUser( Map<String, Object> model)
    {
        model.put("list", this.userServices.getAllUser());
        return "test/list";
    }
}
