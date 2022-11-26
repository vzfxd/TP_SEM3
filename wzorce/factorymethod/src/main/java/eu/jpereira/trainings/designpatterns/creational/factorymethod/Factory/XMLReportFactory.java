package eu.jpereira.trainings.designpatterns.creational.factorymethod.Factory;

import eu.jpereira.trainings.designpatterns.creational.factorymethod.Report;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.ReportData;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.XMLReport;

public class XMLReportFactory implements ReportFactory{
    private ReportData data;
    private XMLReport report;

    public XMLReportFactory(ReportData data){
        this.data=data;
    }
    @Override
    public Report createReport() {
        report = new XMLReport();
        report.generateReport(data);
        return report;
    }
}
