package eu.jpereira.trainings.designpatterns.creational.builder.json;

import eu.jpereira.trainings.designpatterns.creational.builder.ReportBodyBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;

public class JSONReportBodyBuilder implements ReportBodyBuilder {
    private final JSONReportBody report;
    public JSONReportBodyBuilder(){
        this.report = new JSONReportBody();
    }
    @Override
    public void setCustomer(String name, String phone) {
        report.addContent("sale:{customer:{name:\""+name+"\",phone:\""+phone+"\"},");
    }

    @Override
    public void startItems() {
        report.addContent("items:[");
    }

    @Override
    public void newItem(String name, int quantity, double price) {
        report.addContent("{name:\""+name+"\",quantity:"+quantity+",price:"+price+"},");
    }

    @Override
    public void endItems() {
        report.removeLastComma();
        report.addContent("]}");
    }

    @Override
    public ReportBody getReportBody() {
        return report;
    }
}
