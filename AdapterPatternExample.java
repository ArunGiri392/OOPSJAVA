// step1:
// Question Explanation:

// The task is to implement an adapter pattern for a payment API to integrate with another payment API. The adapter pattern is a structural design pattern that allows objects with incompatible interfaces to collaborate.

// Explanation:
//  In this case, we have two payment APIs: ExternalPaymentService and another unnamed API. The goal is to create an ExternalPaymentServiceAdapter that adapts the methods of ExternalPaymentService to match the interface of the other payment API.


//  step2:
//  Solution Discussion:

// To implement the adapter pattern, we'll create a class called ExternalPaymentServiceAdapter that wraps around the ExternalPaymentService and provides a unified interface for the other payment API. This adapter class will implement the methods required by the other payment API, and internally it will delegate the calls to the corresponding methods of the ExternalPaymentService instance.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// ExternalPaymentService class representing the original payment API
class ExternalPaymentService {
    private String chargeCurrency = "USD";
    private List<Charge> pendingCharges = new ArrayList<>();

    public String createCharge(String customerId, double amount) {
        String chargeId = generateRandomId();
        Charge charge = new Charge(chargeId, customerId, amount + " " + chargeCurrency);
        pendingCharges.add(charge);
        return chargeId;
    }

    public void cancelCharge(String chargeId) {
        int index = -1;
        for (int i = 0; i < pendingCharges.size(); i++) {
            if (pendingCharges.get(i).getChargeId().equals(chargeId)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            pendingCharges.remove(index);
            System.out.println("Charge with ID " + chargeId + " has been cancelled.");
        } else {
            System.out.println("Charge with ID " + chargeId + " does not exist.");
        }
    }

    private String generateRandomId() {
        return Integer.toString(new Random().nextInt(1000000), 36);
    }
}

// Charge class representing a charge
class Charge {
    private String chargeId;
    private String customerId;
    private String value;

    public Charge(String chargeId, String customerId, String value) {
        this.chargeId = chargeId;
        this.customerId = customerId;
        this.value = value;
    }

    public String getChargeId() {
        return chargeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getValue() {
        return value;
    }
}

// ExternalPaymentServiceAdapter class representing the adapter for the new payment API
class ExternalPaymentServiceAdapter {
    private ExternalPaymentService externalPaymentService;

    public ExternalPaymentServiceAdapter(ExternalPaymentService externalPaymentService) {
        this.externalPaymentService = externalPaymentService;
    }

    public String createCharge(String customerId, double amount) {
        return externalPaymentService.createCharge(customerId, amount);
    }

    public void cancelCharge(String chargeId) {
        externalPaymentService.cancelCharge(chargeId);
    }
}

// Main class to demonstrate the usage
public class AdapterPatternExample {
    public static void main(String[] args) {
        ExternalPaymentService externalPaymentService = new ExternalPaymentService();
        ExternalPaymentServiceAdapter adapter = new ExternalPaymentServiceAdapter(externalPaymentService);

        String chargeId = adapter.createCharge("customer123", 100.0);
        System.out.println("Charge ID: " + chargeId);

        adapter.cancelCharge(chargeId);
    }
}
