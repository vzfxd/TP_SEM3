package eu.jpereira.trainings.designpatterns.structural.facade;

import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.*;

public class DefaultBookStoreFacade implements BookstoreFacade{
    private BookDBService bookDBService;
    private CustomerDBService customerDBService;
    private CustomerNotificationService customerNotificationService;
    private OrderingService orderingService;
    private WharehouseService wharehouseService;
    @Override
    public void placeOrder(String customerId, String isbn) {
        Customer client = customerDBService.findCustomerById(customerId);
        Book book = bookDBService.findBookByISBN(isbn);
        Order order = orderingService.createOrder(client,book);
        DispatchReceipt receipt = wharehouseService.dispatch(order);
        customerNotificationService.notifyClient(order);
        customerNotificationService.notifyClient(receipt);
    }

    public void setBookDBService(BookDBService bookDBService) {
        this.bookDBService = bookDBService;
    }

    public void setCustomerDBService(CustomerDBService customerDBService) {
        this.customerDBService = customerDBService;
    }

    public void setCustomerNotificationService(CustomerNotificationService customerNotificationService) {
        this.customerNotificationService = customerNotificationService;
    }

    public void setOrderingService(OrderingService orderingService) {
        this.orderingService = orderingService;
    }

    public void setWharehouseService(WharehouseService wharehouseService) {
        this.wharehouseService = wharehouseService;
    }
}
