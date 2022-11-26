package eu.jpereira.trainings.designpatterns.creational.factorymethod.Factory;

import eu.jpereira.trainings.designpatterns.creational.factorymethod.HTMLReport;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.Report;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.ReportData;

public class HTMLReportFactory implements ReportFactory{
    private ReportData data;
    private HTMLReport report;

    public HTMLReportFactory(ReportData data){
        this.data=data;
    }
    @Override
    public Report createReport() {
        report = new HTMLReport();
        report.generateReport(data);
        return report;
    }
}
