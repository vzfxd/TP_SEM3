package eu.jpereira.trainings.designpatterns.creational.abstractfactory.json;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.AbstractFactory;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportHeader;

public class JSONFactory extends AbstractFactory {

    @Override
    public ReportHeader getHeader() {
        return new JSONReportHeader();
    }

    @Override
    public ReportBody getBody() {
        return new JSONReportBody();
    }

    @Override
    public ReportFooter getFooter() {
        return new JSONReportFooter();
    }
}
