<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Billing</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style>
input[type="number"] {
	appearance: textfield;
	-webkit-appearance: textfield;
	-moz-appearance: textfield;
}
</style>
</head>
<body>
	<div class="p-3 mb-2 bg-success text-white">
		<div>
			<h1>Billing page</h1>
			<hr>
			<p>
				Enter name of Customer <input type="text" name="customerName"
					placeholder="Enter Nome of customer   ">
			</p>
			<p>
				Enter the Address of Customer <input type="text" name="address"
					placeholder="Enter Nome of Customer   ">
			</p>
			<p>
				Enter Mobile number of Customer <input type="text" name="conactNo"
					placeholder=" Moblie of customer">
			</p>
			<br> <br> <input type="text" name="name"
				placeholder="Enter Nome of product" id="inputValue"> <input
				type="Button" value="Add in bill" class="btn btn-warning"
				id="findData" onclick="fetch()"> <br> <br> <br>
				
				
			 <div>
				<input name="Sno" type="text" value="Sno" readonly> 
				<input name="name" type="text" value="Product Description"readonly>
				<input name="price" type="text" value="Marked Price" readonly> 
				<input name="discount" type="Text" value="Discount"  readonly>
			    <input name="quantity" type="text" value="Quantity"  readonly>
				<input name="total" type="text"	value="Total" readonly> 
			</div>
			
			<hr>
		</div>
		<div class="row" id="OutputValue">
		<div class="purchase_list"></div>
			
		</div>
		
		<div class="row mt-4">
			<div class="col-md-6"></div>
			<div class="col-md-6">
				<div class="row">
					<div class="col-md-2">
						<div class="form-group">
							<label class="pb-1"> GST %: </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<input type="number" name="gst" value=00 class="form-control billGst"
								readonly>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="pb-1">Total GST: </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group ">
							<input type="number" name="totalGst" value=00
								class="form-control billtotalGst" readonly>
						</div>
					</div>
				</div>
				<div class="row mt-2">
					<div class="col-md-2">
						<div class="form-group">
							<label class="pb-1">Total Discount: </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<input type="number" class="form-control billDiscount" name="totalDiscount"
								value=00  readonly>
						</div>
					</div>

				</div>
				<div class="row mt-2">
					<div class="col-md-2">
						<div class="form-group">
							<label class="pb-1"> Total Price: </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<input type="number" name="totalPrice" value=00
								class="form-control billTotal"  readonly>
						</div>
					</div>

				</div>

			</div>
			<div class="row mt-4">
				<div class="col-md-2">
					<input type="button" value="Go back!" onclick="history.back()"
						class="btn btn-secondary btn-sm">
				</div>
				<div class="col-md-6">
					<a href="/billGeneration"><input type="Button"
						value="Generate Bill"></a>
				</div>

			</div>
		</div>
</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
{
	var index=0;
	}
	function fetch() {
		console.log("Inside Function");
		$.ajax({
			type : "Get",
			url : "http://localhost:7000/findstockByName",
			data : $('#inputValue'),
			success : function(results) {
				index=index+1;
				console.log("Name+:"+results.name )
				$('.purchase_list').append(
					'<div class="remove"> <input name="sno[]" type="number" value='+index+' class="Sno'+index+'" readonly> <input name="name[]" type="text" value='+results.name+' placeholder="Product Description"readonly >	<input name="price[]" type="number" value='+results.price+' placeholder="Price" class="stockPrice'+index+'" readonly>	<input name="discount[]" type="number" value='+results.discount+' placeholder="Discount" class="stockDiscount'+index+'" readonly> <input name="quantity[]" type="number" placeholder="Quantity" class="totalQty'+index+'" onchange="calculate()"> <input name="total[]" type="text" placeholder="Total" value="0" class="Amount'+index+'" readonly >	<a href="#" class="remove-field btn-remove-customer">Remove Product</a></div>');
			}
		});

	}
</script>

<script>
{
	var count=1;
	}
	function calculate() {
		var r=".stockPrice"+count;
		var gst = 18;
		var price = Number($(r).val());
		let discount = Number($(".stockDiscount"+count).val());
		let quantity = Number($(".totalQty"+count).val());
		let netPrice = 00;
		let totalSum = Number($(".billTotal").val());
		let totalDiscount = Number($(".billDiscount").val());
		let totalGst = parseFloat($(".billtotalGst").val());
		
		console.log("TotalSum  =" + totalSum + "Total Discount ="
				+ totalDiscount + "  discount=" + discount + "  price=" + price
				+ "  quantity=" + quantity);
		discount = (price * discount / 100) * quantity;
		netPrice = (price * quantity) - discount;
		console.log("Price  =" + netPrice);
		totalDiscount = discount + totalDiscount;
		totalGst = (netPrice * 0.18) + totalGst;
		console.log("Total Gst  "+totalGst);
		totalSum = totalSum + (netPrice + (netPrice * 0.18));
		console.log("TotalSum  =" + totalSum + "Total Discount ="
				+ totalDiscount);
		/* $("#Amount").val(netPrice); */
		$(".billGst").val(gst);
		$(".billDiscount").val(totalDiscount);
		$(".billTotal").val(totalSum);
		$(".billtotalGst").val(totalGst);
		$(".Amount"+count).val(netPrice);
		/* $( ".Amount" ).each(function( index ) {
			  $(this).val(netPrice);
			}); */

			count=count+1;
		
		console.log(index+"this is my index numbere");
	}
	
</script>



<script>

	    $(document).on('click', '.remove-field', function(e) {
		$(this).parent('.remove').remove();
		e.preventDefault();
	});
</Script>
</html>