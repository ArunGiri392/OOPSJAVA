// // Your task is to implement an adapter pattern for a payment API to integrate with another payment API.

// // Requirements

// // Given two APIs, implement an adapter from ExternalPaymentService named ExternalPaymentServiceAdapter.

// // The ExternalPaymentService class implements the following IExternalPaymentService interface:


// public interface IExternalPaymentService
// {
//     string CreateCharge(string customerId, decimal amount);
//     void CancelCharge(string chargeId);
//     string ChargeCurrency { get; set; }
//     List<ChargeValue> PendingCharges { get; }
// }

// The ExternalPaymentService class has the following properties:

// ChargeCurrency: next charge currency ISO code (for example, USD).
// PendingCharges: array (unordered) of objects (pending charges) in the following format (note that Value consists of both Amount and Currency with a space between them):

// {
//     ChargeId: "someId",
//     CustomerId: "someOtherId",
//     Value: "20.5 USD"
// }

// and implements the following methods:

// CreateCharge(customerId, amount): creates a charge from CustomerId (string) with Amount (decimal) and current ChargeCurrency, and returns the created ChargeId.
// CancelCharge(chargeId): cancels a charge with ChargeId (string), if it exists.


// The ExternalPaymentServiceAdapter class should implement the following methods:
// CreateCharge(string customerId, decimal amount, string currency): creates a charge from customerId with amount and currency, and returns the created chargeId.

// The method should set the ChargeCurrency property of the ExternalPaymentService class to the currency parameter.

// The method should call the CreateCharge method of the ExternalPaymentService class with the customerId and amount parameters and return the result.

// CancelCharge(string chargeId): cancels the charge specified by chargeId, if it exists.

// UpdateCharge(string chargeId, decimal amount, string currency): updates the charge using the ListCharges method of the ExternalPaymentService class to find the charge with the given chargeId.

// The method uses the CancelCharge method of the ExternalPaymentService class to cancel the charge with the given chargeId.

// The method uses the CreateCharge method of the ExternalPaymentServiceAdapter class to create a new charge with the same customerId and the new amount and currency parameters and returns the created chargeId from this method.

// ListCharges(): returns an array (unordered) of objects (pending charges) in the following format:

// // {
// //     ChargeId: "someId",
// //     CustomerId: "someOtherId",
// //     Amount: 20.5,
// //     Currency: "USD"
// // }

// For any mutable operation on ExternalPaymentService charges, use the provided methods as they implement service-specific logic (like SMS notification, database entry, etc.

// Assumptions

// Assume ExternalPaymentService always works.
// Your solution will be evaluated based on its correctness; performance and coding style will not be assessed.

// The intended usage of ExternalPaymentServiceAdapter is as follows:

// // var external = new ExternalPaymentService("USD");
// // var paymentService = new ExternalPaymentServiceAdapter(external);

// // var chargeId = paymentService.CreateCharge(
// //     customerId: "someId",
// //     amount: 20.00m,
// //     currency: "USD"
// // );

// // paymentService.UpdateCharge(
// //     chargeId,
// //     amount: 30.99m,
// //     currency: "EUR"
// // );

// // var charges = paymentService.ListCharges();
// // // charges == [{ chargeId: "someId", customerId: "someOtherId", amount: 30.99, currency: "EUR"}]

// // paymentService.CancelCharge(chargeId);
// // // charges == []


// // Example effect of the CreateCharge method:
// var external = new ExternalPaymentService("USD");
// var paymentService = new ExternalPaymentServiceAdapter(external);

// var chargeId = paymentService.CreateCharge(
//     customerId: "someId",
//     amount: 20.99m,
//     currency: "USD"
// );
// // external.PendingCharges == [{ chargeId: "someGeneratedId", customerId: "someId", value: "20.99 USD"}]


// Starting point in code:
// using System.Collections.Generic;
// using System;

// namespace adapter_pattern_dotnet_solutions
// {
//     public class ExternalPaymentServiceAdapter
//     {
//         private IExternalPaymentService _externalPaymentService;

//         public ExternalPaymentServiceAdapter(IExternalPaymentService externalPaymentService)
//         {
//             _externalPaymentService = externalPaymentService;
//         }

//         public string CreateCharge(string


// customerId, decimal amount, string currency)
// {
// throw new NotImplementedException();
// }

// public void CancelCharge(string chargeId)
// {
//     throw new NotImplementedException();
// }

// public string UpdateCharge(string chargeId, decimal amount, string currency)
// {
//     throw new NotImplementedException();
// }

// public List<ChargeValue> ListCharges()
// {
//     throw new NotImplementedException();
// }
// }
