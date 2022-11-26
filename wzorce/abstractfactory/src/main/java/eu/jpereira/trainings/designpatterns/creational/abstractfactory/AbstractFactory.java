package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public interface AbstractFactory{
    ReportHeader createHeader();
    ReportBody createBody();
    ReportFooter createFooter();
}
