<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<c:set var="result" value="${fn:split(results, '~')}" />
</head>
<script type="text/javascript">
	function onLoadFun() {
		var isResultShow = '${isResultShow}';
		if (isResultShow == 'Y')
			document.getElementById('resultDiv').style.display = '';
	}

	function allowNumericOnly(){
		var numberVal = document.getElementById('numberVal').value;
		if(numberVal == null || numberVal == ''){
			return true;
		}else{
			if(numberVal > 0 && numberVal <=50){
				return true;
			}else{
				alert('Enter value between 1 and 50 only');
				document.getElementById('numberVal').value='';
				document.getElementById('numberVal').focus();
				return false;
			}
		}
	}
	
	function validate(){
		var numberVal = document.getElementById('numberVal').value;
		if(numberVal == null || numberVal == ''){
			alert('Enter any value between 1 and 50');
			document.getElementById('numberVal').focus();
			return false;
		}else{
			document.SortingApplicationForm.action= "sorted-numbers";
			document.SortingApplicationForm.submit();
		}
	}

</script>
<body>
	<form id="SortingApplicationForm"
		name="SortingApplicationForm" method="post">
		<div class="container">

			<div class="starter-template">
				<h1 align="center">Application For Sorting Numbers</h1>
			</div>
			<br> <br>
			<div>
				<table>
					<tr>
						<td>Enter the numbers you want to generate randomly (Between
							1 and 50) : </td>
						<br>
						<td><input type="text" id="numberVal" name="numberVal" onchange="allowNumericOnly()"></td>
						<td>
					<tr>
					<tr></tr>
					
					</td>
					</tr>
					</tr>
				</table>
			</div>
			<br> <br> <br>
			<div align="center">
				<table>
					<tr>
						<td><input type="submit" id="btnSort" name="btnSort"
							value="Sort" onclick="validate();"></td>
					</tr>
				</table>

			</div>

			<div id="resultDiv" style="display: none">
				<table>
					<tr>
						<td>Generated values before sorting : ${result[0]}</td>
						<br>
						<br>
					</tr>
					<tr>
						<td>Values after sorting : ${result[1]}</td>
						<br>
						<br>
					</tr>
					<tr>
						<td>Number of change of position of values required :
							${result[2]}</td>
						<br>
						<br>
					</tr>
					<tr>
						<td>Time taken to sort the values (In Mili Seconds) :
							${result[3]}</td>
						<br>
						<br>
					</tr>

				</table>
			</div>
		</div>

		<script type="text/javascript"
			src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</form>
</body>
<script type="text/javascript">
	onLoadFun();
</script>
</html>