package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public abstract class AbstractFactory {
    public abstract ReportHeader    getHeader();
    public abstract ReportBody  getBody();
    public abstract ReportFooter    getFooter();
}
