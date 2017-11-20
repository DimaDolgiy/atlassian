package com.atlassian.plugin.servlet;

import com.atlassian.plugin.data.Tickets;
import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atlassian.templaterenderer.TemplateRenderer;

@ExportAsService
public class TicketsServlet extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(TicketsServlet.class);
    private static final String LIST_TICKETS_TEMPLATE = "/templates/tickets.vm";
    private TemplateRenderer templateRenderer;


    @Inject
    public TicketsServlet(@ComponentImport TemplateRenderer templateRenderer) {
        this.templateRenderer = templateRenderer;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Map<String, Object> context = new HashMap();
        List<Tickets> ticketsList = new ArrayList();

        ticketsList.add(new Tickets(1, "Test1", "Test1"));
        ticketsList.add(new Tickets(2, "Test2", "Test2"));
        ticketsList.add(new Tickets(3, "Test3", "Test3"));


        context.put("tickets", ticketsList);
        resp.setContentType("text/html");
        templateRenderer.render(LIST_TICKETS_TEMPLATE, context, resp.getWriter());
    }
}