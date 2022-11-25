package eu.jpereira.trainings.designpatterns.creational.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;

public interface ReportBodyBuilder {
    void setCustomer(String name, String phone);
    void startItems();
    void newItem(String name, int quantity, double price);
    void endItems();
    ReportBody getReportBody();
}
