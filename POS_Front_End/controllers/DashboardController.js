/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/

let baseUrl = "http://localhost:8080/back_End/";

$("#txtCustomerCount").val("00");
$.ajax({
    url: baseUrl + "customer?option=CustomerCount",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.count;
        $("#txtCustomerCount").text(num);

    },
    error: function (ob, statusText, error) {

    }
});

$("#txtItemsCount").val("00");
$.ajax({
    url: baseUrl + "item?option=itemCount",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.count;
        $("#txtItemsCount").text(num);

    },
    error: function (ob, statusText, error) {

    }
});

$("#txtOrderCount").val("00");
$.ajax({
    url: baseUrl + "orders?option=ordersCount",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.count;
        $("#txtOrderCount").text(num);

    },
    error: function (ob, statusText, error) {

    }
});