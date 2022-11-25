package eu.jpereira.trainings.designpatterns.creational.builder.xml;

import eu.jpereira.trainings.designpatterns.creational.builder.ReportBodyBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;

public class XMLReportBodyBuilder implements ReportBodyBuilder {
    private final XMLReportBody report;
    public XMLReportBodyBuilder(){
        this.report = new XMLReportBody();
    }
    @Override
    public void setCustomer(String name, String phone) {
        report.putContent("<sale><customer><name>"+name+"</name><phone>"+phone+"</phone></customer>");
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
        report.putContent("</items></sale>");
    }

    @Override
    public ReportBody getReportBody() {
        return report;
    }
}
