package eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.AbstractFactory;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportHeader;
public class XMLFactory extends AbstractFactory {

    @Override
    public ReportHeader getHeader() {
        return new XMLReportHeader();
    }

    @Override
    public ReportBody getBody() {
        return new XMLReportBody();
    }

    @Override
    public ReportFooter getFooter() {
        return new XMLReportFooter();
    }
}
