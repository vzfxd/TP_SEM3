package eu.jpereira.trainings.designpatterns.creational.factorymethod.Factory;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.PDFReport;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.Report;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.ReportData;

public class PDFReportFactory implements ReportFactory{
    private ReportData data;
    private PDFReport report;

    public PDFReportFactory(ReportData data){
        this.data=data;
    }
    @Override
    public Report createReport() {
        report = new PDFReport();
        report.generateReport(data);
        return report;
    }
}
