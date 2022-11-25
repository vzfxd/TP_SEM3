package eu.jpereira.trainings.designpatterns.creational.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;

public class HTMLReportBodyBuilder implements ReportBodyBuilder{
    HTMLReportBody report;

    public HTMLReportBodyBuilder(){
        report = new HTMLReportBody();
    }
    @Override
    public void setCustomer(String name, String phone) {
        report.putContent("<span class=\"customerName\">"+name+"</span><span class=\"customerPhone\">"+phone+"</span>");
    }

    @Override
    public void startItems() {
        report.putContent("<items>");
    }

    @Override
    public void newItem(String name, int quantity, double price) {
        report.putContent("<item><name>"+name+"</name><quantity>"+quantity+"</quantity><price>"+price+"</price></item>");
    }

    @Override
    public void endItems() {
        report.putContent("</items>");
    }

    @Override
    public ReportBody getReportBody() {
        return report;
    }
}
