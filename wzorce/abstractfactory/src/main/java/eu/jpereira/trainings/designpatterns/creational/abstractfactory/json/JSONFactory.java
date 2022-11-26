package eu.jpereira.trainings.designpatterns.creational.abstractfactory.json;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.AbstractFactory;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportHeader;

public class JSONFactory implements AbstractFactory {
    @Override
    public ReportHeader createHeader() {
        return new JSONReportHeader();
    }

    @Override
    public ReportBody createBody() {
        return new JSONReportBody();
    }

    @Override
    public ReportFooter createFooter() {
        return new JSONReportFooter();
    }
}
