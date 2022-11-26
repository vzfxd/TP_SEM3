package eu.jpereira.trainings.designpatterns.creational.factorymethod.Factory;

import eu.jpereira.trainings.designpatterns.creational.factorymethod.JSONReport;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.Report;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.ReportData;

public class JSONReportFactory implements ReportFactory {
    private ReportData data;
    private JSONReport report;

    public JSONReportFactory(ReportData data){
        this.data=data;
    }

    @Override
    public Report createReport() {
        report = new JSONReport();
        report.generateReport(data);
        return report;
    }
}
